package com.battleshipgame.model.ship;

/**
 * Created by MohamedOsman on 2017-10-19.
 */
public class Cruiser extends Ship {
    public static final String SHIP_NAME = "Crusier";
    public static final int SHIP_SIZE = 3;

    public Cruiser() {
        super(SHIP_NAME, SHIP_SIZE);
    }

    @Override
    public boolean isSunk() {
        return this.getHits() >= SHIP_SIZE;
    }
}
