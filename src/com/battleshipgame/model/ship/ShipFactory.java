package com.battleshipgame.model.ship;

public class ShipFactory {

    public  Ship createShip(String shipname){
        switch (shipname){
            case Carrier.SHIP_NAME:
              return createCarrrier();
            case BattleShip.SHIP_NAME:
                return createBattleship();

            case Destroyer.SHIP_NAME:
                return createDestroyer();


            case Submarine.SHIP_NAME:
             return createSubmarine();


            case Cruiser.SHIP_NAME:
                return  createCruiser();

                default: return null;


        }



    }

    Ship createCarrrier() {
        return new Carrier();
    }

    Ship createBattleship() {
        return new BattleShip();
    }
    Ship createCruiser() {
        return new Cruiser();
    }
    Ship createSubmarine() {
        return new Submarine();
    }
    Ship createDestroyer() {
        return new Destroyer();
    }
}
