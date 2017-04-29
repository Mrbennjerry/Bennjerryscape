package com.rs.game.player.dialogues.impl.skills;


import com.rs.game.WorldObject;
import com.rs.game.player.content.SkillsDialogue;
import com.rs.game.player.content.SkillsDialogue.SkillDialogueResult;
import com.rs.game.player.content.Summoning;
import com.rs.game.player.content.Summoning.Pouch;
import com.rs.game.player.dialogues.Dialogue;

/**
 * 
 * @author Dylan Doldersum || Mystic Wolf
 * Apr 1, 2016
 */
public class SummoningD extends Dialogue {

	private WorldObject object;

	@Override
	public void start() {
		object = (WorldObject) parameters[0];
		Pouch pouch = (Pouch) parameters[1];
		SkillsDialogue.sendSkillDialogueByProduce(player, pouch.getRealPouchId());
	}

	@Override
	public void run(int interfaceId, int componentId) {
		SkillDialogueResult result = SkillsDialogue.getResult(player);
		end();
		Pouch pouch = Pouch.getPouchByProduce(result.getProduce());
		if(pouch == null)
			return;
		player.getActionManager().setAction(new Summoning(pouch, object, result.getQuantity()));
		player.getPackets().sendGameMessage(""+result.getQuantity()+"");
	}

	@Override
	public void finish() {
	}
}
