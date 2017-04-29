package com.rs.game.player.actions;

import com.rs.Settings;
import com.rs.game.Animation;
import com.rs.game.WorldObject;
import com.rs.game.item.Item;
import com.rs.game.player.Equipment;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.utils.Utils;

public class Smelting extends Action {

	public enum SmeltingBar {

		BRONZE(1, 6.2, new Item[]
		{ new Item(436), new Item(438) }, new Item(2349), Skills.SMITHING),

		BLURITE(8, 8.0, new Item[]
		{ new Item(668) }, new Item(9467), Skills.SMITHING),

		IRON(15, 12.5, new Item[]
		{ new Item(440) }, new Item(2351), Skills.SMITHING),

		SILVER(20, 13.7, new Item[]
		{ new Item(442) }, new Item(2355), Skills.SMITHING),

		STEEL(30, 17.5, new Item[]
		{ new Item(440), new Item(453, 2) }, new Item(2353), Skills.SMITHING),

		GOLD(40, 22.5, new Item[]
		{ new Item(444) }, new Item(2357), Skills.SMITHING),

		MITHRIL(50, 30, new Item[]
		{ new Item(447), new Item(453, 4) }, new Item(2359), Skills.SMITHING),

		ADAMANT(70, 37.5, new Item[]
		{ new Item(449), new Item(453, 6) }, new Item(2361), Skills.SMITHING),

		RUNE(85, 50, new Item[]
		{ new Item(451), new Item(453, 8) }, new Item(2363), Skills.SMITHING),

		NOVITE(1, 7, new Item[]
		{ new Item(17630) }, new Item(17650), Skills.SMITHING),

		BATHUS(10, 13.3, new Item[]
		{ new Item(17632) }, new Item(17652), Skills.SMITHING),

		MARMAROS(20, 19.6, new Item[]
		{ new Item(17634) }, new Item(17654), Skills.SMITHING),

		KRATONITE(30, 25.9, new Item[]
		{ new Item(17636) }, new Item(17656), Skills.SMITHING),

		FRACTITE(40, 32.2, new Item[]
		{ new Item(17638) }, new Item(17658), Skills.SMITHING),

		ZEPHYRIUM(50, 38.5, new Item[]
		{ new Item(17640) }, new Item(17660), Skills.SMITHING),

		ARGONITE(60, 44.8, new Item[]
		{ new Item(17642) }, new Item(17662), Skills.SMITHING),

		KATAGON(70, 51.1, new Item[]
		{ new Item(17644) }, new Item(17664), Skills.SMITHING),

		GORGONITE(80, 57.4, new Item[]
		{ new Item(17646) }, new Item(17666), Skills.SMITHING),

		PROMETHIUM(90, 63.7, new Item[]
		{ new Item(17648) }, new Item(17668), Skills.SMITHING),

		CANNON_BALLS(35, 25.6, new Item[]
		{ new Item(2353, 1), new Item(4, 1) }, new Item(2, 4), Skills.SMITHING),

		MOLTEN_GLASS(1, 20, new Item[]
		{ new Item(1783, 1), new Item(1781, 1) }, new Item(1775, 1), Skills.CRAFTING),

		SILVER_SICKLE(18, 50, new Item[]
		{ new Item(2355, 1), new Item(2976, 1) }, new Item(2961, 1), Skills.CRAFTING),

		HOLY_SYMBOL(16, 50, new Item[]
		{ new Item(2355, 1), new Item(1599, 1) }, new Item(1718, 1), Skills.CRAFTING),

		UNHOLY_SYMBOL(16, 50, new Item[]
		{ new Item(2355, 1), new Item(1594, 1) }, new Item(1724, 1), Skills.CRAFTING),

		UNCHARGED_TIARA(23, 52.5, new Item[]
		{ new Item(2355, 1), new Item(5523, 1) }, new Item(5525, 1), Skills.CRAFTING),
		
		GOLD_RING(5, 15, new Item[]
		{ new Item(2357, 1) }, new Item(1635), Skills.CRAFTING),
		
