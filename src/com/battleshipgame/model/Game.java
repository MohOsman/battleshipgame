package com.battleshipgame.model;


import com.battleshipgame.model.ship.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohamedOsman on 2017-10-19.
 */
public class Game {
   private  List<Player>  players;

    public Game() {
        this.players = new ArrayList<>();
        createTestPlayers();
    }

    private void createTestPlayers() {
        Player player1 = new Player(PlayerType.USERPLAYER);
        players.add(player1);

    }


    public List<Player> getPlayers() {
        return  players;
    }

    public List<Ship> getShips() {
        return players.get(0).getShips();
    }
}
