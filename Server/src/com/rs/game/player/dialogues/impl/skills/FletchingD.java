package com.rs.game.player.dialogues.impl.skills;

import com.rs.game.player.actions.Fletching2;
import com.rs.game.player.actions.Fletching2.FletchData;
import com.rs.game.player.content.SkillsDialogue;
import com.rs.game.player.content.SkillsDialogue.SkillDialogueResult;
import com.rs.game.player.dialogues.Dialogue;

public class FletchingD extends Dialogue {

	// componentId, amount, option
	
	private FletchData items;

	@Override
	public void start() {
		items = (FletchData) parameters[0];
		SkillsDialogue.sendSkillDialogueByProduce(player, items.getProduct());
	}

	@Override
	public void run(int interfaceId, int componentId) {
		SkillDialogueResult result = SkillsDialogue.getResult(player);
		FletchData finalItems = Fletching2.finalFletch(result.getProduce());
		player.getActionManager().setAction(new Fletching2(finalItems, result.getProduce(), result.getQuantity()));
		end();
	}

	@Override
	public void finish() {
	}

}
