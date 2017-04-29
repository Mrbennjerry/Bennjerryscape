package com.rs.game.player.actions.skills;

import java.util.stream.IntStream;

import com.rs.game.Animation;
import com.rs.game.item.Item;
import com.rs.game.player.Player;
import com.rs.game.player.actions.Action;
import com.rs.game.player.actions.skills.SkillConstants;
import com.rs.game.player.actions.skills.SkillConstants.Constants;

public class SkillProcess extends Action{
    
    /**
     * Class that handles the new interface crafting
     * Pulls values from SkillConstants
     */
    
    private int ticks;
    public Constants constants;

    public SkillProcess(Constants constants, int ticks) {
	this.constants = constants;
	this.ticks = ticks;
    }
    
    /*
     * Checks to see if either of the two items used together are listed in the enum as
     * required for anything
     */
    public static boolean isCrafting(Player player, Item item1, Item item2) {
	for (Constants item : Constants.values()) {
	    boolean contains = IntStream.of(SkillConstants.antiUseWith).anyMatch(x -> x == item.getProduct().getId());
	    for (Item required : item.getItemsRequired()) {
		if (required.getId() == item1.getId() || required.getId() == item2.getId()) {
		    if (contains == true) 
			return false;
		    if (item.getObject() != -1)
			return false;
		    player.getDialogueManager().startDialogue("SkillsD", item);
			return true;
		    
		}
	    }
	}
    	return false;
    	}
    
    /*
     * Checks if the left clicked item is used for any recipes
     */
    public static boolean isCrafting(Player player, int itemId) {
	for (Constants item : Constants.values()) {
	    boolean contains = IntStream.of(SkillConstants.antiUse).anyMatch(x -> x == itemId);
	    for (Item required : item.getItemsRequired()) {
		if (required.getId() == itemId) {
		    if (contains == true)
			return false;
		    if (item.getObject() != -1)
			return false;
		    player.getDialogueManager().startDialogue("SkillsD", item);
		    return true;
	    	}
	    }
    	}
    	return false;
    }
    
    /*
     * Same as isCrafting(player, itemId), just minus the antiUse check
     * Used for items like anchovies so you can still eat them
     */
    public static boolean isGrinding(Player player, int itemId) {
	for (Constants item : Constants.values()) {
	    for (Item required : item.getItemsRequired()) {
		if (required.getId() == itemId) {
		    if (item.getObject() != -1)
			return false;
		    player.getDialogueManager().startDialogue("SkillsD", item);
		    return true;
	    	}
	    }
	}
	return false;
    }
    
    /*
     * isCrafting w/o the object and antiUse check
     */
    public static boolean isCraftingObj(Player player, int itemId, int obj) {
	for (Constants item : Constants.values()) {
	    for (Item required : item.getItemsRequired()) {
		if (required.getId() == itemId && obj == item.getObject()) {
		    player.getDialogueManager().startDialogue("SkillsD", item);
		    return true;
		}
	    }
	}
	return false;
    }
    
    /*
     * Used when you click an object
     * Checks to see if any items in the enum use that object, then sends the interface
     */
    public static boolean sendObjCraft(Player player, int obj) {
	for (Constants item : Constants.values()) {
	    if (item.getObject() == obj) {
		player.getDialogueManager().startDialogue("SkillsD", item);
		return true;
	    }
	}
	return false;
    }
    
    /*
     * Used for tanning only
     */
    public static void sendTanning(Player player) {
	Constants[] item = Constants.values();
	player.getDialogueManager().startDialogue("SkillsD", item);
    }

