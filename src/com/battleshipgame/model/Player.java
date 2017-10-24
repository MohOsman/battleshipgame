package com.battleshipgame.model;


import com.battleshipgame.model.ship.*;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohamedOsman on 2017-10-21.
 */
public  abstract class Player {

    public static int SHIPS_AMOUNT = 5;


    private PlayerType type;
    private List<Ship> unplacedShips;
    private List<Ship> placedShips;
    private BattleGrid battleGrid;


    public Player(PlayerType type, BattleGrid battleGrid) {
        this.type = type;
        this.placedShips = new ArrayList<>();
        this.unplacedShips = new ArrayList<>();
        this.battleGrid = battleGrid;
        initializeShips();

    }


    // create ships with Factory Pattren
    public void initializeShips() {
        ShipFactory shipFactory = new ShipFactory();
        unplacedShips.add(shipFactory.createShip(Carrier.SHIP_NAME));
        unplacedShips.add(shipFactory.createShip(BattleShip.SHIP_NAME));
        unplacedShips.add(shipFactory.createShip(Cruiser.SHIP_NAME));
        unplacedShips.add(shipFactory.createShip(Submarine.SHIP_NAME));
        unplacedShips.add(shipFactory.createShip(Destroyer.SHIP_NAME));
    }


    public void setBattleGrid(BattleGrid battleGrid) {

        this.battleGrid = battleGrid;
    }


// hit


    public BattleGrid getBattleGrid() {
        return battleGrid;
    }

    public List<Ship> getUnplacedShips() {
        return unplacedShips;
    }


    public PlayerType getType() {
        return type;
    }

    public abstract boolean placeShip(Ship shipSelected, Position position, int shipdirection);

    public boolean allShipsPlaced() {
        return getPlacedShips().size() >= 5;  // index starts from 0 --> 4 = 5 ships
    }

    public List<Ship> getPlacedShips() {
        return placedShips;
    }

    public abstract void placeShip();


    public int getDirection(List<Ship> ships) {
        for (Ship s : ships)
            return s.getDirection();
        return -1;


    }
}