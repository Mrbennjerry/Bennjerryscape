package com.rs.game.minigames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rs.game.Animation;
import com.rs.game.Entity;
import com.rs.game.Graphics;
import com.rs.game.World;
import com.rs.game.WorldObject;
import com.rs.game.WorldTile;
import com.rs.game.npc.spiders.Araxxi;
import com.rs.game.player.Player;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
import com.rs.utils.Utils;

public final class AraxxiFight {

    /***
     * 
     * @author Jas-Humbzian
     *
     */

    public static Araxxi araxxi = new Araxxi(19457, new WorldTile(4536, 6264, 2), -1, true, true);
    private static final List<Player> players = Collections.synchronizedList(new ArrayList<Player>());
    private static int webId = 0;
    private static boolean burnedWeb;
    private static long timer;
    public static long exit;
    private static boolean burningWeb;

    public static int getPlayersCount() {
	return players.size();
    }

    public static List<Player> getPlayers() {
	return players;
    }

    public static void teleportPlayers() {
	for (Player p : AraxxiFight.getPlayers()) {
	    p.setNextWorldTile(new WorldTile(4591, 6259, 1));
	}
    }

    public static void webTimer() {

	for (Player p : AraxxiFight.getPlayers()) {
	    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 60 seconds!</col>");
	}

	WorldTasksManager.schedule(new WorldTask() {
	    int loop;

	    @Override
	    public void run() {
		if (loop == 0) {

		} else if (loop == 5) {
		    if (Utils.currentTimeMillis() == timer - 30000) {
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 30 seconds!</col>");
			}
		    }

		    if (Utils.currentTimeMillis() >= timer) {
			removeWeb();
			araxxi.setForceFollowClose(true);
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=e3560e>Procee d down the Path!</col>");
			}
		    }
		} else if (loop == 10) {
		    if (Utils.currentTimeMillis() == timer - 30000) {
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 30 seconds!</col>");
			}
		    }

		    if (Utils.currentTimeMillis() >= timer) {
			removeWeb();
			araxxi.setForceFollowClose(true);
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=e3560e>Procee d down the Path!</col>");
			}
		    }
		} else if (loop == 15) {
		    if (Utils.currentTimeMillis() == timer - 30000) {
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 30 seconds!</col>");
			}
		    }

