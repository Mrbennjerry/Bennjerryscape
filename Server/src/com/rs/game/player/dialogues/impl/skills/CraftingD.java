package com.rs.game.player.dialogues.impl.skills;

import com.rs.game.WorldObject;
import com.rs.game.player.actions.crafting.Crafting;
import com.rs.game.player.actions.crafting.Crafting.ForgingBar;
import com.rs.game.player.content.SkillsDialogue;
import com.rs.game.player.content.SkillsDialogue.SkillDialogueResult;
import com.rs.game.player.dialogues.Dialogue;

public class CraftingD extends Dialogue {

    private WorldObject object;


    public int type;
    public boolean dungeoneering;

    @Override
	public void start() {
		object = (WorldObject) parameters[0];
		ForgingBar bar = (ForgingBar) parameters[1];
		SkillsDialogue.sendSkillDialogueByProduce(player, bar.getProducedItem().getId());
	}

	@Override
	public void run(int interfaceId, int componentId) {
		SkillDialogueResult result = SkillsDialogue.getResult(player);
		end();
		ForgingBar bar = ForgingBar.getBarByProduce(result.getProduce());
		if(bar == null)
			return;
		player.getActionManager().setAction(new Crafting(bar, object, result.getQuantity()));
		player.getPackets().sendGameMessage("pre"+result.getQuantity()+"");
	}

	@Override
	public void finish() {
	}

    public WorldObject getObject() {
	return object;
    }

    public void setObject(WorldObject object) {
	this.object = object;
    }

}
