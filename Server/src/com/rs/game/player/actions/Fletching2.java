package com.rs.game.player.actions;

import com.rs.Settings;
import com.rs.cache.loaders.ItemDefinitions;
import com.rs.game.Animation;
import com.rs.game.item.Item;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.player.actions.crafting.GemCutting.Gem;
import com.rs.utils.Logger;

public class Fletching2 extends Action {

	public static final int LEVEL_OPCODE = 2645;

	public static final int BASE_OPCODE = 2655;

	public static final int PERMENANT_SECONDARY_OPCODE = 2650;

	public static final int REMOVEABLE_SECONDARY_OPCODE = 2656;

	public static final int EXPERIENCE_OPCODE = 2697;

	public static final int CREATION_COUNT_OPCODE = 2653;

	private static final int[] PRODUCTS = {2861, 52, 53, 54, 60, 64, 68, 72, 806, 839, 841, 877, 879, 882, 2864, 2866, 9174, 9446, 9450, 10158, 10159, 16867, 16427, 17742, 25982, 25983, 25984,
		25985, 25986, 25987, 25988, 25989, 25990, 17747, 21364, 21582, 24122, 29736, 30574, 841, 839, 25894, 25917, 25932, 25478, 9454, 9456, 9457, 9459, 9461, 9463, 9465, 9193, 31867, 21353,
		29734, 29736, 33665, 33667, 33668, 33669, 29611, 29614, 4150, 21640, 21645, 21650, 21655, 11212, 29617, 28464, 28463, 28465, 4773, 4778, 4783, 4788, 4793, 4798, 4803, 880, 9335, 9336, 9337,
		9338, 9339, 9340, 9341, 9342, 881, 31868, 892, 890, 888, 886, 884, 4150, 25921, 25923, 25925, 25927, 25929, 9176, 9418, 9187, 9188, 9189, 9190, 9191, 9192, 9194, 45, 46, 845, 855, 857, 859, 861,
		851, 853, 845, 843, 847, 849};

	private final FletchData data;
	private int product, cycles, incrementPerCycle, level;
	private double experience;

	public Fletching2(FletchData data, int product, int cycles) {
		this.data = data;
		this.product = product;
		this.cycles = cycles;
		ItemDefinitions defs = ItemDefinitions.getItemDefinitions(product);
		this.incrementPerCycle = defs.getCSOpcode(CREATION_COUNT_OPCODE);
		this.level = defs.getCSOpcode(LEVEL_OPCODE);
		this.experience = defs.getCSOpcode(EXPERIENCE_OPCODE) / 10.0;
	}

	public boolean checkAll(Player player) {
	    player.getPackets().sendGameMessage(""+cycles+"");
		if (player.getSkills().getLevel(Skills.FLETCHING) < level)
			return false;
		else if (!player.getSlayerManager().hasLearnedBroad()) {
			if (product == 4160 || product == 13280) {
				player.getPackets().sendGameMessage("You lack the knowledge to create a broad accessory, perhaps a Slayer Master could assist you.");
				return false;
			}
		}
		return continueNextCycle(player);
	}
	
	public int getAnimation(int product) {
	    if (product == 841)//shortbow
		return 24945;
	    if (product == 839)//longbow
		return 24952;
	    if (product == 843)//oak short
		return 24946;
	    if (product == 845)//oak long
		return 24953;
	    if (product == 849)//willow short
		return 24947;
	    if (product == 847)//willow long
		return 24954;
	    if (product == 853)//maple short
		return 24948;
	    if (product == 851)//maple long
		return 24955;
	    if (product == 857)//yew short
		return 24949;
	    if (product == 855)//yew long
		return 24956;
	    if (product == 8561)//magic short
		return 24950;
	    if (product == 859)//magic long
		return 24957;
	    if (product == 68 || product == 66 || product == 9452)//yew logs
		return 24938;
	    if (product == 72 || product == 70 || product == 25483)//magic logs
		return 24939;
	    if (product == 62 || product == 64 || product == 9448)//maple
		return 24943;
	    if (product == 48 || product == 50 || product == 9440 || product == 52)//normal
		return 24940;
	    if (product == 54 || product == 56 || product == 9442)//oak
		return 24940;//temp
	    if (product == 58 || product == 60 || product == 9444)//willow
		return 24940;//temp
	    if (product == 9189)//sapphire bolt tips
		return 888;
	    if (product == 9188)//topaz
		return 892;
	    if (product == 9187)//jade
		return 886;
	    if (product == 9190)//emerald
		return 889;
	    if (product == 9191)//ruby
		return 887;
	    if (product == 9192)//diamond
		return 890;
	    if (product == 9193)//dragon
		return 885;
	    if (product == 9194)//onyx
		return 2717;
	    return 24940;  
	}

	@Override
	public boolean start(Player player) {
		if (!checkAll(player))
			return false;
		return true;
	}

	@Override
	public boolean process(Player player) {
		return continueNextCycle(player) && cycles > 0;
	}

	private boolean continueNextCycle(Player player) {
		return player.getInventory().containsItemToolBelt(data.getSecondary()) && player.getInventory().containsItem(data.getNode(), 1);
	}

