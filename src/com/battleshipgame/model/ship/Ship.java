package com.battleshipgame.model.ship;


import java.security.PublicKey;

public abstract class Ship  {

    public  static  final int SHIP_VERTICAL = 0;
    public  static  final int SHIP_HORIZONTAL=1;

    private int size;
    private String type ;
    private int hit;
    private boolean sunk;

    public Ship(String type, int size) {
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
}
