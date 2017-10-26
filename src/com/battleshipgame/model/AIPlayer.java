package com.battleshipgame.model;

import com.battleshipgame.model.ship.Ship;

import java.util.Random;

/**
 * Created by MohamedOsman on 2017-10-22.
 */
public class AIPlayer extends Player {
    private Random random;

    private static BattleGrid battleGrid = new BattleGrid();

    public AIPlayer() {
        super(PlayerType.AIPLAYER, battleGrid);
        this.random = new Random();

    }

    @Override
    public boolean placeShip(Ship shipSelected, Position position, int shipdirection) {
        return false;

    }

    @Override
    public void placeShip() {
        for (Ship ship : this.getUnplacedShips()) {
            int xCord = this.random.nextInt(10);
            int yCord = this.random.nextInt(10);
            int direction = this.random.nextInt(2);
            Position randomPosition = new Position(xCord, yCord);
            if(!getPlacedShips().contains(ship)) {
                if (this.getBattleGrid().postionShipsOnGrid(ship, randomPosition, direction)) {
                    System.out.println(ship.getType() + "is added ");
                    this.addShip(ship);
                }
            }
        }

    }



    @Override
    public void attack(Position position, Player player) {
        // implemented in userPlayer
    }

    @Override
    public Position attack(BattleGrid battleGrid, Player player) {
        int xCord = this.random.nextInt(10);
        int yCord = this.random.nextInt(10);
        Position position = new Position(xCord, yCord);
        Position missedPostion = null;
        for (Position pos : player.getBattleGrid().getPostions()) {
            for (Position occupiedPostion : player.getBattleGrid().getOccupiedPositions()) {
                if (comparePositions(position,pos)) {
                    if (comparePositions(position,occupiedPostion)){
                        position.setHit(true);
                        uppdateShipState(position,player);
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

    private void uppdateShipState(Position position, Player player) {
        player.getPlacedShips().forEach(ship -> {
            if(ship.getShipPostions().contains(position)){
                ship.setHit();

            }
        });
    }


    @Override
    public boolean allShipsSunked() {
        return getUnplacedShips().stream().allMatch(Ship::isSunk);
    }


}
