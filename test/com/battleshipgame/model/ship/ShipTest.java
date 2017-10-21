package com.battleshipgame.model.ship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MohamedOsman on 2017-10-19.
 */
public class ShipTest {
    private Ship battleShip;
    private Ship destroyer ;
    @Before
    public void setUp() throws Exception {
         battleShip = new BattleShip();
        destroyer = new Destroyer();

    }

    @Test
    public void testGettingSizeofBattleShip() throws Exception {
        int size = 4;
        assertEquals(size,battleShip.getSize());
    }

    @Test
    public void testGettingSizeofDestroyer() throws Exception {
        int size = 2;
        assertEquals(size,destroyer.getSize());
    }

    @Test
    public void testShipSunkShouldbeFalse() throws Exception {
        assertEquals(false,destroyer.isSunk());

    }
}