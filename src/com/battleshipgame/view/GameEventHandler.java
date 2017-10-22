package com.battleshipgame.view;

import com.battleshipgame.model.*;
import com.battleshipgame.model.ship.Ship;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.PlayerNotFoundExption;

/**
 * Created by MohamedOsman on 2017-10-21.
 */
public class GameEventHandler implements EventHandler<Event>{
     private  BattleShipGameStage stage;
     private  Game game;
     private Ship ship;
     private Player userPlayer;
     private Player AIPlayer ;
     private boolean shipselected = false;
    private int shipDeriction;

    public GameEventHandler(BattleShipGameStage stage, Game game) {
         this.game = game;
        this.stage = stage;
    }




    @Override
    public void handle(Event event) {

        getShipSelected();
        if(shipselected){
            PlaceShip((MouseEvent) event);
        }

    }


    private void PlaceShip(MouseEvent event) {
        Square square = (Square) event.getSource();
        Position position = (Position) square.getUserData();

    if(game.getUserPlayer().getBattleGrid().postionShipsOnGrid(ship,position,getShipdirection(event))){
         stage.getGameScene().getBattleGridView().
                 uppdateSquare(position.getXcord(),position.getYCord(),ship.getSize(),getShipdirection(event));
  } else {
        System.out.println("Postion is occupied");
    }





    }



    private int getShipdirection(MouseEvent event) {
        if(event.getButton()== MouseButton.PRIMARY)
            shipDeriction = Ship.SHIP_HORIZONTAL;
        else if(event.getButton() == MouseButton.SECONDARY)
            shipDeriction = Ship.SHIP_VERTICAL;

        return shipDeriction;
    }


    public  void getShipSelected() {
     ship = stage.getGameScene().getShipSelection().getSelectedShip();


        if(ship!= null){
            shipselected =true;
        }
        else shipselected= false;


    }



    public Player getUserPlayer() {
        return game.getUserPlayer();
    }

    public Player getAIPlayer() {
        return game.getAIPlayer();
    }
}
