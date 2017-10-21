package com.battleshipgame.model.ship;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;


public class ShipFactoryTest {



    @Test
    public void testCreateCarrier() throws Exception {
       ShipFactory mockFactory = mock(ShipFactory.class);
        when(mockFactory.createShip(anyString())).thenCallRealMethod();
        mockFactory.createShip(Carrier.SHIP_NAME);
        verify(mockFactory).createCarrrier();
    }

    @Test
    public void testCreateBattleShip() throws Exception {
        ShipFactory mockFactory = mock(ShipFactory.class);
        when(mockFactory.createShip(anyString())).thenCallRealMethod();
        mockFactory.createShip(BattleShip.SHIP_NAME);
        verify(mockFactory).createBattleship();
    }

    @Test
    public void testCreateDestoryer() throws Exception {
        ShipFactory mockFactory = mock(ShipFactory.class);
        when(mockFactory.createShip(anyString())).thenCallRealMethod();
        mockFactory.createShip(Destroyer.SHIP_NAME);
        verify(mockFactory).createDestroyer();
    }


     @Test
    public void testCreateSubmarine() throws Exception {
        ShipFactory mockFactory = mock(ShipFactory.class);
        when(mockFactory.createShip(anyString())).thenCallRealMethod();
        mockFactory.createShip(Submarine.SHIP_NAME);
        verify(mockFactory).createSubmarine();
    }

    @Test
    public void testCreateCruiser() throws Exception {
        ShipFactory mockFactory = mock(ShipFactory.class);
        when(mockFactory.createShip(anyString())).thenCallRealMethod();
        mockFactory.createShip(Cruiser.SHIP_NAME);
        verify(mockFactory).createCruiser();
    }



}