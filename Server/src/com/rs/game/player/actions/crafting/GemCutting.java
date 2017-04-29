package com.rs.game.player.actions.crafting;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.Animation;
import com.rs.game.item.Item;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.player.actions.Action;
import com.rs.net.decoders.handlers.InventoryOptionsHandler;
import com.rs.utils.Utils;

public class GemCutting extends Action {

	/**
	 * Enum for gems
	 * 
	 * @author Raghav
	 * 
	 */
	public enum Gem {
		OPAL(1625, 1609, 15.0, 1, 886, 25124),//crystal chisel 32642

		JADE(1627, 1611, 20, 13, 886, 25124),

		RED_TOPAZ(1629, 1613, 25, 16, 892, 25123),

		SAPPHIRE(1623, 1607, 50, 20, 888, 25121),

		EMERALD(1621, 1605, 67, 27, 889, 25122),

		RUBY(1619, 1603, 85, 34, 887, 25123),

		DIAMOND(1617, 1601, 107.5, 43, 890, 25124),

		DRAGONSTONE(1631, 1615, 137.5, 55, 885, 25125),

		ONYX(6571, 6573, 167.5, 67, 2717, 25126),
		
		HYRDIX(31853, 31855, 197.5, 79, -1, 25127),

		GRAY_SHELL_ROUND(3345, 3327, 35.5, 15, -1, -1),

		RED_AND_BLACK_SHELL_ROUND(3347, 3329, 35.5, 15, -1, -1),

		OCHRE_SHELL_ROUND(3349, 3331, 35.5, 15, -1, -1),

		BLUE_SHELL_ROUND(3351, 3333, 35.5, 15, -1, -1),

		BROKEN_SHELL_ROUND(3353, 3335, 35.5, 15, -1, -1),

		GRAY_SHELL_POINTY(3355, 3337, 35.5, 15, -1, -1),

		RED_AND_BLACK_SHELL_POINTY(3357, 3339, 35.5, 15, -1, -1),

		OCHRE_SHELL_POINTY(3359, 3341, 35.5, 15, -1, -1),

		BLUE_SHELL_POINTY(3361, 3343, 35.5, 15, -1, -1);

		private double experience;
		private int levelRequired;
		private int uncut, cut;

		private int emote, crystalEmote;

		private Gem(int uncut, int cut, double experience, int levelRequired, int emote, int crystalEmote) {
			this.uncut = uncut;
			this.cut = cut;
			this.experience = experience;
			this.levelRequired = levelRequired;
			this.emote = emote;
			this.crystalEmote = crystalEmote;
		}

		public int getLevelRequired() {
			return levelRequired;
		}

		public double getExperience() {
			return experience;
		}

		public int getUncut() {
			return uncut;
		}

		public int getCut() {
			return cut;
		}

		public int getEmote() {
			return emote;
		}
		
		public int getCrystalEmote() {
		    	return crystalEmote;
		}

	}

	public static boolean isCutting(Player player, Item item1, Item item2) {
		Item gem = InventoryOptionsHandler.contains(1755, item1, item2);
		if (gem == null)
			return false;
		return isCutting(player, gem.getId());
	}
	
	/**
	 * 
	 * @author Nolan
	 * Craft Option for Gems
	 * 
	 */
	  public static boolean isCuttingOne(Player player, int uncut) {
	       for (Gem gem : Gem.values()) {
	           if (!player.getInventory().containsItem(1755, 1)){
                         player.getPackets().sendGameMessage("You do not have the required items to do this.");
	                return false;
	                }       
		   if (gem.getUncut() == uncut){
	                player.getDialogueManager().startDialogue("GemCuttingD", gem);
	                return true;
	                }
	           }
	         return false;
	     }

	private static boolean isCutting(Player player, int gemId) {
		for (Gem gem : Gem.values()) {
			if (gem.uncut == gemId) {
				cut(player, gem);
				return true;
			}
		}
		return false;
	}
	
	public static Gem getGem( int gemId) {
		for (Gem gem : Gem.values()) {
			if (gem.uncut == gemId) {
				return gem;
			}
		}
		return null;
	}
	