		GOLD_NECKLACE(6, 20, new Item[]
			{ new Item(2357, 1) }, new Item(1654), Skills.CRAFTING),
		
		GOLD_BRACELET(7, 25, new Item[]
			{ new Item(2357, 1) }, new Item(11069), Skills.CRAFTING),
		
		GOLD_AMULET(8, 30, new Item[]
			{ new Item(2357, 1) }, new Item(1673), Skills.CRAFTING),
		
		SAPPHIRE_RING(20, 40, new Item[]
			{ new Item(2357, 1), new Item(1607) }, new Item(1637), Skills.CRAFTING),
		
		SAPPHIRE_NECKLACE(22, 55, new Item[]
			{ new Item(2357, 1), new Item(1607) }, new Item(1656), Skills.CRAFTING),
		
		SAPPHIRE_BRACELET(23, 60, new Item[]
			{ new Item(2357, 1), new Item(1607) }, new Item(1675), Skills.CRAFTING),
		
		SAPPHIRE_AMULET(24, 65, new Item[]
			{ new Item(2357, 1), new Item(1607) }, new Item(11072), Skills.CRAFTING),
		
		EMERALD_RING(27, 55, new Item[]
			{ new Item(2357, 1), new Item(1605) }, new Item(1639), Skills.CRAFTING),
		
		EMERALD_NECKLACE(29, 60, new Item[]
			{ new Item(2357, 1), new Item(1605) }, new Item(1658), Skills.CRAFTING),
		
		EMERALD_BRACELET(30, 65, new Item[]
			{ new Item(2357, 1), new Item(1605) }, new Item(1677), Skills.CRAFTING),
		
		EMERALD_AMULET(31, 70, new Item[]
			{ new Item(2357, 1), new Item(1605) }, new Item(11076), Skills.CRAFTING),
		
		RUBY_RING(34, 70, new Item[]
			{ new Item(2357, 1), new Item(1603) }, new Item(1641), Skills.CRAFTING),
		
		RUBY_NECKLACE(40, 75, new Item[]
			{ new Item(2357, 1), new Item(1603) }, new Item(1660), Skills.CRAFTING),
		
		RUBY_BRACELET(42, 80, new Item[]
			{ new Item(2357, 1), new Item(1603) }, new Item(1679), Skills.CRAFTING),
		
		RUBY_AMULET(50, 85, new Item[]
			{ new Item(2357, 1), new Item(1603) }, new Item(11085), Skills.CRAFTING),
		
		DIAMOND_RING(43, 85, new Item[]
			{ new Item(2357, 1), new Item(1601) }, new Item(1643), Skills.CRAFTING),
		
		DIAMOND_NECKLACE(56, 90, new Item[]
			{ new Item(2357, 1), new Item(1601) }, new Item(1662), Skills.CRAFTING),
		
		DIAMOND_BRACELET(58, 95, new Item[]
			{ new Item(2357, 1), new Item(1601) }, new Item(1681), Skills.CRAFTING),
		
		DIAMOND_AMULET(70, 100, new Item[]
			{ new Item(2357, 1), new Item(1601) }, new Item(11092), Skills.CRAFTING),
		
		DRAGONSTONE_RING(55, 100, new Item[]
			{ new Item(2357, 1), new Item(1615) }, new Item(1645), Skills.CRAFTING),
		
		DRAGONSTONE_NECKLACE(72, 105, new Item[]
			{ new Item(2357, 1), new Item(1615) }, new Item(1664), Skills.CRAFTING),
		
		DRAGONSTONE_BRACELET(74, 110, new Item[]
			{ new Item(2357, 1), new Item(1615) }, new Item(1683), Skills.CRAFTING),
		
		DRAGONSTONE_AMULET(80, 150, new Item[]
			{ new Item(2357, 1), new Item(1615) }, new Item(11115), Skills.CRAFTING),
		
		ONYX_RING(67, 115, new Item[]
			{ new Item(2357, 1), new Item(6573) }, new Item(6575), Skills.CRAFTING),
		
