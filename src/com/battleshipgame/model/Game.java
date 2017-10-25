package com.battleshipgame.model;


import com.battleshipgame.model.ship.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohamedOsman on 2017-10-19.
 */
public class Game  implements  Subject{
    private List<Player> players;
    private State state;
    private List<Observer> observers;


    public Game() {
        this.players = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.state = State.SETUPMODE;
        createTestPlayers();
        notifyAllObservers();

    }


    private void createTestPlayers()  {
        PlayerFactory playerFactory = new PlayerFactory();
        this.players.add(playerFactory.createPlayer(PlayerType.AIPLAYER));
        this.players.add(playerFactory.createPlayer(PlayerType.USERPLAYER));


    }

    public  void actOnState(){
        if(getState()==State.SETUPMODE){
            notifyAllObservers();
        }
       else if(getState()==State.PLAYMODE){
            notifyAllObservers();
        }
    }


    public List<Ship> getPlayerShips() {
        return getUserPlayer().getUnplacedShips();
    }

    public Player getAIPlayer() {
        return this.players.get(0);
    }

    public Player getUserPlayer() {
        return this.players.get(1);
    }


    public List<Player> getPlayers() {
        return players;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


    public boolean userAttack(Position position) {
        return getUserPlayer().attack(position, getAIPlayer().getBattleGrid());
    }

    public void updateGrid(Player player) {
        if (player.getType() == PlayerType.USERPLAYER) {
            addHitpostions(getAIPlayer());
        }
        if (player.getType() == PlayerType.AIPLAYER) {
            addHitpostions(getUserPlayer());


        }
    }

    private void addHitpostions(Player player) {
        for(Position position : player.getBattleGrid().getOccupiedPositions()){
            if(position.isHit()){
                player.getBattleGrid().setHitPostion(position);
            }
        }
    }


    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);


    }

    @Override
    public void removeObserver(Observer o) {
       this.observers.remove(o);
    }

    @Override
    public void notifyAllObservers(){
        for (Observer o : this.observers){
            o.update();
        }

    }

    public void startGame() {
        actOnState();
    }
}
