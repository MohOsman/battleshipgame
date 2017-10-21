package com.battleshipgame.view;

import com.battleshipgame.model.Game;
import com.battleshipgame.model.Position;
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

/**
 * Created by MohamedOsman on 2017-10-21.
 */
public class GameEventHandler implements EventHandler<Event>{
     private  BattleShipGameStage stage;
     private  Game game;
     private Ship ship;
     private boolean shipselected = false;
    public GameEventHandler(BattleShipGameStage stage, Game game) {
         this.stage = stage;
    }




    @Override
    public void handle(Event event) {
        getShipSelected(event);

        if(shipselected){
            PlaceShip(event);
        }

//        if(game.getPlayers().stream().anyMatch(e->e.getBattleGrid().isPostionValid(ship,position))){
//            System.out.println("yes");
//        } else
//            System.out.println("No");
//
//    }

    }

    private void PlaceShip(Event event) {
        Square square = (Square) event.getSource();
        Position position = (Position) square.getUserData();
        for(int i =0 ; i<ship.getSize(); i++ ){
         position.setOccupied(true);
            stage.getGameScene().getBattleGridView().uppdateSquare(position);
        }
    }

    public  void getShipSelected(Event event) {
        VBox vBox = (VBox) event.getSource();
     ship = stage.getGameScene().getShipSelection().getSelectedShip();

        if(ship!= null){
            shipselected =true;
        }
        else shipselected= false;


    }



}
