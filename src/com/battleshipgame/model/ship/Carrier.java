package com.battleshipgame.model.ship;

/**
 * Created by MohamedOsman on 2017-10-19.
 */
public class Carrier extends Ship {

    public static final String SHIP_NAME = "Carrier";
    public static final int SHIP_SIZE = 5;

    public Carrier() {
        super(SHIP_NAME, SHIP_SIZE);
    }

}