	public static Gem getGemByProduce( int gemId) {
		for (Gem gem : Gem.values()) {
			if (gem.cut == gemId) {
				return gem;
			}
		}
		return null;
	}

	public static void cut(Player player, Gem gem) {
		if (player.getInventory().getItems().getNumberOf(new Item(gem.getUncut(), 1)) <= 1) // contains
			// just
			// 1 lets start
			player.getActionManager().setAction(new GemCutting(gem, 1));
		else
			player.getDialogueManager().startDialogue("GemCuttingD", gem);
	}

	private Gem gem;
	private int quantity;

	public GemCutting(Gem gem, int quantity) {
		this.gem = gem;
		this.quantity = quantity;
	}

	public boolean checkAll(Player player) {
		if (!player.getInventory().containsItemToolBelt(1755)) {
			player.getPackets().sendGameMessage("You do not have the required items to cut this.");
			return false;
		}
		if (player.getSkills().getLevel(Skills.CRAFTING) < gem.getLevelRequired()) {
			player.getDialogueManager().startDialogue("SimpleMessage", "You need a crafting level of " + gem.getLevelRequired() + " to cut that gem.");
			return false;
		}
		if (!player.getInventory().containsOneItem(gem.getUncut())) {
			player.getDialogueManager().startDialogue("SimpleMessage", "You don't have any " + ItemDefinitions.getItemDefinitions(gem.getUncut()).getName().toLowerCase() + " to cut.");
			return false;
		}
		return true;
	}

	@Override
	public boolean start(Player player) {
		if (checkAll(player)) {
			setActionDelay(player, 1);
			 if (player.getEquipment().getWeaponId() == 32642 || player.getInventory().containsItem(32642, 1))
			     player.setNextAnimation(new Animation(gem.getCrystalEmote()));
			 else 
			     player.setNextAnimation(new Animation(gem.getEmote()));
			return true;
		}
		return false;
	}

	@Override
	public boolean process(Player player) {
		return checkAll(player);
	}

	@Override
	public int processWithDelay(Player player) {
	    if (player.getEquipment().getWeaponId() == 32642 || player.getInventory().containsItem(32642, 1))  {//crystal chisel
		player.getInventory().deleteItem(gem.getUncut(), 1);
		player.getInventory().addItem(gem.getCut(), 1);
		player.getSkills().addXp(Skills.CRAFTING, gem.getExperience());
		player.getPackets().sendGameMessage("You cut the " + ItemDefinitions.getItemDefinitions(gem.getUncut()).getName().toLowerCase() + ".", true);
		if (gem.getUncut() == 1623 || gem.getUncut() == 1621 || gem.getUncut() == 1619 || gem.getUncut() == 1617 || gem.getUncut() == 1631) {//sapphire - dragonstone
		    if (Utils.random(1, 50) == 1) {
			if (player.getInventory().hasFreeSlots()) {
			    player.getInventory().addItem(gem.getCut(), 1);//todo durability loss, prolly not
			    player.getPackets().sendGameMessage("Your crystal chisel nets you an additional gem.", true);
			} else {
			    player.getBank().addItem(gem.getCut(), 1, true);
			    player.getPackets().sendGameMessage("Your crystal chisel banks you an additional gem.", true);
			}
		    }	
		}
		quantity--;
		if (quantity <= 0)
			return -1;
		player.setNextAnimation(new Animation(gem.getCrystalEmote()));
		return 0;
		
	    } else {
		player.getInventory().deleteItem(gem.getUncut(), 1);
		player.getInventory().addItem(gem.getCut(), 1);
		player.getSkills().addXp(Skills.CRAFTING, gem.getExperience());
		player.getPackets().sendGameMessage("You cut the " + ItemDefinitions.getItemDefinitions(gem.getUncut()).getName().toLowerCase() + ".", true);
		quantity--;
		if (quantity <= 0)
			return -1;
		player.setNextAnimation(new Animation(gem.getEmote())); // start the
		// emote and add
		// 2 delay
		return 0;
	    }
	}

	@Override
	public void stop(final Player player) {
		setActionDelay(player, 3);
	}
}