		ONYX_NECKLACE(82, 120, new Item[]
			{ new Item(2357, 1), new Item(6573) }, new Item(6577), Skills.CRAFTING),
		
		ONYX_BRACELET(84, 125, new Item[]
			{ new Item(2357, 1), new Item(6573) }, new Item(6579), Skills.CRAFTING),
		
		ONYX_AMULET(90, 165, new Item[]
			{ new Item(2357, 1), new Item(6573) }, new Item(11130), Skills.CRAFTING),
		
		HYDRIX_RING(79, 130, new Item[]
			{ new Item(2357, 1), new Item(31855) }, new Item(31857), Skills.CRAFTING),
		
		HYDRIX_NECKLACE(90, 135, new Item[]
			{ new Item(2357, 1), new Item(31855) }, new Item(31859), Skills.CRAFTING),
		
		HYDRIX_BRACELET(94, 140, new Item[]
			{ new Item(2357, 1), new Item(31855) }, new Item(31865), Skills.CRAFTING),
		
		HYDRIX_AMULET(99, 180, new Item[]
			{ new Item(2357, 1), new Item(31855) }, new Item(31861), Skills.CRAFTING),
		
		SLAYER_RING(75, 15, new Item[]
			{ new Item(2357, 1), new Item(4155) }, new Item(13281), Skills.CRAFTING),;

		public static SmeltingBar getBarByProduce(int id) {
			for(SmeltingBar bar : SmeltingBar.values()) {
				if(bar.getProducedBar().getId() == id)
					return bar;
			}
			return null;
		}
		
		public static SmeltingBar getBar(int id) {
			for(SmeltingBar bar : SmeltingBar.values()) {
				for(Item item : bar.getItemsRequired())
				if(item.getId() == id)
					return bar;
			}
			return null;
		}

		private int levelRequired;
		private double experience;
		private Item[] itemsRequired;
		private Item producedBar;
		private int skillType;

		private SmeltingBar(int levelRequired, double experience, Item[] itemsRequired, Item producedBar, int skillType) {
			this.levelRequired = levelRequired;
			this.experience = experience;
			this.itemsRequired = itemsRequired;
			this.producedBar = producedBar;
			this.skillType = skillType;
		}

		public Item[] getItemsRequired() {
			return itemsRequired;
		}

		public int getLevelRequired() {
			return levelRequired;
		}

		public Item getProducedBar() {
			return producedBar;
		}

		public double getExperience() {
			return experience;
		}

		public int getSkillType() {
			return skillType;
		}
	}

	public SmeltingBar bar;
	public WorldObject object;
	public int ticks;

	public Smelting(SmeltingBar bar, WorldObject object, int ticks) {
		this.object = object;
		this.bar = bar;
		this.ticks = ticks;
	}

	@Override
	public boolean start(Player player) {
		if (bar == null || player == null || object == null) {
			return false;
		}
		if (!player.getInventory().containsItemToolBelt(bar.getItemsRequired()[0].getId(), bar.getItemsRequired()[0].getAmount())) {
			player.getPackets().sendGameMessage("You need " + bar.getItemsRequired()[0].getDefinitions().getName() + " to create a " + bar.getProducedBar().getDefinitions().getName() + ".");
			return false;
		}
		if (bar.getItemsRequired().length > 1) {
			if (!player.getInventory().containsItemToolBelt(bar.getItemsRequired()[1].getId(), bar.getItemsRequired()[1].getAmount())) {
				player.getPackets().sendGameMessage("You need " + bar.getItemsRequired()[1].getDefinitions().getName() + " to create a " + bar.getProducedBar().getDefinitions().getName() + ".");
				return false;
			}
		}
		if (player.getSkills().getLevel(bar.getSkillType()) < bar.getLevelRequired()) {
			player.getPackets().sendGameMessage("You need a Smithing level of at least " + bar.getLevelRequired() + " to smelt " + bar.getProducedBar().getDefinitions().getName());
			return false;
		}
		player.getPackets().sendGameMessage("You place the required ores and attempt to create a bar of " + bar.getProducedBar().getDefinitions().getName().toLowerCase().replace(" bar", "") + ".", true);
		return true;
	}

