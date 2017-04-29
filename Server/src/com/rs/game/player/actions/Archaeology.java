package com.rs.game.player.actions;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.Animation;
import com.rs.game.World;
import com.rs.game.WorldObject;
import com.rs.game.player.Equipment;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.player.actions.mining.MiningBase;
import com.rs.game.player.actions.mining.Mining.RockDefinitions;
import com.rs.game.player.actions.mining.MiningBase.PickAxeDefinitions;
import com.rs.utils.Utils;

public final class Archaeology {

	public static enum SearchDefinitions {
	    
	    /**
	     * 11175 Uncleaned find
	     */

		Clay_Ore(1, 5, 434, 10, 1, 11552, 5, 0);

		private int delay;
		private int anim;
		private int archPoints; 

		private SearchDefinitions() {
			
		}

		public int getLevel() {
			return level;
		}
	}

	private WorldObject rock;
	private RockDefinitions definitions;
	private PickAxeDefinitions axeDefinitions;

	public Mining(WorldObject rock, RockDefinitions definitions) {
		this.rock = rock;
		this.definitions = definitions;
	}

	@Override
	public boolean start(Player player) {
		axeDefinitions = getPickAxeDefinitions(player, false);
		if (!checkAll(player))
			return false;
		player.getPackets().sendGameMessage("You swing your pickaxe at the rock.", true);
		setActionDelay(player, getMiningDelay(player));
		return true;
	}

	private int getMiningDelay(Player player) {
		int summoningBonus = 0;
		if (player.getFamiliar() != null) {
			if (player.getFamiliar().getId() == 7342 || player.getFamiliar().getId() == 7342)
				summoningBonus += 10;
			else if (player.getFamiliar().getId() == 6832 || player.getFamiliar().getId() == 6831)
				summoningBonus += 1;
		}
		int mineTimer = definitions.getOreBaseTime() - (player.getSkills().getLevel(Skills.MINING) + summoningBonus) - Utils.getRandom(axeDefinitions.getPickAxeTime());
		if (mineTimer < 1 + definitions.getOreRandomTime())
			mineTimer = 1 + Utils.getRandom(definitions.getOreRandomTime());
		mineTimer /= player.getAuraManager().getMininingAccurayMultiplier();
		return mineTimer;
	}

	private boolean checkAll(Player player) {
		if (axeDefinitions == null) {
			player.getPackets().sendGameMessage("You do not have a pickaxe or do not have the required level to use the pickaxe.");
			return false;
		}
		if (!hasMiningLevel(player))
			return false;
		if (!player.getInventory().hasFreeSlots()) {
			player.getPackets().sendGameMessage("Not enough space in your inventory.");
			return false;
		}
		return true;
	}

	private boolean hasMiningLevel(Player player) {
		if (definitions.getLevel() > player.getSkills().getLevel(Skills.MINING)) {
			player.getPackets().sendGameMessage("You need a mining level of " + definitions.getLevel() + " to mine this rock.");
			return false;
		}
		return true;
	}

	@Override
	public boolean process(Player player) {
		player.setNextAnimation(new Animation(axeDefinitions.getAnimationId()));
		return checkRock(player);
	}

	private boolean usedDeplateAurora;

	@Override
	public int processWithDelay(Player player) {
		addOre(player);
		if (definitions.getEmptyId() != -1) {
			if (!usedDeplateAurora && (1 + Math.random()) < player.getAuraManager().getChanceNotDepleteMN_WC()) {
				usedDeplateAurora = true;
			} else if (Utils.getRandom(definitions.getRandomLifeProbability()) == 0) {
				World.spawnObjectTemporary(new WorldObject(definitions.getEmptyId(), rock.getType(), rock.getRotation(), rock.getX(), rock.getY(), rock.getPlane()), definitions.respawnDelay * 600, false, true);
				player.setNextAnimation(new Animation(-1));
				return -1;
			}
		}
		if (!player.getInventory().hasFreeSlots() && definitions.getOreId() != -1) {
			player.setNextAnimation(new Animation(-1));
			player.getPackets().sendGameMessage("Not enough space in your inventory.");
			return -1;
		}
		return getMiningDelay(player);
	}

	private void addOre(Player player) {
		double xpBoost = 0;
		int idSome = 0;
		if (definitions == RockDefinitions.Granite_Ore) {
			idSome = Utils.getRandom(2) * 2;
			if (idSome == 2)
				xpBoost += 10;
			else if (idSome == 4)
				xpBoost += 25;
		} else if (definitions == RockDefinitions.Sandstone_Ore) {
			idSome = Utils.getRandom(3) * 2;
			xpBoost += idSome / 2 * 10;
		} else if (definitions == RockDefinitions.RedSandStone) {
			if (player.getRedStoneDelay() >= Utils.currentTimeMillis()) {
				player.getPackets().sendGameMessage("It seems that there is no remaining ore, check again in twelve hours.");
				stop(player);
				return;
			}
			player.increaseRedStoneCount();
			if (player.getRedStoneCount() >= (player.isExtremeDonator() ? 225 : player.isDonator() ? 150 : 75)) {
				player.resetRedStoneCount();
				player.setStoneDelay(3600000 * 24); // 12 hours
				player.getVarsManager().sendVarBitOld(10133, 26);
			} else if (player.getRedStoneCount() == 125)
				player.getVarsManager().sendVarBitOld(10133, 25);
		}
		double totalXp = definitions.getXp() + xpBoost;
		if (hasMiningSuit(player))
			totalXp *= 1.025;
		player.getSkills().addXp(Skills.MINING, totalXp);
		if (definitions.getOreId() != -1) {
		    if (definitions.getOreId() == 434 && player.getEquipment().getItem(Equipment.SLOT_HANDS) != null && player.getEquipment().getItem(Equipment.SLOT_HANDS).getId() == 11074) {
			player.getInventory().addItem(1761, 1);
		    } else {
			player.getInventory().addItem(definitions.getOreId() + idSome, 1);
		    }
			if ((Utils.currentTimeMillis() - player.getLastStarSprite()) <= 15*60*1000)
				player.getInventory().addItem(definitions.getOreId() + idSome, 1);
			String oreName = ItemDefinitions.getItemDefinitions(definitions.getOreId() + idSome).getName().toLowerCase();
			player.getPackets().sendGameMessage("You mine some " + oreName + ".", true);
			if (Utils.random(150) == 0)
				player.getInventory().addItemDrop(UNCUT_GEMS[Utils.random(UNCUT_GEMS.length - 2)], 1);
		}
	}

	private boolean hasMiningSuit(Player player) {
		if (player.getEquipment().getHatId() == 20789 && player.getEquipment().getChestId() == 20791 && player.getEquipment().getLegsId() == 20790 && player.getEquipment().getBootsId() == 20788)
			return true;
		return false;
	}

	private boolean checkRock(Player player) {
		return World.containsObjectWithId(rock, rock.getId());
	}
}