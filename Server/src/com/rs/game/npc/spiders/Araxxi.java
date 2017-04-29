package com.rs.game.npc.spiders;

import com.rs.game.Animation;
import com.rs.game.Entity;
import com.rs.game.Graphics;
import com.rs.game.Hit;
import com.rs.game.Hit.HitLook;
import com.rs.game.WorldTile;
import com.rs.game.minigames.AraxxiFight;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;
import com.rs.game.player.TimersManager.RecordKey;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
import com.rs.utils.Utils;

public class Araxxi extends NPC {

    /***
     * 
     * @author Jas-Humbzian
     *
     */

    private static final long serialVersionUID = 8957425938871772845L;

    public int phase = 1;
    public boolean dmg = true;
    public boolean canDie = false;
    public boolean changedRamp = false;
    public boolean startedMove = false;
    public int addHp;
    public static long exit = Utils.currentTimeMillis() + 60000;
    public boolean lastFight = false;
    public boolean canBeAttacked = true;

    public boolean isDoingCleave;

    public Araxxi(int id, WorldTile tile, int mapAreaNameHash, boolean canBeAttackFromOutOfArea, boolean spawned) {
	super(id, tile, mapAreaNameHash, canBeAttackFromOutOfArea, spawned);
	setLureDelay(Integer.MAX_VALUE);
	setRun(true);
	setIntelligentRouteFinder(true);
	setHitpoints(100000);
	setBonuses();
	setForceAgressive(true);
	setCapDamage(6500);
	phase = 1;
    }

    public int getPhase() {
	return phase;
    }

    public static long getExit() {
	return exit;
    }

    public void AraxxorTeleport() {

	WorldTasksManager.schedule(new WorldTask() {
	    int loop;

	    @Override
	    public void run() {
		if (loop == 0) {
		    setNextGraphics(new Graphics(4984));
		    setNextAnimation(new Animation(24056));
		} else if (loop == 3) {
		    setNextGraphics(new Graphics(4984));
		    setNextWorldTile(new WorldTile(4565, 6265, 1));
		    setNextAnimation(new Animation(24076));
		} else if (loop == 5) {
		    phase = 3;
		    setCantInteract(false);
		    setHitpoints(120000);

		    stop();
		}
		loop++;
	    }
	}, 0, 1);

    }

    public void thirdPhase() {
	WorldTasksManager.schedule(new WorldTask() {
	    int loop;
	    WorldTile face = new WorldTile(4555, 6264, 1);

	    @Override
	    public void run() {
		if (loop == 0) {
		    addWalkSteps(4550, 6263);
		} else if (loop == 4) {
		    setNextFaceWorldTile(face);
		    setNextAnimation(new Animation(24050));
		} else if (loop == 5) {
		    AraxxiFight.breakRamp();
		} else if (loop == 7) {
		    AraxxorTeleport();
		    setForceFollowClose(false);
		    for (Player p : AraxxiFight.getPlayers()) {
			p.getPackets().sendGameMessage("<col=1fe12c>Jump over the gap!</col>");
		    }

		    stop();
		}
		loop++;
	    }
	}, 0, 1);
    }

    @Override
    public void processNPC() {
	if (isDead())
	    return;

	if (getPhase() == 1 && getX() >= 4516 && getX() <= 4517) {
	    setNextNPCTransformation(19465);
	    setHitpoints(120000);
	    for (Player p : AraxxiFight.getPlayers()) {
		p.getPackets()
			.sendGameMessage("<col=e3560e>Make your way up the ramp and continue fighting Araxxor!</col>");
	    }
	    phase = 2;
	}
	if (getPhase() == 2 && getX() >= 4536 && getHitpoints() <= 10000 && !getStartedMove()) {
	    startedMove = true;
	    setCantInteract(true);
	    phase = 3;
	    thirdPhase();
	}
	if (getPhase() == 2 && getX() >= 4536 && !getChangedRamp()) {
	    changedRamp = true;
	    AraxxiFight.changeRamp();
	}
	if (getPhase() == 3 && getX() >= 4500 && getHitpoints() <= 4000) {
	    phase = 4;
	    setCantInteract(true);
	    forceMove();
	}

	super.processNPC();
    }

    public boolean getStartedMove() {
	return startedMove;
    }

    public boolean getChangedRamp() {
	return changedRamp;
    }

