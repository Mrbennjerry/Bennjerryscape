package com.rs.game.player.controllers;

import com.rs.Settings;
import com.rs.game.minigames.AraxxiFight;

/***
 * 
 * @author Jas-Humbzian
 *
 */

public class AraxxiController extends Controller {

    @Override
    public void start() {
	AraxxiFight.addPlayer(player);

    }

    @Override
    public boolean logout() {
	remove();
	removeControler();
	player.setNextWorldTile(Settings.START_PLAYER_LOCATION);
	AraxxiFight.removePlayer(player);
	return false; //
    }

    @Override
    public boolean sendDeath() {
	remove();
	removeControler();
	return true;
    }

    @Override
    public void magicTeleported(int type) {
	remove();
	removeControler();
    }

    @Override
    public void forceClose() {
	remove();
    }

    public void remove() {
	AraxxiFight.removePlayer(player);

    }
}
