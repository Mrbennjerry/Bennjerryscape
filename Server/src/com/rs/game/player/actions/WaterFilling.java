package com.rs.game.player.actions;

import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.Animation;
import com.rs.game.item.Item;
import com.rs.game.player.Player;

public class WaterFilling extends Action {

	public enum Fill {
		VIAL(229, 227),
		BOWL(1923, 1921),
		BUCKET(1925, 1929),
		JUG(1935, 1937),
		CLAY(434, 1761),
		WATERSKIN(1831, 1823),
		CUP_OF_WATER(1980, 4458),
		WATERING_CAN(5331, 5340),
		FISHBOWL(6667, 6668),
		JUJU_VIAL(19996, 19994),
		GOLD_BOWL(721, 723),
		BLESSED_GOLD_BOWL(722, 725),
		VIAL_LUNAR(9085, 9086),
		DREAM_VIAL(11151, 11152),
		DUNGEONEERING_VIAL(17490, 17492),
		BREAD_DOUGH(1933, 2307),
		PASTRY_DOGUH(1933, 1953),
		PIZZA_BASE(1933, 2283),
		PITTA_DOUGH(1933, 1863),
		;

		private int empty, full;

		private Fill(int empty, int full) {
			this.empty = empty;
			this.full = full;
		}

		public int getEmpty() {
			return empty;
		}

		public int getFull() {
			return full;
		}

	}

	public static Fill getFillByProduce(int produce) {
		for (Fill fill : Fill.values()) {
			if(fill.full == produce)
				return fill;
		}
		return null;
	}
	
	public static boolean isFilling(Player player, int empty, boolean isSpot) {
		for (Fill fill : Fill.values()) {
			if (fill.empty == empty) {
				if (isSpot && fill.ordinal() <= 4)
					return false;
				fill(player, fill);
				return true;
			}
		}
		return false;
	}

	private static void fill(Player player, Fill fill) {
		if (player.getInventory().getItems().getNumberOf(new Item(fill.empty, 1)) <= 1) // contains
			// just
			// 1 lets start
			player.getActionManager().setAction(new WaterFilling(fill, 1));
		else
			player.getDialogueManager().startDialogue("WaterFillingD", fill);
	}

	private Fill fill;
	private int quantity;

	public WaterFilling(Fill fill, int quantity) {
		this.fill = fill;
		this.quantity = quantity;
	}

	public boolean checkAll(Player player) {
		if (!player.getInventory().containsOneItem(fill.empty)) {
			player.getDialogueManager().startDialogue("SimpleMessage", "You don't have any " + ItemDefinitions.getItemDefinitions(fill.empty).getName().toLowerCase() + " to fill.");
			return false;
		}
		return true;
	}

	@Override
	public boolean start(Player player) {
		if (checkAll(player)) {
			setActionDelay(player, 1);
			player.setNextAnimation(new Animation(832));
			String name = ItemDefinitions.getItemDefinitions(fill.full).getName();
			if (name.contains(" ("))
				name = name.substring(0, name.indexOf(" ("));
			player.getPackets().sendGameMessage("You fill the " + name + ".");
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
		player.getInventory().deleteItem(fill.empty, 1);
		player.getInventory().addItem(fill.full, 1);
		quantity--;
		if (quantity <= 0)
			return -1;
		player.setNextAnimation(new Animation(fill.ordinal() == 5 ? 2272 : 832));
		return fill.ordinal() == 5 ? 3 : 0;
	}

	@Override
	public void stop(final Player player) {
		setActionDelay(player, 3);
	}
}
