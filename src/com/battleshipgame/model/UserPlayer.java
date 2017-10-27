package com.battleshipgame.model;

import com.battleshipgame.model.ship.Ship;


/**
 * User Player exteds Player Class
 * @author MohamedOsman
 */
public class UserPlayer extends Player {

    /**
     * The Battlegrid of the user
     */
    private static BattleGrid battleGrid = new BattleGrid();

    public UserPlayer() {

        super(PlayerType.USERPLAYER, battleGrid);

    }


    /**
     * This method places the ship selected  in a postion the was clicked by user
     * @param shipSelected  Ship selected form selection View
     * @param position    the Postion to position it on
     * @param shipdirection   vertical or horzontal  1 or 0
     * @return
     */
    @Override
    public boolean placeShip(Ship shipSelected, Position position, int shipdirection) {
        if (getBattleGrid().postionShipsOnGrid(shipSelected, position, shipdirection)) {
            addShip(shipSelected);
            return true;
        }
        return false;

    }

    // only implmented in AI
    @Override
    public void placeShip() {
        // not used
    }


    /***
     * This method is method to attack the AI player gird the user clicks on the AI  it the postion clicked
     * is an occupied postion that means it is a ship there and its a hit
     * @param position Position to attack
     * @param player  The Player to Attack
     */
    @Override
    public void attack(Position position, Player player) {
        for (Position occupiedPostion : player.getBattleGrid().getOccupiedPositions()) {
            if (position.equals(occupiedPostion)) {
                position.setHit(true);
                updateShipHits(position,player);
            }
        }


    }


    /**
     *
     * @return if all hte ships sunk
     */
    @Override
    public boolean allShipsSunked() {
      return  getPlacedShips().stream().allMatch(Ship::isSunk);
    }


    @Override
    public Position attack(BattleGrid battleGrid, Player userPlayer) {
        // implmented by AI player class
        return null;}


}