	@Override
	public int processWithDelay(Player player) {
	    	if (product == 9193 || product == 52 || product == 45 || product == 46 || product == 9187 || product == 9188
	    		 || product == 9189 || product == 9190 || product == 9191 || product == 9192 || product == 9194 || product == 31867
	    		 || product == 2861 || product == 10158 || product == 10159 || product == 21353 || product == 33667 || product == 33668
	    		 || product == 2864 || product == 45 || product == 46)
	    	    cycles = player.getInventory().getAmountOf(data.getNode());
	    	if (product == 21364) {
	    	    if (player.getInventory().getAmountOf(data.getNode()) > player.getInventory().getAmountOf(data.getSecondary())) {
	    		cycles = player.getInventory().getAmountOf(data.getNode()/5);
	    	    } else {
	    		cycles = player.getInventory().getAmountOf(data.getSecondary()/5);
	    	    }
	    	}
		cycles--;
		boolean isShaft = product == 52 || product == 9193 || product == 9187 || product == 9188 || product == 9189 || product == 9190 || product == 9191
			 || product == 9192 || product == 9194 || product == 31867 || product == 46 || product == 45;
		if (incrementPerCycle > 0) {
			if (data.canDeleteSecondary()) {
				int nodeCount = player.getInventory().getAmountOf(data.getNode());
				int secondaryCount = player.getInventory().getAmountOf(data.getSecondary());
				if (!isShaft) {
					if (nodeCount < incrementPerCycle)
						incrementPerCycle = nodeCount;
					if (secondaryCount < incrementPerCycle)
						incrementPerCycle = secondaryCount;
				}
			}
		} else
			incrementPerCycle = 1;
		if (data.canDeleteSecondary())
			player.getInventory().deleteItem(data.getSecondary(), incrementPerCycle);
		player.getInventory().deleteItem(data.getNode(), isShaft ? 1 : incrementPerCycle);
		player.getSkills().addXp(Skills.FLETCHING, experience * incrementPerCycle);
		player.getInventory().addItem(product, incrementPerCycle * (incrementPerCycle != 1 ? Settings.getCraftRate() : incrementPerCycle));
		player.setNextAnimation(new Animation(getAnimation(product)));

		//You carefully cut the wood into a Shieldbow (u).
		//You add a string to the bow.

		//TODO animation and message display.
		return 4;
	}

	@Override
	public void stop(Player player) {
		setActionDelay(player, 3);
	}

	public static FletchData isFletching(int material) {
		for (int product : PRODUCTS) {
			ItemDefinitions defs = ItemDefinitions.getItemDefinitions(product);
			int secondary = defs.getCSOpcode(PERMENANT_SECONDARY_OPCODE);
			if (secondary == 0)
				continue;
			int nodeId = defs.getCSOpcode(BASE_OPCODE);
			if (nodeId == material)
				return new FletchData(product, nodeId, secondary, secondary == 0);
		}
		return null;
	}

	public static FletchData isFletchingCombination(Item node, Item secondary) {
		for (int product : PRODUCTS) {
			ItemDefinitions defs = ItemDefinitions.getItemDefinitions(product);
			int nodeId = defs.getCSOpcode(BASE_OPCODE);
			int fixedSecondaryId = defs.getCSOpcode(PERMENANT_SECONDARY_OPCODE);
			int removeableSecondaryId = defs.getCSOpcode(REMOVEABLE_SECONDARY_OPCODE);
			if (fixedSecondaryId == 0 && removeableSecondaryId == 0)
				removeableSecondaryId = 314;//Feather isn't in cache idk why
			if (node.getId() == nodeId && (secondary.getId() == fixedSecondaryId || secondary.getId() == removeableSecondaryId))
				return new FletchData(product, nodeId, secondary.getId(), fixedSecondaryId == 0);
			else if ((node.getId() == fixedSecondaryId || node.getId() == removeableSecondaryId) && secondary.getId() == nodeId)
				return new FletchData(product, secondary.getId(), nodeId, fixedSecondaryId == 0);
		}
		return null;
	}
	
	public static FletchData finalFletch(int product) {
			ItemDefinitions defs = ItemDefinitions.getItemDefinitions(product);
			int nodeId = defs.getCSOpcode(BASE_OPCODE);
			int fixedSecondaryId = defs.getCSOpcode(PERMENANT_SECONDARY_OPCODE);
			int removeableSecondaryId = defs.getCSOpcode(REMOVEABLE_SECONDARY_OPCODE);
			if (fixedSecondaryId == 0 && removeableSecondaryId == 0 && product == 53 || product == 806 || product == 807 || product == 808 ||
				 product == 809 || product == 810 || product == 811 || product == 11230 || product == 25909 || product == 25910 || product == 25911 ||
				 product == 25912 || product == 25913 || product == 25914 || product == 25915 || product == 25916 || product == 877 || product == 53 || product == 8882 ||
				 product == 9139 || product == 9140 || product == 9141 || product == 9142 || product == 9143 || product == 9144 || product == 9145 || product == 13280 ||
				 product == 21660 || product == 21665 || product == 21670 || product == 21675)
				removeableSecondaryId = 314;//Feather isn't in cache idk why
			if (fixedSecondaryId == 0)
			    return new FletchData(product, nodeId, removeableSecondaryId, fixedSecondaryId == 0);
			if (removeableSecondaryId == 0)
			    return new FletchData(product, nodeId, fixedSecondaryId, fixedSecondaryId == 0);
			else
			    return new FletchData(product, nodeId, 0, fixedSecondaryId == 0);
	}

	public static class FletchData {
		private int product;
		private final int node;
		private final int secondary;
		private final boolean deleteSecondary;

		public FletchData(int product, int node, int secondary, boolean deleteSecondary) {
			System.out.println(product);
			this.product = product;
			this.node = node;
			this.secondary = secondary;
			this.deleteSecondary = deleteSecondary;
		}

		public int getProduct() {
			return product;
		}

		public int getNode() {
			return node;
		}

		public int getSecondary() {
			return secondary;
		}

		public boolean canDeleteSecondary() {
			return deleteSecondary;
		}
	}
}
