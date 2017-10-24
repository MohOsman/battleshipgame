package com.battleshipgame.view;


import com.sun.tools.example.debug.expr.ExpressionParser;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import com.battleshipgame.model.ship.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class ShipSelection extends VBox {

    private GameEventHandler mouseListener;
    private Ship selectedShip;
    private List<Ship> selectedShips;
    private boolean isSelected;


    public ShipSelection(List<Ship> ships, GameEventHandler mouseListener) {
        this.mouseListener = mouseListener;
        this.selectedShips = new ArrayList<>();
        this.isSelected = false;

        addShipsquare(ships);
    }

    private void addShipsquare(List<Ship> ships) {
        VBox carrier = new VBox();
        VBox battleship = new VBox();
        VBox submarine = new VBox();
        VBox destroyer = new VBox();
        VBox cruser = new VBox();
        for (Ship ship : ships) {
            switch (ship.getType()) {
                case Carrier.SHIP_NAME:
                    carrier.getChildren().addAll(new Label(Carrier.SHIP_NAME), createShipSquare(Carrier.SHIP_SIZE));
                    carrier.setUserData(ship);
                    carrier.setOnMouseClicked(event -> setSelectedShip(carrier.getUserData()));
                    break;
                case BattleShip.SHIP_NAME:
                    battleship.getChildren().addAll(new Label(BattleShip.SHIP_NAME), createShipSquare(BattleShip.SHIP_SIZE));
                    battleship.setUserData(ship);
                    battleship.setOnMouseClicked(event ->
                            setSelectedShip(battleship.getUserData()));


                    break;
                case Destroyer.SHIP_NAME:
                    destroyer.getChildren().addAll(new Label(Destroyer.SHIP_NAME), createShipSquare(Destroyer.SHIP_SIZE));
                    destroyer.setUserData(ship);
                    destroyer.setOnMouseClicked(event ->
                            setSelectedShip(destroyer.getUserData()));


                    break;
                case Submarine.SHIP_NAME:
                    submarine.getChildren().addAll(new Label(Submarine.SHIP_NAME), createShipSquare(Submarine.SHIP_SIZE));
                    submarine.setUserData(ship);
                    submarine.setOnMouseClicked(event ->
                            setSelectedShip(submarine.getUserData()));
                    break;
                case Cruiser.SHIP_NAME:
                    cruser.getChildren().addAll(new Label(Cruiser.SHIP_NAME), createShipSquare(Cruiser.SHIP_SIZE));
                    cruser.setUserData(ship);
                    cruser.setOnMouseClicked(event ->
                            setSelectedShip(cruser.getUserData()));
            }


        }




        getChildren().addAll(carrier, battleship, cruser, submarine, destroyer);
        if (isSelected)
            carrier.setVisible(false);

    }


    private HBox createShipSquare(int size) {
        HBox hBox = new HBox();
        for (int i = 0; i < size; i++) {
            Square square = new Square();
            square.setFill(Color.GREEN);
            hBox.getChildren().addAll(square);


        }
        return hBox;
    }

    private void setSelectedShip(Object ship) {
        this.selectedShip = (Ship) ship;
        isSelected = true;


    }

    public Ship getSelectedShip() {
        return selectedShip;
    }

    public void Update(Ship ship) {
        if(ship!= null){
        for (int i =0; i< getChildren().size(); i++){
            VBox vBox =  (VBox)getChildren().get(i);
             if(vBox.getUserData().equals(ship)){
                 vBox.setVisible(false);
                 setSelectedShip(null);
             }

        }

          }

        }

}
