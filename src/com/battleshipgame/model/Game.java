package com.battleshipgame.model;


import com.battleshipgame.model.ship.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Game Class keep tracks of the game and creates players using Playerfactory
 */
public class Game {
    /**
     * List of players  there can only two Players
     */
    private List<Player> players;
    /**
     * state of the Game SETUPMODE :- players are placcing ships  PLAYMODE:- players are attacking eact other
     */
    private State state;

    /**
     *  Constructor the sets game state to setup state att begning
     *  creates players using player factory
     *  act by stat method to do tasks in specfic state
     */
    public Game() {
        this.players = new ArrayList<>();
        this.state = State.SETUPMODE;
        createPlayers();
        actOnState();

    }

    /**
     *  Creating players by using player factory and adding those to a list
     */
    private void createPlayers() {
        PlayerFactory playerFactory = new PlayerFactory();
        this.players.add(playerFactory.createPlayer(PlayerType.AIPLAYER));
        this.players.add(playerFactory.createPlayer(PlayerType.USERPLAYER));


    }

    /**
     * thes method acts by state, only thing we are doing here is to place AI ships
     */
    public void actOnState() {
        if (getState() == State.SETUPMODE) {
            AIPlaceships();
        }
    }


    /**
     * Private method to place AI ships using a for loop
     */
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


    /**
     * This method is game method to make the user player attack,this method is used in eventlistener,
     * this method  calls userplayer to attack AIPlayer with the position clicked
     * @param position To attack
     */
    public void userAttack(Position position) {
        getUserPlayer().attack(position, getAIPlayer());
    }

    /***
     * this mehod calls the AIplayer to attack the user player gird  
     * @return Postion that was attacked by the AI Player
     */
    public Position AIAttack() {
        return getAIPlayer().attack(getUserPlayer().getBattleGrid(), getUserPlayer());

    }

}
