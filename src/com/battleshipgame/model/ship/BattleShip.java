package com.battleshipgame.model.ship;

/**
 * Created by MohamedOsman on 2017-10-19.
 */
public class BattleShip extends Ship {

    public static final String SHIP_NAME = "BattleShip";
    public static final int SHIP_SIZE = 4;


    public BattleShip() {
        super(SHIP_NAME,SHIP_SIZE);
    }

    @Override
    public boolean isSunk() {
        return this.getHits() >= SHIP_SIZE;
    }
}
