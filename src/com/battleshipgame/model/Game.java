package com.battleshipgame.model;


import com.battleshipgame.model.ship.BattleShip;
import com.battleshipgame.model.ship.Ship;
import com.battleshipgame.view.BattleShipGameStage;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohamedOsman on 2017-10-19.
 */
public class Game {
   private  List<Player>  players;
   private  State state;

    public Game() {
        this.players = new ArrayList<>();
        this.state = State.SETUPMODE;
        createTestPlayers();


    }



    private void createTestPlayers() {
       PlayerFactory playerFactory = new PlayerFactory();
       this.players.add(playerFactory.createPlayer(PlayerType.AIPLAYER));
      this.players.add(playerFactory.createPlayer(PlayerType.USERPLAYER));


    }




    public List<Ship> getPlayerShips(){
        return getUserPlayer().getUnplacedShips();
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




    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


}
