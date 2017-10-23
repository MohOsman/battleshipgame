package com.battleshipgame.model;

import java.util.Objects;


public class Position {

    private int xCord;
    private int yCord;
    private  boolean isHit;
    private boolean occupied;


    public Position(int xCord, int yCord) {
        this.xCord =xCord;
        this.yCord = yCord;
//        setYCord(yCord);
//        setXCord(xCord);
    }


    public void setXCord(int xCord) {
        if(xCord<0|| xCord> 9 )
            throw new NumberFormatException();
        this.xCord = xCord;
    }

    public int getXcord() {
        return xCord;
    }

    public int getYCord() {
 return yCord;
    }


   public void setYCord(int yCord) {
        if(yCord<0|| yCord> 9 )
            throw new NumberFormatException();

        this.yCord = yCord;

    }





    @Override
    public String toString() {
        return "Position{" +
                "xCord=" + xCord +
                ", yCord=" + yCord +
                ", isHit=" + isHit +
                ", occupied=" + occupied +
                '}';
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