    @Override
    public void handleIngoingHit(Hit hit) {
	super.handleIngoingHit(hit);

	if (hit.getSource() != null && getId() == 1) {
	    int dmg = (int) (hit.getDamage());
	    heal(dmg);

	}
	if (hit.getSource() != null && !canBeAttacked) {
	    hit.setDamage(0);
	}

    }

    @Override
    public void processEntity() {
	super.processEntity();
	if (getPhase() == 5) {
	    for (Player t : AraxxiFight.getPlayers()) {
		if (Utils.colides(Araxxi.this, t)) {
		    t.setNextWorldTile(new WorldTile(Araxxi.this.getX() - 1, t.getY(), Araxxi.this.getPlane()));
		}
	    }

	}
    }

    void resetCounts() {

	dmg = false;
    }

    public void resetVariables() {

	dmg = false;
	phase = 1;
	addHp = 0;
	changedRamp = false;
	startedMove = false;
	lastFight = false;
	canDie = false;
	canBeAttacked = true;

    }

    public void DeathTimer() {

	for (Player p : AraxxiFight.getPlayers()) {
	    p.getPackets().sendGameMessage(
		    "<col=97ee1b>You have 1 minute to leave before the araxytes descend upon you!</col>");
	}

	WorldTasksManager.schedule(new WorldTask() {
	    int loop;

	    @Override
	    public void run() {
		if (loop == 0) {

		}

		if (loop == 40) {
		    for (Player p : AraxxiFight.getPlayers()) {
			p.getPackets().sendGameMessage(
				"<col=97ee1b>This is your final warning! The araxytes grow weary of your intrusion.</col>");
		    }
		}

		else if (loop == 50) {

		    for (Player p : AraxxiFight.getPlayers()) {
			p.applyHit(new Hit(p, 25000, HitLook.ABSORB_DAMAGE));

			p.getPackets().sendGameMessage("<col=97ee1b>The araxytes descend upon you!</col>");
		    }

		} else if (loop == 51) {

		    stop();
		}
		loop++;
	    }
	}, 0, 1);

    }

    public void forceMove() {
	WorldTasksManager.schedule(new WorldTask() {
	    int loop;
	    WorldTile tile = new WorldTile(4587, 6268, 1);
	    WorldTile face = new WorldTile(4589, 6266, 1);

	    @Override
	    public void run() {
		if (loop == 0) {
		    setNextGraphics(new Graphics(4984));
		    setNextAnimation(new Animation(24056));
		} else if (loop == 3) {
		    AraxxiFight.teleportPlayers();
		    setNextGraphics(new Graphics(4984));
		    setNextAnimation(new Animation(24076));
		    setNextWorldTile(new WorldTile(tile));
		    setNextFaceWorldTile(face);
		} else if (loop == 5) {
		    setNextAnimation(new Animation(24062));
		    setNextGraphics(new Graphics(5000));
		    setNextWorldTile(new WorldTile(tile));

		} else if (loop == 11) {
		    if (AraxxiFight.getPlayersCount() >= 2) {
			setHitpoints(130000);
		    }
		    if (AraxxiFight.getPlayersCount() == 1) {
			setHitpoints(100000);
		    }
		    setNextNPCTransformation(19464);
		    setNextWorldTile(new WorldTile(tile));
		    setCantInteract(false);

		    stop();
		}
		loop++;
	    }
	}, 0, 1);
    }

    @Override
    public double getMagePrayerMultiplier() {
	return 0.5;
    }

    @Override
    public double getRangePrayerMultiplier() {
	return 0.5;
    }

    @Override
    public double getMeleePrayerMultiplier() {
	return 0.5;
    }

    @Override
    public void sendDeath(Entity p) {
	if (getId() == 19464) {
	    setNextAnimation(new Animation(24106));
	    if (getPhase() < 2) {
		setCantInteract(true);
		getCombat().removeTarget();
	    } else {
		WorldTasksManager.schedule(new WorldTask() {
		    @Override
		    public void run() {
			giveXP();
			increaseKills(RecordKey.ARAXXI, false);
			drop();
			resetVariables();
			reset();
			finish();
			phase = 1;
			DeathTimer();
			stop();
		    }
		}, 5);
	    }
	} else {
	    setHitpoints(10000);
	}
    }

}
