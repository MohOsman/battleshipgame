package com.battleshipgame.model;

import com.battleshipgame.model.ship.Ship;

import java.util.Random;


/**
 * AIPlayere class extends Player
 * @author  Mohamed Osman
 */
public class AIPlayer extends Player {
    /**
     * Random object to randomize both ship placemend and Attack
     *A more smarter way will be implemented in the feature, T
     * he AI player learns from previous misses and stricks att position near the hitted ones
     */
    private Random random;

    /**
     * Battlegrid of the AIPlayer
     */
    private static BattleGrid battleGrid = new BattleGrid();


    public AIPlayer() {
        super(PlayerType.AIPLAYER, battleGrid);
        this.random = new Random();

    }


    @Override
    public boolean placeShip(Ship shipSelected, Position position, int shipdirection) {
        return false; // NOT IMPLEMENTED  ONLY IN USER PLAYER

    }

    /**
     * Place Ship bt first randomizing X and Y coordinates then by randomizing directions
     * the check before placeing if the ship is already placed if not
     * Position the ship on battlehrid and add it to placedShip
     *
     */
    @Override
    public void placeShip() {
        for (Ship ship : this.getUnplacedShips()) {
            int xCord = this.random.nextInt(10);
            int yCord = this.random.nextInt(10);
            int direction = this.random.nextInt(2);
            Position randomPosition = new Position(xCord, yCord);
            if(!getPlacedShips().contains(ship)) {
                if (this.getBattleGrid().postionShipsOnGrid(ship, randomPosition, direction)) {
                    this.addShip(ship);
                }
            }
        }

    }



    @Override
    public void attack(Position position, Player player) {
        // implemented in userPlayer
    }

    /***
     * The same approch with attck to we randomiz X, Y Postion to attack ,
     * Wee loop through all the  Grid positions  and then loop thorug the occupied postions
     * if we found a match with random position then it is a hit Position els Misised on
     * @param battleGrid the Battlegrid of user player
     * @param player Player to attack
     * @return Hit Postion  or Attack Postion
     */
    @Override
    public Position attack(BattleGrid battleGrid, Player player) {
        int xCord = this.random.nextInt(10);
        int yCord = this.random.nextInt(10);
        Position position = new Position(xCord, yCord);
        Position missedPostion = null;
        for (Position pos : player.getBattleGrid().getPostions()) {
            for (Position occupiedPostion : player.getBattleGrid().getOccupiedPositions()) {
                if (position.equals(pos)) {
                    if (position.equals(occupiedPostion)){
                        position.setHit(true);
                        updateShipHits(position,player);
                        return position;
                    }
                    else{
                        missedPostion = pos;
                    }

                }

            }
        }
       return missedPostion;

}

    /**
     *
     * @return  true if all ships of AI are sunked
     */
    @Override
    public boolean allShipsSunked() {
        return getUnplacedShips().stream().allMatch(Ship::isSunk);
    }


}
