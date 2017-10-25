package com.battleshipgame.view;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import com.battleshipgame.model.ship.*;

import java.util.List;


/**
 *  This class represents a the shipselection view that the user can se on the view, it extends vbox layout
 * @author Mohamed Osman
 */

public class ShipSelection extends VBox {
    /**
     * GameEventlistener  that listens to user events
     */
    private GameEventListener gameEventListener;
    /**
     *Ship the will hold refrence to selectedShip
     */
    private Ship selectedShip;


    /**
     * a constructor  to Initialize the objects and to create the Vbox element that represents a ship
     *
     */
    public ShipSelection(List<Ship> ships, GameEventListener gameEventListener) {
        this.gameEventListener = gameEventListener;
        addShipsquare(ships);
    }




    /**
     * this Method creates a vBox that represents ship so for each ship in ships we create a vbox that holds ship name and shipviwe(Hbox of squares)
     * @param ships
     */
    private void addShipsquare(List<Ship> ships){
        // vbox's  for each ship
        VBox carrier = new VBox();
        VBox battleship = new VBox();
        VBox submarine = new VBox();
        VBox destroyer = new VBox();
        VBox cruser = new VBox();
        for (Ship ship : ships) {
            switch (ship.getType()) {
                case Carrier.SHIP_NAME:
                    // add to the vbox new label with ship name, and hbox with amount of squares of the ship size for ex carrier  ship size 5 = 5 squares
                    carrier.getChildren().addAll(new Label(Carrier.SHIP_NAME), createShipSquare(Carrier.SHIP_SIZE));
                    // set the ship to  as user data, to later get the ship object
                    carrier.setUserData(ship);
                    //  when user clicks the ship set the selectedship to user data (ship selected)
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
        // add the ships to Selectionview <
        getChildren().addAll(carrier, battleship, cruser, submarine, destroyer);

    }

    /**
     * This method creates an hBox with bunch of squares to represent a ship
     * @param size The ship size for the amount of square
     * @return Hbox with squares
     */
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
        this.selectedShip = (Ship) ship;  // since vbox.getuserdata returns object we have to cast it ship
    }

    public Ship getSelectedShip() {
        return selectedShip;
    }

    /**
     * This method removes ship after it had been selected so that user can not choose agin the same ship
     * @param ship The ship to remove
     */
    public void remove(Ship ship) {
        if(ship!= null){
            // for each children nodes  since this class holds only vboxe nodes that represent a ship
            for (int i =0; i< getChildren().size(); i++){
                // we create a vbox for each node
                VBox vBox =  (VBox)getChildren().get(i);
                // we get the user data of the vbox and compare it wth given ship
                if(vBox.getUserData().equals(ship)){
                    vBox.setVisible(false);
                    setSelectedShip(null);
                }

            }

        }

    }

    public GameEventListener getGameEventListener() {
        return gameEventListener;
    }
}