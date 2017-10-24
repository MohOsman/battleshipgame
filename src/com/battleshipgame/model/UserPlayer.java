package com.battleshipgame.model;

import com.battleshipgame.model.Player;
import com.battleshipgame.model.PlayerType;
import com.battleshipgame.model.ship.Ship;


public class UserPlayer extends Player {

    private static BattleGrid battleGrid = new BattleGrid();

    public UserPlayer() {
        super(PlayerType.USERPLAYER,battleGrid) ;

    }




    @Override
    public boolean placeShip(Ship shipSelected, Position position, int shipdirection) {
        if(getBattleGrid().postionShipsOnGrid(shipSelected,position,shipdirection)){
            getPlacedShips().add(shipSelected);
            return true;
        }
        return false;

    }

    // only implmented in AI
    @Override
    public void placeShip() {
        // not used
    }
}