	@Override
	public boolean process(Player player) {
		if (bar == null || player == null || object == null) {
			return false;
		}
		if (!player.getInventory().containsItemToolBelt(bar.getItemsRequired()[0].getId(), bar.getItemsRequired()[0].getAmount())) {
			player.getPackets().sendGameMessage("You need " + bar.getItemsRequired()[0].getDefinitions().getName() + " to create a " + bar.getProducedBar().getDefinitions().getName() + ".");
			return false;
		}
		if (bar.getItemsRequired().length > 1) {
			if (!player.getInventory().containsItemToolBelt(bar.getItemsRequired()[1].getId(), bar.getItemsRequired()[1].getAmount())) {
				player.getPackets().sendGameMessage("You need " + bar.getItemsRequired()[1].getDefinitions().getName() + " to create a " + bar.getProducedBar().getDefinitions().getName() + ".");
				return false;
			}
		}
		if (player.getSkills().getLevel(bar.getSkillType()) < bar.getLevelRequired()) {
			player.getPackets().sendGameMessage("You need a Smithing level of at least " + bar.getLevelRequired() + " to smelt " + bar.getProducedBar().getDefinitions().getName());
			return false;
		}
		player.faceObject(object);
		return true;
	}

	public boolean isSuccessFull(Player player) {
		if (bar == SmeltingBar.IRON) {
			if (player.getEquipment().getItem(Equipment.SLOT_RING) != null && player.getEquipment().getItem(Equipment.SLOT_RING).getId() == 2568) {
				return true;
			} else {
				return Utils.getRandom(100) <= (player.getSkills().getLevel(bar.getSkillType()) >= 45 ? 80 : 50);
			}
		}
		return true;
	}

	@Override
	public int processWithDelay(Player player) {
	    if (bar == SmeltingBar.CANNON_BALLS) {
	    	    ticks = player.getInventory().getAmountOf(2353);
	    }
		ticks--;
		if (bar == SmeltingBar.BRONZE || bar == SmeltingBar.IRON ||  bar == SmeltingBar.BLURITE ||  bar == SmeltingBar.SILVER ||  bar == SmeltingBar.STEEL 
			||  bar == SmeltingBar.GOLD ||  bar == SmeltingBar.MITHRIL ||  bar == SmeltingBar.ADAMANT ||  bar == SmeltingBar.RUNE)
		player.setNextAnimation(new Animation(24975));
		else 
		player.setNextAnimation(new Animation(24976));
		double xp = bar.getExperience();
		if (bar == SmeltingBar.GOLD && player.getEquipment().getGlovesId() == 776)
			xp *= 2;
		player.getSkills().addXp(bar.getSkillType(), xp);
		for (Item required : bar.getItemsRequired()) {
			if (required.getId() == 4 || required.getId() == 2976 || required.getId() == 1594 || required.getId() == 1599 || required.getId() == 5523)
				continue;
			player.getInventory().deleteItem(required.getId(), required.getAmount());
		}
		if (isSuccessFull(player)) {
			int amount = bar.getProducedBar().getAmount();
			if (bar.getProducedBar().getDefinitions().isStackable())
				amount *= Settings.getCraftRate();
			if (bar == SmeltingBar.MOLTEN_GLASS)
				player.getInventory().addItem(new Item(1925));
			player.getInventory().addItem(bar.getProducedBar().getId(), amount);
			player.getPackets().sendGameMessage("You retrieve a bar of " + bar.getProducedBar().getDefinitions().getName().toLowerCase().replace(" bar", "") + ".", true);
		} else {
			player.getPackets().sendGameMessage("The ore is too impure and you fail to refine it.", true);
		}
		if (ticks > 0) {
			return 1;
		}
		return -1;
	}

	@Override
	public void stop(Player player) {
		setActionDelay(player, 3);
	}
}
