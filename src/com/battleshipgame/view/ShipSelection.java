package com.battleshipgame.view;


import com.sun.tools.example.debug.expr.ExpressionParser;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import com.battleshipgame.model.ship.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class ShipSelection extends VBox {

    private GameEventHandler mouseListener;
    private Ship selectedShip;





    public ShipSelection(List<Ship> ships ,GameEventHandler mouseListener) {
        this.mouseListener  =mouseListener;
        addShipsquare(ships);
    }

    private void addShipsquare(List<Ship> ships) {
        VBox carrier = new VBox();
        VBox battleship = new VBox();
        VBox submarine = new VBox();
        VBox destroyer = new VBox();
        VBox cruser = new VBox();
        for(Ship ship : ships){
            switch (ship.getType()) {
                case Carrier.SHIP_NAME:
                    carrier.getChildren().addAll(new Label(Carrier.SHIP_NAME), createShipSquare(Carrier.SHIP_SIZE));
                    carrier.setUserData(ship);
                    carrier.setOnMouseClicked(mouseListener);
                    setSelectedShips(carrier);
                    break;
                case BattleShip.SHIP_NAME:
                    battleship.getChildren().addAll(new Label(BattleShip.SHIP_NAME), createShipSquare(BattleShip.SHIP_SIZE));
                    battleship.setUserData(ship);
                    battleship.setOnMouseClicked(mouseListener);
                    setSelectedShips(battleship);
                    break;
                case Destroyer.SHIP_NAME:
                    destroyer.getChildren().addAll(new Label(Destroyer.SHIP_NAME), createShipSquare(Destroyer.SHIP_SIZE));
                    destroyer.setUserData(ship);
                    destroyer.setOnMouseClicked(mouseListener);
                    setSelectedShips(destroyer);
                    break;
                case Submarine.SHIP_NAME:
                    submarine.getChildren().addAll(new Label(Submarine.SHIP_NAME), createShipSquare(Submarine.SHIP_SIZE));
                    submarine.setUserData(ship);
                    submarine.setOnMouseClicked(mouseListener);
                    setSelectedShips(submarine);
                    break;
                case Cruiser.SHIP_NAME:
                    cruser.getChildren().addAll(new Label(Cruiser.SHIP_NAME), createShipSquare(Cruiser.SHIP_SIZE));
                    cruser.setUserData(ship);
                    cruser.setOnMouseClicked(mouseListener);
                    setSelectedShips(cruser);
            }

            }

        getChildren().addAll(carrier,battleship,cruser,submarine,destroyer);

//        VBox battleShip = new VBox(new Label(BattleShip.SHIP_NAME), createShipSquare(BattleShip.SHIP_SIZE));
//        VBox cruiser =new VBox(new Label(Cruiser.SHIP_NAME), createShipSquare(Cruiser.SHIP_SIZE));
//        VBox submarine = new VBox(new Label(Submarine.SHIP_NAME), createShipSquare(Submarine.SHIP_SIZE));
//        VBox destroyer =new VBox(new Label(Destroyer.SHIP_NAME),createShipSquare(Destroyer.SHIP_SIZE));
//
//        submarine.setOnMouseClicked(mouseListener);
//        battleShip.setOnMouseClicked(mouseListener);
//        destroyer.setOnMouseClicked(mouseListener);
//        cruiser.setOnMouseClicked(mouseListener);

    }







    private HBox createShipSquare(int size) {
        HBox hBox = new HBox();
        for (int i = 0; i < size; i++) {

            Square square = new Square();
            square.setFill(Color.GREEN);
            square.setOnMouseClicked(mouseListener);
            square.setUserData(selectedShip);
            hBox.getChildren().addAll(square);


        }
        return hBox;
    }

    private   void setSelectedShips(VBox vBox){
        this.selectedShip= (Ship)vBox.getUserData();

    }

    public Ship getSelectedShip() {
        return selectedShip;
    }
}
