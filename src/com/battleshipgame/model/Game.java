package com.battleshipgame.model;


import com.battleshipgame.model.ship.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohamedOsman on 2017-10-19.
 */
public class Game {
    private List<Player> players;
    private State state;
    private List<Observer> observers;


    public Game() {
        this.players = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.state = State.SETUPMODE;
        System.out.println(state);
        createPlayers();
        actOnState();

    }


    private void createPlayers() {
        PlayerFactory playerFactory = new PlayerFactory();
        this.players.add(playerFactory.createPlayer(PlayerType.AIPLAYER));
        this.players.add(playerFactory.createPlayer(PlayerType.USERPLAYER));


    }

    public void actOnState() {
        if (getState() == State.SETUPMODE) {
            AIPlaceships();
        }
    }


    private void AIPlaceships() {
        for (int i = 0; i <= 5; i++) {
            getAIPlayer().placeShip();
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


    public void userAttack(Position position) {
        getUserPlayer().attack(position, getAIPlayer());
    }



    public Position AIAttack() {
        return getAIPlayer().attack(getUserPlayer().getBattleGrid(), getUserPlayer());

    }

}
