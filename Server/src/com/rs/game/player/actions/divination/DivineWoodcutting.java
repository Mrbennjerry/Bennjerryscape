package com.rs.game.player.actions.divination;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.Animation;
import com.rs.game.World;
import com.rs.game.WorldObject;
import com.rs.game.WorldTile;
import com.rs.game.player.Player;
import com.rs.game.player.actions.Action;
import com.rs.game.player.actions.Woodcutting;
import com.rs.utils.Utils;

public final class DivineWoodcutting extends Action {

	public static enum DivineTreeDefinitions {

		DIVINE_MAGIC(75, 250, 1513, 10, 5, 37824, 121, 0),
		
		DIVINE_YEW(60, 175, 1515, 10, 5, 1341, 94, 10),
		
		DIVINE_MAPLE(45, 100, 1517, 10, 5, 31057, 72, 10),
		
		DIVINE_WILLOW(30, 67.5, 1519, 10, 5, 1341, 51, 15),
		
		DIVINE_OAK(15, 37.5, 1521, 10, 5, 1341, 15, 15),
		
		DIVINE_NORMAL(1, 25, 1511, 10, 5, 1341, 8, 0);
		
		private int level;
		private double xp;
		private int logsId;
		private int logBaseTime;
		private int logRandomTime;
		private int stumpId;
		private int respawnDelay;
		private int randomLifeProbability;

		private DivineTreeDefinitions(int level, double xp, int logsId,
				int logBaseTime, int logRandomTime, int stumpId,
				int respawnDelay, int randomLifeProbability) {
			this.level = level;
			this.xp = xp;
			this.logsId = logsId;
			this.logBaseTime = logBaseTime;
			this.logRandomTime = logRandomTime;
			this.stumpId = stumpId;
			this.respawnDelay = respawnDelay;
			this.randomLifeProbability = randomLifeProbability;
		}

		public int getLevel() {
			return level;
		}

		public double getXp() {
			return xp;
		}

		public int getLogsId() {
			return logsId;
		}

		public int getLogBaseTime() {
			return logBaseTime;
		}

		public int getLogRandomTime() {
			return logRandomTime;
		}

		public int getStumpId() {
			return stumpId;
		}

		public int getRespawnDelay() {
			return respawnDelay;
		}

		public int getRandomLifeProbability() {
			return randomLifeProbability;
		}
	}

	private WorldObject tree;
	private DivineTreeDefinitions definitions;

	private int emoteId;
	private boolean usingBeaver = false;
	private int axeTime;
	private Player owner;

	public DivineWoodcutting(WorldObject tree, DivineTreeDefinitions definitions, Player owner) {
	    this.owner = owner;
		this.tree = tree;
		this.definitions = definitions;
	}

	@Override
	public boolean start(Player player) {
		if (!checkAll(player))
			return false;

		setActionDelay(player, getWoodcuttingDelay(player));
		return true;
	}

	private int getWoodcuttingDelay(Player player) {
		int summoningBonus = player.getFamiliar() != null ? (player
				.getFamiliar().getId() == 6808 || player.getFamiliar().getId() == 6807) ? 10
				: 0
				: 0;
		int wcTimer = definitions.getLogBaseTime()
				- (player.getSkills().getLevel(8) + summoningBonus)
				- Utils.getRandom(axeTime);
		if (wcTimer < 1 + definitions.getLogRandomTime())
			wcTimer = 1 + Utils.getRandom(definitions.getLogRandomTime());
		wcTimer /= player.getAuraManager().getWoodcuttingAccurayMultiplier();
		return wcTimer;
	}

	private boolean checkAll(Player player) {
	    if (Woodcutting.getHatchet(player, false) == null) {
		player.getPackets().sendGameMessage("You dont have the required level to use that axe or you don't have a hatchet.");
		return false;
	}
		if (!hasWoodcuttingLevel(player))
			return false;
		if (!player.getInventory().hasFreeSlots()) {
			player.getPackets().sendGameMessage(
					"Not enough space in your inventory.");
			return false;
		}
		return true;
	}

	private boolean hasWoodcuttingLevel(Player player) {
		if (definitions.getLevel() > player.getSkills().getLevel(8)) {
			player.getPackets().sendGameMessage(
					"You need a woodcutting level of " + definitions.getLevel()
							+ " to chop down this tree.");
			return false;
		}
		return true;
	}

