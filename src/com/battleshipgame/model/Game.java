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
       PlayerFactory playerFactory = new PlayerFactory();
       this.players.add(playerFactory.createPlayer(PlayerType.AIPLAYER));
      this.players.add(playerFactory.createPlayer(PlayerType.USERPLAYER));

    }

    public Player getAIPlayer (){
        return this.players.get(0);
    }
    public Player  getUserPlayer(){
        return this.players.get(1);
    }


    public List<Player> getPlayers() {
        return  players;
    }

    public List<Ship> getShips() {
        return players.get(0).getShips();
    }



}