    @Override
    public boolean start(Player player) {
	if (constants == null || player == null) {
	    return false;
	}
	/*
	 * Checks to see if you have the required items and amount
	 */
	for (Item required : constants.getItemsRequired()) {
	    if (required.getAmount() > player.getInventory().getAmountOf(required.getId())) {
		if (required.getId() != 995) {
		    player.getPackets().sendGameMessage("You don't have the required materials to make " + constants.getProduct().getDefinitions().getName() + ".");
		    return false;
		}
	    }
	}
	if (constants.getItemsRequired().length > 1) {
	    int coins = player.getInventory().getCoinsAmount();
	    if (!player.getInventory().containsItemToolBelt(constants.getItemsRequired()[0].getId(), constants.getItemsRequired()[0].getAmount()) && constants.getItemsRequired()[1].getId() != 995) {
		player.getPackets().sendGameMessage("You need " + constants.getItemsRequired()[0].getAmount() + " " + constants.getItemsRequired()[0].getDefinitions().getName() + "'s to create " + constants.getProduct().getDefinitions().getName() + ".");
		return false;
	    }
	    if (constants.getItemsRequired()[1].getId() == 995) {
		if (coins < constants.getItemsRequired()[1].getAmount()) {
		    player.getPackets().sendGameMessage("You don't have enough conins to pay for that.");
		    return false;
		}
	    }
	}
	if (constants.getItemsRequired().length > 2) {
	    int coins = player.getInventory().getCoinsAmount();
	    if (!player.getInventory().containsItemToolBelt(constants.getItemsRequired()[1].getId(), constants.getItemsRequired()[1].getAmount()) && constants.getItemsRequired()[1].getId() != 995) {
		player.getPackets().sendGameMessage("You need " + constants.getItemsRequired()[1].getAmount() + " " + constants.getItemsRequired()[1].getDefinitions().getName() + "'s to create a " + constants.getProduct().getDefinitions().getName() + ".");
		return false;
	    }
	    if (constants.getItemsRequired()[1].getId() == 995) {
		if (coins < constants.getItemsRequired()[1].getAmount()) {
		    player.getPackets().sendGameMessage("You don't have enough coins to pay for that.");
		    return false;
		}
	    }
	}
	if (player.getSkills().getLevel(constants.getSkill()) < constants.getLevel()) {
	    player.getPackets().sendGameMessage("You need a ... level of at least " + constants.getLevel() + " to create " + constants.getProduct().getDefinitions().getName());
	    return false;
	}
	player.getPackets().sendGameMessage("end of start.", true);
	return true;
    }

    @Override
    public boolean process(Player player) {
	if (constants == null || player == null) {
	    return false;
	}
	return true;
    }
    
    public int setTicks() {
	int []requiredItem;
	int []requiredAmount;
	for (Item required : constants.getItemsRequired()) {
	//    requiredItem.length;	    
	}
	return ticks;	
    }

    @Override
    public int processWithDelay(Player player) {
	//if (bar.getSecond() == 227 || bar.getStarter() == 227)
	//    ticks = player.getInventory().getAmountOf(227);
	//if (bar.getSecond() == 21776 || bar.getStarter() == 21776)
	//    ticks = player.getInventory().getAmountOf(21776);
	//if (constants.getProduct().getId() == 2509)
	//    ticks = player.getInventory().getAmountOf(1747);
	ticks--;
	player.getPackets().sendGameMessage(""+ticks+"");
	player.setNextAnimation(new Animation(constants.getAnim()));
	double xp = constants.getExperience() * 1;
	player.getSkills().addXp(constants.getSkill(), xp);	
	
	for (Item required : constants.getItemsRequired()) {
	    if (required.getId() == 4 || required.getId() == 2976 || required.getId() == 1594 || required.getId() == 1599 || required.getId() == 5523)
		continue;
	    if (required.getId() != 995) {
	    player.getInventory().deleteItem(required.getId(), required.getAmount());
	    } else {
		player.getMoneyPouch().sendDynamicInteraction(required.getAmount(), true, 2);
	    }
	    if (required.getId() == 1933) {
		player.getInventory().addItem(1931, 1);
	    } else if (required.getId() == 1937) {
		player.getInventory().addItem(1935, 1);
	    }
	}
	int amount = constants.getProduct().getAmount();
	if (constants.getProduct().getDefinitions().isStackable())
	    amount *= 1;
	player.getInventory().addItem(constants.getProduct().getId(), amount);  
	player.getPackets().sendGameMessage("You have successfully created a " + constants.getProduct().getDefinitions().getName() + ".", true);
	if (ticks > 0) {
		return constants.getCraftTime();
	}
	return -1;
    }

    @Override
    public void stop(Player player) {
	setActionDelay(player, 3);
    }

}
