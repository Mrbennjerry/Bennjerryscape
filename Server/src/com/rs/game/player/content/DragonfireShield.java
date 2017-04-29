package com.rs.game.player.content;

import com.rs.game.Animation;
import com.rs.game.Graphics;
import com.rs.game.player.Equipment;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.player.actions.Smithing;

public class DragonfireShield {

	public static void joinPieces(Player player) {
		if (player.getSkills().getLevel(Skills.SMITHING) < 90) {
			player.getDialogueManager().startDialogue("SimpleMessage", "You need a Smithing level of 90 to forge a dragonfire shield.");
			return;
		}
		if (!player.getInventory().containsItem(1540, 1)) {
			player.getDialogueManager().startDialogue("SimpleMessage", "You need a anti-dragon shield to forge a dragonfire shield.");
			return;
		}
		if (!player.getInventory().containsItem(11286, 1)) {
			player.getDialogueManager().startDialogue("SimpleMessage", "You need a dragonic visage to forge a dragonfire shield.");
			return;
		}
		player.lock(2);
		player.setNextAnimation(new Animation(898));
		player.getInventory().deleteItem(1540, 1);
		player.getInventory().deleteItem(11286, 1);
		player.getInventory().addItem(11284, 1);
		player.getSkills().addXp(Skills.SMITHING, 2000);
		player.getDialogueManager().startDialogue("SimpleDialogue", "Even for an experienced smith it is not an easy task, but eventually it is done.");
	}

	public static void chargeDFS(Player player, boolean fully) {
		int shieldId = player.getEquipment().getShieldId();
		if (shieldId != 11284 && shieldId != 11283 && shieldId != 25558 && shieldId != 25559
			&& shieldId != 25561 && shieldId != 25562)
			return;
		int dfsId = shieldId;
		if (shieldId == 11284) {
			player.getEquipment().getItem(Equipment.SLOT_SHIELD).setId(11283);
			player.getEquipment().refresh(Equipment.SLOT_SHIELD);
			player.getAppearence().generateAppearenceData();
		}
		if (shieldId == 25559) {
			player.getEquipment().getItem(Equipment.SLOT_SHIELD).setId(25558);
			player.getEquipment().refresh(Equipment.SLOT_SHIELD);
			player.getAppearence().generateAppearenceData();
		}
		if (shieldId == 25562) {
			player.getEquipment().getItem(Equipment.SLOT_SHIELD).setId(25561);
			player.getEquipment().refresh(Equipment.SLOT_SHIELD);
			player.getAppearence().generateAppearenceData();
		}
		if (player.getCharges().getCharges(dfsId) == 50) {
			player.getPackets().sendGameMessage("Your dragonfire shield is already full.", true);
			return;
		}
		player.getCharges().addCharges(dfsId, fully ? 50 : 1, Equipment.SLOT_SHIELD);
		player.getCombatDefinitions().refreshBonuses();
		player.setNextAnimationNoPriority(new Animation(6695));
		player.setNextGraphics(new Graphics(1164));
		player.getPackets().sendGameMessage("Your dragonfire shield glows brightly.", true);
	}

	public static void empty(Player player) {
	    int dfsId = player.getEquipment().getShieldId();
		player.lock(1);
		player.getCharges().addCharges(dfsId, -50, -1);
		player.setNextGraphics(new Graphics(1168));
		player.setNextAnimation(new Animation(6700));
		player.getPackets().sendGameMessage("You empty your dragonfire shield.");
	}

	public static boolean isDragonFireShield(int id) {
		if (id == 1540 || id == 11286)
			return true;
		return false;
	}
}
