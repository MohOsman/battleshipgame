package com.battleshipgame.model;

import com.battleshipgame.model.ship.BattleShip;
import com.battleshipgame.model.ship.Destroyer;
import com.battleshipgame.model.ship.Ship;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PlayerTest {
    private  Player testplayer;
    @Before
    public void setUp() throws Exception {
         testplayer = new Player(PlayerType.AIPLAYER);

    }

    @Test
    public void testInitilizenShips() throws Exception {




    }
}