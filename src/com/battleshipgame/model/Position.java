package com.battleshipgame.model;

import java.util.Objects;


public class Position {

    private int xCord;
    private int yCord;
    private  boolean isHit;
    private boolean occupied;


    public Position(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }


    public void setXCord(int xCord) {
        this.xCord = xCord;
    }

    public int getXcord() {
        return xCord;
    }

    public int getYCord() {
 return yCord;
    }


    public void setYCord(int yCord) {
        this.yCord = yCord;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position postion = (Position) o;
        return xCord == postion.xCord &&
                yCord == postion.yCord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.xCord,this.yCord);
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
