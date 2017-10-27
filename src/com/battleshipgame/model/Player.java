package com.battleshipgame.model;


import com.battleshipgame.model.ship.*;

import java.util.ArrayList;
import java.util.List;

/***
 * This is a abstract class Player, this class handls ship createing using factory pattern
 * @author Mohamed Osman
 */
public abstract class Player {

    /**
     * playertyp type which either is  AIplayer or UserPlayer
     */
    private PlayerType type;

    /**
     * a List that holds the ships that are unplaced
     */
    private List<Ship> unplacedShips;
    /**
     * a List that holds the ships that are placed
     */
    private List<Ship> placedShips;
    /**
     * BattleGrid class  every player  has own battleGrid
     */
    private BattleGrid battleGrid;


    /***
     * A Constructer that Initialize the fields and InitializeShips
     * @param type playerType to create
     * @param battleGrid battlegrid  for each player
     */
    public Player(PlayerType type, BattleGrid battleGrid) {
        this.type = type;
        this.placedShips = new ArrayList<>();
        this.unplacedShips = new ArrayList<>();
        this.battleGrid = battleGrid;
        initializeShips();

    }


    /***
     * This Method is to initialzieShips using Factory Pattern, goal is have all ship cretated by game start
     */
    public void initializeShips() {
        ShipFactory shipFactory = new ShipFactory();
        unplacedShips.add(shipFactory.createShip(Carrier.SHIP_NAME));
        unplacedShips.add(shipFactory.createShip(BattleShip.SHIP_NAME));
        unplacedShips.add(shipFactory.createShip(Cruiser.SHIP_NAME));
        unplacedShips.add(shipFactory.createShip(Submarine.SHIP_NAME));
        unplacedShips.add(shipFactory.createShip(Destroyer.SHIP_NAME));
    }

    /***
     * This method is used to Update ships hits, this method is used by AI player and user Player
     * it lops through the placed ships positions and see if it contains the position recived which is attack postion
     * is sethit on hte ship
     * @param position Attacked Position
     * @param player The player that got Attaked
     */

    protected void updateShipHits(Position position, Player player) {
        player.getPlacedShips().forEach(ship -> {
            if (ship.getShipPostions().contains(position)) {
                ship.setHit();

            }
        });
    }

    /***
     * Abstarct method to place ship implmented in UserPlayer
     * @param shipSelected  Ship selected form selection View
     * @param position    the Postion to position it on
     * @param shipdirection   vertical or horzontal  1 or 0
     * @return true if the ship placed
     */
    public abstract boolean placeShip(Ship shipSelected, Position position, int shipdirection);


    /***
     * This method checks if all ships are placed, since we have 5 ships , we look if hte placed ship list size =5
     * @return true is all ships are placed
     */
    public boolean allShipsPlaced() {
        return getPlacedShips().size() >= 5;  // index starts from 0 --> 4 = 5 ships
    }

    /**
     * Abstract method implemented in Ai Player since it dosent need to selected ships or postion it will do that autmaticly
     */
    public abstract void placeShip();


    /**
     * Abstract Method for attacking,
     * @param position Position to attack
     * @param player  The Player to Attack
     */
    public abstract void attack(Position position, Player player);

    /**
     * Abstract method that keeps track of all the ships Sunk, implemented by both players
     * @return true if all ships sunked
     */
    public abstract boolean allShipsSunked();

    /***
     * Adds ship to Placed ships if not in there
     * @param ship to place
     */
    public void addShip(Ship ship) {
        if (!this.placedShips.contains(ship))
            this.placedShips.add(ship);
    }


    /**
     * Anthor Attaking Abstract Method  implmented by AI player to Attack user Player grid
     * @param battleGrid the Battlegrid of user player
     * @param player Player to attack
     * @return
     */
    public abstract Position attack(BattleGrid battleGrid, Player player);


    public List<Ship> getPlacedShips() {
        return placedShips;
    }

    public BattleGrid getBattleGrid() {
        return battleGrid;
    }

    public List<Ship> getUnplacedShips() {
        return unplacedShips;
    }
    public PlayerType getType() {
        return type;
    }
}