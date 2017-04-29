package com.rs.game.player.actions.divination;

import com.rs.game.Animation;
import com.rs.game.Region;
import com.rs.game.World;
import com.rs.game.WorldObject;
import com.rs.game.minigames.duel.DuelArena;
import com.rs.game.minigames.duel.DuelControler;
import com.rs.game.player.Player;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
 
public class DivinePlacing {
 
        public static void check(final Player owner) {
                WorldTasksManager.schedule(new WorldTask() {
                    @Override
                    public void run() {
                if(owner.divine > 1)
                return;
                if(owner.divine == 0){
                                owner.getPackets().sendGameMessage("Your divine has vanished.");
                                //owner.hasDivine = false;
                                                stop();
                                        }
                    return;
                    }  
                        }, 0, 0);
                }
 
 
        //protected static Player fucker;
public static void placeDivinePre(final Player owner, final int item, final int fobject, final int lobject, final int lvl, final int skillId) {
 if (!World.isTileFree(owner.getPlane(), owner.getX(), owner.getY(), 1) // cliped
		|| World.getObjectWithSlot(owner, Region.OBJECT_SLOT_FLOOR) != null // fix
		// for
		// updated
		// api
		|| owner.getControlerManager().getControler() instanceof DuelArena || owner.getControlerManager().getControler() instanceof DuelControler) { // contains
	// object
	owner.getPackets().sendGameMessage("You can't place a divine location here.");
} else if (owner.hasDivine == true){
    owner.getPackets().sendGameMessage("You already have a divine location placed.");
} else {
    placeDivine(owner, item, fobject, lobject, lvl, skillId);
}
}
       
public static void placeDivine(final Player owner, final int item, final int fobject, final int lobject, final int lvl, final int skillId) {
        WorldTasksManager.schedule(new WorldTask() {
            int ticks;
            @Override
            public void run() {
                ticks++;
        if(ticks == 1){
            	//owner.hasDivine = true;
                owner.getInventory().deleteItem(item, 1);
                owner.setNextAnimation(new Animation(21217));
                owner.getPackets().sendGameMessage("You spawn a divine location.");
                //owner.addFreezeDelay(2700);
                final WorldObject divinefirststage = new WorldObject(fobject,10, 0, owner.getX() + 1, owner.getY(), owner.getPlane()); // object spawning
                owner.hasDivine = true;
                owner.faceObject(divinefirststage); // forces player to face where he is putting the object
                World.spawnTemporaryObject(divinefirststage, 2700); // dont touch
                owner.lock(4);
        }
        if(ticks == 5){
                check(owner); // lets the owner know his divine disapeared
                final WorldObject divinefinalstage = new WorldObject(lobject,10, 0, owner.getX() + 1, owner.getY(), owner.getPlane(), owner); // object with animation that player will mine
                World.spawnTemporaryDivineObject(divinefinalstage, 60000, owner);       // time object will stay in miliseconds
                owner.divine = lobject;
                owner.divines = owner;
                //fucker = owner;
                //owner = player;
                stop();
                                }
            return;
            }  
                }, 0, 0);
        }
}