	@Override
	public boolean process(Player player) {
		player.setNextAnimation(new Animation(usingBeaver ? 1 : Woodcutting.getHatchet(player, false).getEmoteId()));
		return checkTree(player);
	}

	private boolean usedDeplateAurora;

	@Override
	public int processWithDelay(Player player) {
		addLog(player);
		if (!usedDeplateAurora && (1 + Math.random()) < player.getAuraManager().getChanceNotDepleteMN_WC()) {
			usedDeplateAurora = true;
		} else if (Utils.getRandom(definitions.getRandomLifeProbability()) == 0 && definitions != DivineTreeDefinitions.DIVINE_MAGIC && definitions != DivineTreeDefinitions.DIVINE_YEW && definitions != DivineTreeDefinitions.DIVINE_MAPLE && definitions != DivineTreeDefinitions.DIVINE_WILLOW && definitions != DivineTreeDefinitions.DIVINE_OAK && definitions != DivineTreeDefinitions.DIVINE_NORMAL) {
			long time = definitions.respawnDelay * 600;
			World.spawnTemporaryObject(new WorldObject(definitions.getStumpId(), tree.getType(),tree.getRotation(), tree.getX(), tree.getY(), tree.getPlane()), time);
			if (tree.getPlane() < 3) {
				WorldObject object = World.getStandartObject(new WorldTile(tree.getX() - 1, tree.getY() - 1, tree.getPlane() + 1));

				if (object == null) {
					object = World.getStandartObject(new WorldTile(tree.getX(), tree.getY() - 1, tree.getPlane() + 1));
					if (object == null) {
						object = World.getStandartObject(new WorldTile(tree.getX() - 1,tree.getY(), tree.getPlane() + 1));
						if (object == null) {
							object = World.getStandartObject(new WorldTile(tree.getX(),tree.getY(), tree.getPlane() + 1));
						}
					}
				}

				if (object != null)
					World.removeTemporaryObject(object, time, false);
			}
			player.setNextAnimation(new Animation(-1));
			return -1;
		}
		if (!player.getInventory().hasFreeSlots()) {
			player.setNextAnimation(new Animation(-1));
			player.getPackets().sendGameMessage(
					"Not enough space in your inventory.");
			return -1;
		}
		return getWoodcuttingDelay(player);
	}

	private void addLog(Player player) {
		double xpBoost = 1.00;
		if (player.getEquipment().getChestId() == 10939)
			xpBoost += 0.008;
		if (player.getEquipment().getLegsId() == 10940)
			xpBoost += 0.006;
		if (player.getEquipment().getHatId() == 10941)
			xpBoost += 0.004;
		if (player.getEquipment().getBootsId() == 10933)
			xpBoost += 0.002;
		if (player.getEquipment().getChestId() == 10939
				&& player.getEquipment().getLegsId() == 10940
				&& player.getEquipment().getHatId() == 10941
				&& player.getEquipment().getBootsId() == 10933)
			xpBoost += 0.005;
		player.getSkills().addXp(8, definitions.getXp() * xpBoost);
		if(player == owner) {
		    player.getInventory().addItem(definitions.getLogsId(), 1);
		    String logName = ItemDefinitions.getItemDefinitions(definitions.getLogsId()).getName().toLowerCase();
		    player.getPackets().sendGameMessage("You get some " + logName + ".", true);
		} else {
		    String logName = ItemDefinitions.getItemDefinitions(definitions.getLogsId()).getName().toLowerCase();
		    if (Utils.random(10) >= 6) {
                        owner.getInventory().addItem(definitions.getLogsId()+1, 1);
                        owner.getPackets().sendGameMessage(""+player.getUsername()+" chopped some "+logName+" for you."); 
                        }
		    player.getInventory().addItem(definitions.getLogsId(), 1);
		    player.getPackets().sendGameMessage("You get some " + logName + ".", true);
		}
			// todo infernal adze
	}

    private boolean checkTree(Player player) {
	return World.containsObjectWithId(tree, tree.getId());
    }

	@Override
	public void stop(Player player) {
		setActionDelay(player, 3);
	}

}