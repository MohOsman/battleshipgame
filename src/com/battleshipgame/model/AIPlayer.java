package com.battleshipgame.model;

import com.battleshipgame.model.Player;
import com.battleshipgame.model.PlayerType;
import com.battleshipgame.model.ship.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by MohamedOsman on 2017-10-22.
 */
public class AIPlayer extends Player {
    private Random random;

    private static  BattleGrid battleGrid = new BattleGrid();

    public AIPlayer() {
        super(PlayerType.AIPLAYER,battleGrid);
        this.random = new Random();

    }

    @Override
    public boolean placeShip(Ship shipSelected, Position position, int shipdirection) {
        return false;

    }

    @Override
    public void  placeShip() {
        for (Ship ship : getUnplacedShips()) {
            int xCord = this.random.nextInt(10);
            int yCord = this.random.nextInt(10);
            int direction = this.random.nextInt(2);
            Position randomPosition = new Position(xCord, yCord);
            if (getBattleGrid().postionShipsOnGrid(ship, randomPosition, direction)){
                ship.setDirection(direction);
                getPlacedShips().add(ship);
            System.out.println("ship " + ship.getType() +"is placed");
            }

        }

    }

    @Override
    public Boolean hit(Position position) {
        return null;
    }


    @Override
    public boolean attack(Position position, BattleGrid battleGrid) {
        return false;
    }


}
