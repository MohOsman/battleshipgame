package com.battleshipgame.view;
import com.battleshipgame.controller.GameEventListener;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import com.battleshipgame.model.ship.*;

import java.util.ArrayList;
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
     * Ship the will hold refrence to selectedShip
     */
    private Ship selectedShip;

    private List<Ship> selectedships;


    /**
     * a constructor  to Initialize the objects and to create the Vbox element that represents a ship
     */
    public ShipSelection(List<Ship> ships, GameEventListener gameEventListener) {
        this.selectedships = new ArrayList<>();
        this.gameEventListener = gameEventListener;
        addShipsquare(ships);
    }


    /**
     * this Method creates a vBox that represents ship so for each ship in ships we create a vbox that holds ship name and shipviwe(Hbox of squares)
     *
     * @param  ships ,
     */
    private void addShipsquare(List<Ship> ships) {
        // vbox's  for each ship
        VBox carrierVbox = new VBox();
        VBox battleshipVbox = new VBox();
        VBox submarineVbox = new VBox();
        VBox destroyerVbox = new VBox();
        VBox cruserVbox = new VBox();
        Label carrierLabel = new Label();
        Label battelshipLabel = new Label();
        Label submarineLabel = new Label();
        Label cruserLabel = new Label();
        Label destroyerLabel = new Label();
        setTextandColor(carrierLabel, battelshipLabel, submarineLabel, cruserLabel, destroyerLabel);
        for (Ship ship : ships) {
            switch (ship.getType()) {
                case Carrier.SHIP_NAME:
                    // create vbox ship , Add the nodes  label and hbox with square to represent ship,
                    // set on click event to act on user click ship is selected
                    createShipVBox(carrierVbox, carrierLabel, ship, createShipSquare(Carrier.SHIP_SIZE), event ->
                            setSelectedShip(carrierVbox.getUserData()));

                    this.selectedships.add(ship);
                    break;
                case BattleShip.SHIP_NAME:
                    createShipVBox(battleshipVbox, battelshipLabel, ship, createShipSquare(BattleShip.SHIP_SIZE), event ->
                            setSelectedShip(battleshipVbox.getUserData()));
                    this.selectedships.add(ship);
                    break;
                case Destroyer.SHIP_NAME:
                    createShipVBox(destroyerVbox, destroyerLabel, ship, createShipSquare(Destroyer.SHIP_SIZE), event ->
                            setSelectedShip(destroyerVbox.getUserData()));
                    this.selectedships.add(ship);
                    break;
                case Submarine.SHIP_NAME:
                    createShipVBox(submarineVbox, submarineLabel, ship, createShipSquare(Submarine.SHIP_SIZE), event ->
                            setSelectedShip(submarineVbox.getUserData()));
                    this.selectedships.add(ship);
                    break;
                case Cruiser.SHIP_NAME:
                    createShipVBox(cruserVbox, cruserLabel, ship, createShipSquare(Cruiser.SHIP_SIZE), event ->
                            setSelectedShip(cruserVbox.getUserData()));
                    this.selectedships.add(ship);
            }
        }

        // add the ships to Selectionview <
        getChildren().addAll(carrierVbox, battleshipVbox, cruserVbox, submarineVbox, destroyerVbox);

    }

    /***
     * This method adds nodes to Vbox, the Nodes are Label and hbox withhbox with amount of squares of the ship size
     * for ex carrierVBox  ship size 5 = 5 squares. IT also sets mouseeventhandler wh
     * @param vBox  This holds the nodes label and hbox
     * @param carrierLabel Label holds the Ship name
     * @param ship  This is to make the Vbox represent a ship , by setting userData of vbox to ship objet
     * @param shipSquare This is hbox which holds bucnch of squares
     * @param mouseEventEventHandler  hanlder for click events on vbox
     */
    private void createShipVBox(VBox vBox, Label carrierLabel, Ship ship, HBox shipSquare, EventHandler<MouseEvent> mouseEventEventHandler) {
        // add to the vbox new label with ship name, and hbox with amount of squares of the ship size for ex carrierVBox  ship size 5 = 5 squares
        vBox.getChildren().addAll(carrierLabel, shipSquare);
        // set the ship to  as user data, to later get the ship object
        vBox.setUserData(ship);
        //  when user clicks the ship set the selectedship to user data (ship selected)
        vBox.setOnMouseClicked(mouseEventEventHandler);
    }

    private void setTextandColor(Label carrierLabel, Label battelshipLabel, Label submarineLabel, Label cruserLabel, Label destroyerLabel) {
       battelshipLabel.setText(BattleShip.SHIP_NAME);
       carrierLabel.setText(Carrier.SHIP_NAME);
       submarineLabel.setText(Submarine.SHIP_NAME);
       cruserLabel.setText(Cruiser.SHIP_NAME);
       destroyerLabel.setText(Destroyer.SHIP_NAME);
        battelshipLabel.setTextFill(Color.WHITE);
        cruserLabel.setTextFill(Color.WHITE);
        destroyerLabel.setTextFill(Color.WHITE);
        carrierLabel.setTextFill(Color.WHITE);
        submarineLabel.setTextFill(Color.WHITE);

    }

    /**
     * This method creates an hBox with bunch of squares to represent a ship
     *
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


    /**
     * This method removes ship after it had been selected so that user can not choose agin the same ship
     *
     * @param ship The ship to remove
     */
    public void remove(Ship ship) {
        if (ship != null) {
            // for each children nodes  since this class holds only vboxe nodes that represent a ship
            for (int i = 0; i < getChildren().size(); i++) {
                // we create a vbox for each node
                VBox vBox = (VBox) getChildren().get(i);
                // we get the user data of the vbox and compare it wth given ship
                if (vBox.getUserData().equals(ship)) {
                    vBox.setVisible(false);
                    setSelectedShip(null);
                    this.selectedships.remove(ship);
                }

            }

        }

    }



    private void setSelectedShip(Object ship) {
        this.selectedShip = (Ship) ship;  // since vbox.getuserdata returns object we have to cast it ship
    }

    public Ship getSelectedShip() {
        return selectedShip;
    }

    public List<Ship> getSelectedships() {
        return selectedships;
    }
}