		    if (Utils.currentTimeMillis() >= timer) {
			removeWeb();
			araxxi.setForceFollowClose(true);
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=e3560e>Procee d down the Path!</col>");
			}
		    }
		} else if (loop == 20) {
		    if (Utils.currentTimeMillis() == timer - 30000) {
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 30 seconds!</col>");
			}
		    }

		    if (Utils.currentTimeMillis() >= timer) {
			removeWeb();
			araxxi.setForceFollowClose(true);
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=e3560e>Procee d down the Path!</col>");
			}
		    }
		} else if (loop == 25) {
		    if (Utils.currentTimeMillis() == timer - 30000) {
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 30 seconds!</col>");
			}
		    }

		    if (Utils.currentTimeMillis() >= timer) {
			removeWeb();
			araxxi.setForceFollowClose(true);
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=e3560e>Procee d down the Path!</col>");
			}
		    }
		} else if (loop == 30) {
		    if (Utils.currentTimeMillis() == timer - 30000) {
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 30 seconds!</col>");
			}
		    }

		    if (Utils.currentTimeMillis() >= timer) {
			removeWeb();
			araxxi.setForceFollowClose(true);
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=e3560e>Procee d down the Path!</col>");
			}
		    }
		} else if (loop == 35) {
		    if (Utils.currentTimeMillis() == timer - 30000) {
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 30 seconds!</col>");
			}
		    }

		    if (Utils.currentTimeMillis() >= timer) {
			removeWeb();
			araxxi.setForceFollowClose(true);
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=e3560e>Procee d down the Path!</col>");
			}
		    }
		} else if (loop == 40) {
		    if (Utils.currentTimeMillis() == timer - 30000) {
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 30 seconds!</col>");
			}
		    }

		    if (Utils.currentTimeMillis() >= timer) {
			removeWeb();
			araxxi.setForceFollowClose(true);
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=e3560e>Procee d down the Path!</col>");
			}
		    }
		} else if (loop == 50) {
		    if (Utils.currentTimeMillis() == timer - 30000) {
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=1fe12c>The web will burn down in 30 seconds!</col>");
			}
		    }

		    if (Utils.currentTimeMillis() >= timer) {
			removeWeb();
			araxxi.setForceFollowClose(true);
			for (Player p : AraxxiFight.getPlayers()) {
			    p.getPackets().sendGameMessage("<col=e3560e>Procee d down the Path!</col>");
			}
		    }
		} else if (loop == 60) {

		    stop();
		}
		loop++;
	    }
	}, 0, 1);

    }

    public static void setTimer() {
	timer = Utils.currentTimeMillis() + 60000;
    }

    public static void burnedWeb() {
	burnedWeb = true;
    }

    public boolean getBurnedWeb() {
	return burnedWeb;
    }

    public static void removeWeb() {
	if (webId == 1) {
	    removeWebLeft();
	    burnedWeb();
	} else if (webId == 2) {
	    removeWebRight();
	    burnedWeb();
	} else if (webId == 3) {
	    removeWebCentral();
	    burnedWeb();
	}
	return;
    }

    public static void changeRamp() {
	World.spawnObject(new WorldObject(91521, 10, 0, (new WorldTile(4536, 6260, 1))));
    }

    public static void resetRamp() {
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4555, 6261, 1))));
	World.spawnObject(new WorldObject(91520, 10, 0, (new WorldTile(4536, 6260, 1))));
	burnedWeb = false;
	burningWeb = false;

    }

    public static void breakRamp() {
	World.spawnObject(new WorldObject(91526, 10, 0, (new WorldTile(4536, 6260, 1))));
	World.spawnObject(new WorldObject(91670, 10, 0, (new WorldTile(4555, 6261, 1))));
    }

    public void burnWebLeft() {
	World.spawnObject(new WorldObject(91505, 10, 0, (new WorldTile(4504, 6272, 1))));
	setBurningWeb();
	setTimer();
	webId = 1;
	webTimer();
    }

    public void burnWebRight() {
	World.spawnObject(new WorldObject(91507, 10, 0, (new WorldTile(4507, 6248, 1))));
	setBurningWeb();
	setTimer();
	webId = 2;
	webTimer();
    }

    public static void burnWebCentral() {
	World.spawnObject(new WorldObject(91506, 10, 2, (new WorldTile(4512, 6257, 1))));
	setBurningWeb();
	setTimer();
	webId = 3;
	webTimer();
    }

    public int getWebId() {
	return webId;
    }

    public static void removeWebLeft() {
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4504, 6272, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4504, 6275, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4505, 6274, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4506, 6273, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4507, 6273, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4508, 6272, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4509, 6272, 1))));
    }

    public static void removeWebRight() {
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4507, 6248, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4505, 6250, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4506, 6251, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4507, 6252, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4508, 6253, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4509, 6254, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4510, 6255, 1))));
    }

    public static void removeWebCentral() {
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6257, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4511, 6261, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6259, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6260, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6261, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6262, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6263, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6264, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6265, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6266, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6267, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6268, 1))));
	World.spawnObject(new WorldObject(-1, 10, 0, (new WorldTile(4512, 6269, 1))));
    }

    public static void addWebLeft() {
	World.spawnObject(new WorldObject(91667, 10, 0, (new WorldTile(4504, 6275, 1))));
	World.spawnObject(new WorldObject(91667, 10, 0, (new WorldTile(4505, 6274, 1))));
	World.spawnObject(new WorldObject(91667, 10, 0, (new WorldTile(4506, 6273, 1))));
	World.spawnObject(new WorldObject(91667, 10, 0, (new WorldTile(4507, 6273, 1))));
	World.spawnObject(new WorldObject(91667, 10, 0, (new WorldTile(4508, 6272, 1))));
	World.spawnObject(new WorldObject(91667, 10, 0, (new WorldTile(4509, 6272, 1))));
	World.spawnObject(new WorldObject(91504, 10, 0, (new WorldTile(4504, 6272, 1))));

    }

    public static void addWebRight() {
	World.spawnObject(new WorldObject(91511, 10, 0, (new WorldTile(4507, 6248, 1))));
	World.spawnObject(new WorldObject(91668, 10, 0, (new WorldTile(4505, 6250, 1))));
	World.spawnObject(new WorldObject(91668, 10, 0, (new WorldTile(4506, 6251, 1))));
	World.spawnObject(new WorldObject(91668, 10, 0, (new WorldTile(4507, 6252, 1))));
	World.spawnObject(new WorldObject(91668, 10, 0, (new WorldTile(4508, 6253, 1))));
	World.spawnObject(new WorldObject(91668, 10, 0, (new WorldTile(4509, 6254, 1))));
	World.spawnObject(new WorldObject(91668, 10, 0, (new WorldTile(4510, 6255, 1))));
    }

    public static void addWebCentral() {
	World.spawnObject(new WorldObject(91509, 10, 0, (new WorldTile(4511, 6261, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6259, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6260, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6261, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6262, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6263, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6264, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6265, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6266, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6267, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6268, 1))));
	World.spawnObject(new WorldObject(91669, 10, 0, (new WorldTile(4512, 6269, 1))));
    }

    public static boolean getBurningWeb() {
	return burningWeb;
    }

    public static void setBurningWeb() {
	burningWeb = true;
    }

    public void resetBurningWeb() {
	burningWeb = false;
    }

    private static void spawnNPCs() {
	deleteNPCS();

	if (araxxi == null) {
	    araxxi = new Araxxi(19457, new WorldTile(4536, 6264, 2), -1, true, true);
	    araxxi.setCantInteract(true);
	}

    }

    public static void addPlayer(final Player player) {
	synchronized (players) {
	    players.add(player);
	    if (players.size() == 1)
		beginFight();
	}
    }

    public static void removePlayer(Player player) {
	synchronized (players) {
	    players.remove(player);
	    if (players.size() == 0) {
		World.removeNPC(araxxi);
		cancelFight();
	    }
	}
    }

    public static void deleteNPCS() {
	if (araxxi != null) {
	    araxxi.finish();
	    araxxi = null;
	}

    }

    private static void cancelFight() {
	araxxi.resetVariables();
	spawnNPCs();
	resetRamp();

    }

    public static ArrayList<Entity> getPossibleTargets() {
	ArrayList<Entity> possibleTarget = new ArrayList<Entity>(players.size());
	for (Player player : players) {
	    if (player == null || player.isDead() || player.hasFinished() || !player.isRunning())
		continue;
	    possibleTarget.add(player);
	}
	return possibleTarget;
    }

    public static void endFight() {
	spawnNPCs();
    }

    public static void beginFight() {
	WorldTasksManager.schedule(new WorldTask() {
	    private int count = 0;

	    @Override
	    public void run() {
		if (count == 1) {
		    araxxi.phase = 1;
		    araxxi.setNextAnimation(new Animation(24076));
		    araxxi.setNextGraphics(new Graphics(4984));
		    araxxi.setNextWorldTile(new WorldTile(4505, 6263, 1));
		    addWebLeft();
		    addWebRight();
		    addWebCentral();
		}
		if (count == 4) {
		    if (araxxi != null)
			araxxi.setCantInteract(false);
		    else
			endFight();
		}
		count++;
	    }
	}, 0, 1);
    }

}