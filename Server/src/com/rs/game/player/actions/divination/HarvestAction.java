package com.rs.game.player.actions.divination;

import com.rs.game.Animation;
import com.rs.game.Graphics;
import com.rs.game.item.Item;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.player.actions.Action;
import com.rs.utils.Utils;

public class HarvestAction extends Action {

    	private int value;
    	
	//private static final int[] REQUIRED_LEVELS = {1, 10, 20, 30, 40, 50, 60, 70, 80, 85, 90, 95};
	//private static final double[] EXPERIENCE = {
		/*Regular Wisps*///1, 2, 3, 4, 5, 6, 7, 8, 8.5, 9, 10, 11, 12};
		/*Enriched Wisps*///1, 4, 6, 8, 10, 12, 14, 16, 16.5, 18, 20, 22, 24};
	private static final Animation HARVEST_ANIMATION = new Animation(21231);

	private Wisp wisp;
	private boolean enriched;

	public HarvestAction(Wisp wisp) {
		this.wisp = wisp;
		this.enriched = wisp.getDefinitions().getName().contains("Enriched");
	}

	@Override
	public boolean start(Player player) {
		if(!check(player))
			return false;
		setActionDelay(player, 2);
		player.setNextAnimation(HARVEST_ANIMATION);
		return true;
	}

	@Override
	public boolean process(Player player) {
		return check(player);
	}

	@Override
	public int processWithDelay(Player player) {
	    int wispType;
	    boolean enrich = false;
		if(getOriginalId() > 18150)
			wispType = getOriginalId() == 18150 ? 1 : ((getOriginalId() - 18149) / 2 + 1);
		else
		    	wispType = 1;
			//wispType = wisp.getId() == 18150 ? 1 :((wisp.getId()-(wisp.getDefinitions().getName().contains("Enriched") ? 1 : 0) - 18149) / 2 + 1);
		player.getInventory().addItem(new Item(29312 + wispType, 1));
		int gfxId = 4235, memoryId = 29383+wispType, rate = 12-(player.getSkills().getLevel(Skills.DIVINATION) / 10);
		if(Utils.random(2) == 1)
			player.getInventory().addItem(new Item(memoryId+(enriched ? 11 : 0), 1));
		else if(Utils.random(rate) == 1 && wisp.getOriginalId() != 18150) {
			gfxId++;
			player.getInventory().addItem(memoryId + 11, 1);
			enrich = true;
		}
		player.setNextGraphics(new Graphics(gfxId));
		player.getSkills().addXp(Skills.DIVINATION, wispType * (enrich == true ? 20 : 10));
		return 2;
	}

	@Override
	public void stop(Player player) {
		player.setNextAnimation(new Animation(21229));
	}

	public boolean check(Player player) {
		return wisp.getLifeTime() > 0;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getOriginalId() {
		return wisp.getId()-23;
	}
}
