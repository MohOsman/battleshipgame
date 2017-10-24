package com.battleshipgame.model.ship;


import com.battleshipgame.model.Position;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Ship  {

    public  static  final int SHIP_VERTICAL = 0;
    public  static  final int SHIP_HORIZONTAL=1;

    private int size;
    private String type ;
    private int hit;
    private boolean sunk;
    private List<Position> shipPostions;
    private int direction;

    public Ship(String type, int size) {
        this.shipPostions = new LinkedList<>();
        this.type = type;
        this.size = size;
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

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public boolean isSunk() {
        return sunk;
    }

    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }


    public List<Position> getShipPostions() {
        return shipPostions;
    }

    public void setPostions(List<Position> position) {
        for (Position pos : position){
            shipPostions.add(pos);
        }





    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
