package com.battleshipgame.model;

import com.battleshipgame.model.ship.Ship;


public class UserPlayer extends Player {

    private static BattleGrid battleGrid = new BattleGrid();

    public UserPlayer() {
        super(PlayerType.USERPLAYER, battleGrid);

    }


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


    @Override
    public void attack(Position position, Player player) {
        for (Position occupiedPostion : player.getBattleGrid().getOccupiedPositions()) {
            if (comparePositions(position, occupiedPostion)) {
                position.setHit(true);
               uppdateShiphits(position,player);


            }
        }


    }



    private void uppdateShiphits(Position position, Player player) {
        player.getPlacedShips().forEach(ship -> {
            if(ship.getShipPostions().contains(position)){
                ship.setHit();

            }
        });

        }

    @Override
    public boolean allShipsSunked() {
      return  getPlacedShips().stream().allMatch(Ship::isSunk);
    }

    @Override
    public Position attack(BattleGrid battleGrid, Player userPlayer) {
        return null;}


}
