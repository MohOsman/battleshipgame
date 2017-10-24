package com.battleshipgame.view;

import com.battleshipgame.model.*;
import com.battleshipgame.model.ship.Ship;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.PlayerNotFoundExption;

import java.awt.*;

/**
 * Created by MohamedOsman on 2017-10-21.
 */
public class GameEventHandler implements EventHandler<Event> {
    private BattleShipGameStage stage;
    private Game game;
    private Ship ship;
    private int shipDeriction;

    public GameEventHandler(BattleShipGameStage stage, Game game) {
        this.game = game;
        this.stage = stage;

    }


    @Override
    public void handle(Event event) {
        switch (game.getState()) {
            case SETUPMODE:
                placeShip((MouseEvent) event, getUserPlayer());
                System.out.println(" in setupmode");
                placeShip((MouseEvent) event, getAIPlayer());
                checkAndSetState();
                System.out.println(game.getState());
                break;
            case PLAYMODE:
                startGame(event );
                break;
        }


    }


    // Implement tomwowe

    private void startGame(Event event) {







    }

    private void checkAndSetState() {
        if(getAIPlayer().allShipsPlaced() && getUserPlayer().allShipsPlaced()){
            game.setState(State.PLAYMODE);
        }
        else {
            game.setState(State.SETUPMODE);
        }
    }


    private void placeShip(MouseEvent event, Player player) {

        switch (player.getType()) {
            case USERPLAYER:
                userPlaceShip(event);
                break;
            case AIPLAYER:
                AIPlaceShip();
                break;


        }


    }

    private void AIPlaceShip() {
        stage.getGameScene().getAIPlayerBattleGridview().enableGrid();
        System.out.println(" in AIMODE");
        if (!getAIPlayer().allShipsPlaced()) {
            getAIPlayer().placeShip();

        }
        else {
            System.out.println("ALL AI ships are placed ");
        }


    }


    private void userPlaceShip(MouseEvent event) {
        Square square = (Square) event.getSource();
        Position position = (Position) square.getUserData();
        if (getShipSelected() != null) {
            if (!getUserPlayer().allShipsPlaced()) {
                if (getUserPlayer().placeShip(getShipSelected(), position, getShipdirection(event))) {
                    stage.getGameScene().getUserBattleGridView().
                            uppdateSquare(position, getShipSelected().
                                    getSize(), getShipdirection(event));
                    stage.getGameScene().getShipSelection().Update(getShipSelected());


                }


            }

        }

    }


    private int getShipdirection(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY)
            shipDeriction = Ship.SHIP_HORIZONTAL;
        else if (event.getButton() == MouseButton.SECONDARY)
            shipDeriction = Ship.SHIP_VERTICAL;

        return shipDeriction;
    }


    public Ship getShipSelected() {
        return ship = stage.getGameScene().getShipSelection().getSelectedShip();

    }


    public Player getUserPlayer() {
        return game.getUserPlayer();
    }

    public Player getAIPlayer() {
        return game.getAIPlayer();
    }
}
