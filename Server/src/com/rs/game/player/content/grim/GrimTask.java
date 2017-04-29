package com.rs.game.player.content.grim;

import java.io.Serializable;

import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.utils.Utils;

public class GrimTask implements Serializable {


	public enum Master {
		GRIM (1, new Object[][] {
			{ "Corporal Beast", 1, 2, 10, 400.0 },
			{ "Kalphite Queen", 1, 2, 10, 200.0 },
			{ "Kree'arra", 1, 2, 10, 500.0 },
			{ "General Graardor", 1, 2, 10, 200.0 },
			{ "Kalphite King", 1, 2, 10, 300.0 },
			{ "Chaos Elemental", 1, 2, 10, 300.0 },
		});

		public static Master forId(int id) {
			for (Master master : Master.values()) {
				if (master.id == id) {
					return master;
				}
			}
			return null;
		}

		private int id;

		private Object[][] data;

		private Master(int id, Object[][] data) {
			this.id = id;
			this.data = data;
		}

		public int getId() {
			return id;
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3885979679549716755L;

	public static GrimTask random(Player player, Master master) {
		GrimTask task = null;
		while (true) {
			int random = Utils.random(master.data.length - 1);
			int requiredLevel = (Integer) master.data[random][1];
			if (player.getSkills().getLevel(Skills.SLAYER) < requiredLevel) {
				continue;
			}
			int minimum = (Integer) master.data[random][2];
			int maximum = (Integer) master.data[random][3];
			if (task == null) {
				task = new GrimTask(master, random, Utils.random(minimum,
						maximum));
				player.setTask(task);
			}
			break;
		}
		return task;
	}

	private Master master;
	private int taskId;
	private int taskAmount;

	private int amountKilled;

	public GrimTask(Master master, int taskId, int taskAmount) {
		this.master = master;
		this.taskId = taskId;
		this.taskAmount = taskAmount;
	}

	public void decreaseAmount() {
		taskAmount--;
	}

	/**
	 * @return the amountKilled
	 */
	public int getAmountKilled() {
		return amountKilled;
	}

	public Master getMaster() {
		return master;
	}

	public String getName() {
		return (String) master.data[taskId][0];
	}

	public int getTaskAmount() {
		return taskAmount;
	}

	public int getTaskId() {
		return taskId;
	}

	public int getXPAmount() {
		Object obj = master.data[taskId][4];
		if (obj instanceof Double) {
			return (int) Math.round((Double) obj);
		}
		if (obj instanceof Integer) {
			return (Integer) obj;
		}
		return 0;
	}

	/**
	 * @param amountKilled
	 *            the amountKilled to set
	 */
	public void setAmountKilled(int amountKilled) {
		this.amountKilled = amountKilled;
	}

	public void slayerShop(Player player) {
		player.getInterfaceManager().sendCentralInterface(164);
		player.getPackets().sendIComponentText(164, 20,
		player.getGrimPoints() + "");
		player.getPackets().sendIComponentText(164, 32, "(20 points)");
		player.getPackets().sendIComponentText(164, 33, "(1500 points)");
		player.getPackets().sendIComponentText(164, 34, "(35 points)");
		player.getPackets().sendIComponentText(164, 35, "(35 points)");
		player.getPackets().sendIComponentText(164, 36, "(35 points)");
	}
}