package com.battleshipgame.controller;

import com.battleshipgame.model.*;
import com.battleshipgame.model.ship.Ship;
import com.battleshipgame.view.BattleShipGameStage;
import com.battleshipgame.view.Square;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * This class is the eventlistener for the user clicks, it interaccts with both stage and game
 * @author MohamedOsman
 */
public class GameEventListener implements EventHandler<Event> {
    /**
     * the view stage
     */
    private BattleShipGameStage stage;
    private Game game;
    /**
     * holds refrence to the ship selected form user
     */
    private Ship ship;

    /**
     * shipdirection to place PRIMARY_MOUSE = Horizontal , SECONDARY = Vertical
     */
    private int shipDeriction;

    public GameEventListener(BattleShipGameStage stage, Game game) {
        this.game = game;
        this.stage = stage;

    }

    /**
     * The Main Method to handle all events, it acts by state, so if we are in setupmode the ships gets placed
     * On Play mode we start the game
     * @param event to handle
     */
    @Override
    public void handle(Event event) {
        switch (game.getState()) {
            case SETUPMODE:
                placeShip((MouseEvent) event);
                checkAndSetState();
                game.actOnState();
                break;
            case PLAYMODE:
                startGame(event);
                break;
        }


    }

    /**
     * This method is to check and set tha state if both players has placed their ships
     * after that we disable the user grid and enable AI player grid to be traget gird
     */
    public void checkAndSetState() {
        if (getAIPlayer().allShipsPlaced() && getUserPlayer().allShipsPlaced()) {
            stage.getGameView().getAIPlayerBattleGridview().enableGrid();
            stage.getGameView().getUserBattleGridView().disableGrid();
            game.setState(State.PLAYMODE);
        } else
            game.setState(State.SETUPMODE);

    }


    /**
     * user place event to place the ships
     * @param event

     */
    private void placeShip(MouseEvent event) {
        userPlaceShip(event);
    }


    /**
     * if the game started we are in attackmode
     * @param event attack evetns to hanlde
     */
    private void startGame(Event event) {
        AttackMode(event);


    }

    /**
     * This method handels all the attacks by user and AI PLaer and updateing the view with Postions attaked
     * @param event
     */
    private void AttackMode(Event event) {
        Square square = (Square) event.getSource();
        Position position = (Position) square.getUserData();
        // get postion from user clikc
        // use it in attack
        game.userAttack(position);
        // update the view that positon if it is a hit or not
        stage.getGameView().getAIPlayerBattleGridview().uppdateSingelSquare(position);

        // not it AI player turn, Game.AIAttak returns postion, so that position we  want to update
        stage.getGameView().getUserBattleGridView().uppdateSingelSquare(game.AIAttack());

        // The one who takes down all the ships first Wins
        if (game.getUserPlayer().allShipsSunked()) {
            System.out.println("Computer Won ");
            System.exit(0);
        }

        else if (game.getAIPlayer().allShipsSunked()) {
            System.out.println("User  Won");
           System.exit(0);

        }


    }


    /**
     * This method handles the user ship placement event, by first getting postion object from the envent
     * and checking if all ships are placeed, updating the view with ships placed and removing the ships from selectio view
     * @param event
     */
    private void userPlaceShip(MouseEvent event) {
        Square square = (Square) event.getSource();
        Position position = (Position) square.getUserData();
        if (getShipSelected() != null) {
            if (!getUserPlayer().allShipsPlaced()) {
                if (getUserPlayer().placeShip(getShipSelected(), position, getShipdirection(event))) {
                    stage.getGameView().getUserBattleGridView().uppdateSquare(position, getShipSelected().getSize(), getShipdirection(event));
                    stage.getGameView().getShipSelection().remove(getShipSelected());


                }

            }

        }

    }

    /**
     * this is method handles ship direction  if the user wants to place the ship verticaly he clicks secondary mouse button
     * elese primary
     * @param event
     * @return direction for the ship
     */
    private int getShipdirection(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY)
            shipDeriction = Ship.SHIP_HORIZONTAL;
        else if (event.getButton() == MouseButton.SECONDARY)
            shipDeriction = Ship.SHIP_VERTICAL;

        return shipDeriction;
    }


    /**
     * this method gets the ship selected from the secetion view
     * @return ship selecetd by the user
     */
    public Ship getShipSelected() {
        return ship = stage.getGameView().getShipSelection().getSelectedShip();

    }


    public Player getUserPlayer() {
        return game.getUserPlayer();
    }

    public Player getAIPlayer() {
        return game.getAIPlayer();
    }
}
