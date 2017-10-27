package com.battleshipgame.model.ship;


import com.battleshipgame.model.Position;

import java.util.LinkedList;
import java.util.List;

/**
 * Abstract class the represents ship objeect, this class keeps track of ships and size and postions
 */
public abstract class Ship  {

    /**
     * static final Ship directions
     */
    public  static  final int SHIP_VERTICAL = 0;
    public  static  final int SHIP_HORIZONTAL=1;


    private int size;
    private String type ;
    private int hit;
    private boolean sunk;
    /**
     * ship postions on the grid
     */
    private List<Position> shipPostions;
    private int direction;

    public Ship(String type, int size) {
        this.shipPostions = new LinkedList<>();
        this.type = type;
        this.size = size;
        this.hit =0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHits() {
        return hit;
    }

    /**
     * every time this is called we incrase it each ship speratly if the hit == shipsize  the ship sinks
     */
    public void setHit() {
      hit++;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (size != ship.size) return false;
        if (hit != ship.hit) return false;
        if (sunk != ship.sunk) return false;
        if (direction != ship.direction) return false;
        if (type != null ? !type.equals(ship.type) : ship.type != null) return false;
        return shipPostions != null ? shipPostions.equals(ship.shipPostions) : ship.shipPostions == null;
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + hit;
        result = 31 * result + (sunk ? 1 : 0);
        result = 31 * result + (shipPostions != null ? shipPostions.hashCode() : 0);
        result = 31 * result + direction;
        return result;
    }

    /**
     * This method is implementd by all ships to keep track if the ship sunk or not
     * @return
     */
    public abstract boolean isSunk();


    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }


    public List<Position> getShipPostions() {
        return shipPostions;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
