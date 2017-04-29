package com.rs.game.player.dialogues.impl;

import com.rs.game.player.actions.divination.Weaving;
import com.rs.game.player.actions.divination.Weaving.Energy;
import com.rs.game.player.content.SkillsDialogue;
import com.rs.game.player.content.SkillsDialogue.SkillDialogueResult;
import com.rs.game.player.dialogues.Dialogue;

public class WeaveD extends Dialogue{

	@Override
	public void start() {
		Energy energy = (Energy) parameters[0];
		SkillsDialogue.sendSkillDialogueByProduce(player, energy.getProduct());
	}

	@Override
	public void run(int interfaceId, int componentId) {
		SkillDialogueResult result = SkillsDialogue.getResult(player);
		end();
		Energy energy = Weaving.getEnergyByProduce(result.getProduce());
		if(energy == null)
			return;
		player.getActionManager().setAction(new Weaving(energy, result.getQuantity()));
	}

	@Override
	public void finish() {

	}

}
