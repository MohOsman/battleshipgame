package com.battleshipgame.model;


import com.battleshipgame.model.ship.*;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohamedOsman on 2017-10-21.
 */
public  abstract class Player {
    private static int SHIPS_AMOUNT = 5;


    private PlayerType type;
    private List<Ship> ships;
    private BattleGrid battleGrid;



    public Player(PlayerType type) {
        this.type = type;
        this.ships = new ArrayList<>();
        this.battleGrid = new BattleGrid();
        initializeShips();

    }


    // create ships with Factory Pattren
   public void initializeShips (){
       ShipFactory shipFactory = new ShipFactory();
        ships.add(shipFactory.createShip(Carrier.SHIP_NAME));
        ships.add(shipFactory.createShip(BattleShip.SHIP_NAME));
        ships.add(shipFactory.createShip(Cruiser.SHIP_NAME));
        ships.add(shipFactory.createShip(Submarine.SHIP_NAME));
        ships.add(shipFactory.createShip(Destroyer.SHIP_NAME));
   }





    // hit


    public BattleGrid getBattleGrid() {
        return battleGrid;
    }

    public List<Ship> getShips() {
        return ships;
    }


   public  PlayerType getType(){
       return type;
    }
}