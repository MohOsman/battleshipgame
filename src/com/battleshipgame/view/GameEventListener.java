package com.battleshipgame.view;

import com.battleshipgame.model.*;
import com.battleshipgame.model.ship.Ship;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * Created by MohamedOsman on 2017-10-21.
 */
public class GameEventListener implements EventHandler<Event> {
    private BattleShipGameStage stage;
    private Game game;
    private Ship ship;
    private int shipDeriction;

    public GameEventListener(BattleShipGameStage stage, Game game) {
        this.game = game;
        this.stage = stage;

    }


    @Override
    public void handle(Event event) {
        switch (game.getState()) {
            case SETUPMODE:
                placeShip((MouseEvent) event, getUserPlayer());

                //placeShip((MouseEvent) event, getAIPlayer());
                checkAndSetState();
                game.actOnState();
                break;
            case PLAYMODE:
              ;
                startGame(event);
                break;
        }


    }
    public void checkAndSetState() {
        if (getAIPlayer().allShipsPlaced() && getUserPlayer().allShipsPlaced()) {
            stage.getGameScene().getAIPlayerBattleGridview().enableGrid();
            stage.getGameScene().getUserBattleGridView().disableGrid();
            game.setState(State.PLAYMODE);
        }
        else
            game.setState(State.SETUPMODE);

    }



    private void placeShip(MouseEvent event, Player player) {
        userPlaceShip(event);

    }






    // Implement tomwowe

    private void startGame(Event event) {
        AttackMode(event);


    }

    private void AttackMode(Event event) {
        Square square = (Square) event.getSource();
        Position position = (Position) square.getUserData();
        game.userAttack(position);
        stage.getGameScene().getAIPlayerBattleGridview().uppdateSingelSquare(position);
        stage.getGameScene().getUserBattleGridView().uppdateSingelSquare(game.AIAttack());
        if(game.getUserPlayer().allShipsSunked()){
            System.out.println("Computer Won ");
        }
        else if(game.getAIPlayer().allShipsSunked()){
            System.out.println("User  Won");
        }



    }

    private void starGameSetup() {
        System.out.println("ENTER SETUP IT SHOULDENT");
        stage.getGameScene().getUserBattleGridView().disableGrid();
        stage.getGameScene().getAIPlayerBattleGridview().enableGrid();


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
                    stage.getGameScene().getShipSelection().remove(getShipSelected());


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
