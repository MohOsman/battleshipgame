package com.battleshipgame.model;

import com.battleshipgame.model.ship.Carrier;
import com.battleshipgame.model.ship.Ship;
import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UserPlayerTest {
    private Player userPlayer;
    private Position position;
    private BattleGrid battleGrid;
    private Ship ship;



    @Before
    public void setUp() throws Exception {
     userPlayer = new UserPlayer();


    }

    @Test
    public void testUserPlaceShipOnGridShouldRetrunTrue() throws Exception {
        ship = new Carrier();
        position = new Position(1,2);
        assertTrue(userPlayer.placeShip(ship,position,1));
    }


    @Test
    public void testUserPlaceShipOnGridWithWrongPostionShouldRetrunFalse() throws Exception {
        ship = new Carrier();
        position = new Position(12,31);
        assertFalse(userPlayer.placeShip(ship,position,1));
    }



}