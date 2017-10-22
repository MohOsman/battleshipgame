package com.battleshipgame.model;

import com.battleshipgame.*;
import com.battleshipgame.model.ship.Ship;
import com.battleshipgame.view.Square;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.List;

public class BattleGrid {

    // Responsblields
    // Create a battleField
    // Position Ships recvied from player in the recivced postion, checke if the postion is not occpiuied by
    // other ship

    public List<Position> postions;
    private static final int GRID_Y = 10;
    private static final int GRID_X = 10;
    private static Position p;

    public BattleGrid() {
        // list the keeps track of postions
        this.postions = new ArrayList<>();

        createBattleField();

    }

    private void createBattleField() {
        for (int y = 0; y < GRID_Y; y++) {
            for (int x = 0; x < GRID_X; x++) {
                Position position = new Position(x, y);
                this.postions.add(position);
            }
        }

    }

    public Boolean postionShipsOnGrid(Ship ship, Position position, int direction) {

        switch (direction) {
            case Ship.SHIP_VERTICAL:

                for (int i = position.getYCord(); i < position.getYCord() + ship.getSize(); i++) {
                    Position p = getPostion(position.getXcord(), i);
                    if (isPostionValid(ship, p, Ship.SHIP_VERTICAL)) {
                        position.setOccupied(true);
                        this.postions.set(this.postions.indexOf(p), p);
                        System.out.println(p);
                        return true;
                    }
                }
                break;
            case Ship.SHIP_HORIZONTAL:
                for (int i = position.getXcord(); i < position.getXcord() + ship.getSize(); i++) {
                    Position p = getPostion(i, position.getYCord());
                    if (isPostionValid(ship, p, Ship.SHIP_HORIZONTAL)) {
                        p.setOccupied(true);
                        this.postions.set(this.postions.indexOf(p), p);

                        System.out.println(p);
                        return true;
                    }
                }
                break;


        }


        return false;


    }


    private Position getPostion(int x, int y) {
        int posX = 0;
        int posY = 0;
        for (Position p : postions) {
            if (p.getXcord() == x && p.getYCord() == y) {
                posX = p.getXcord();
                posY = p.getYCord();
            }

        }
        return new Position(posX, posY);
    }

    private Position getPostion(Position position) {
        Position returnPostion = null;
        for (Position p : postions) {
            if (p.getXcord() == position.getXcord() && p.getYCord() == position.getYCord()) {
                returnPostion = p;
            }
        }
        return returnPostion;
    }


    public boolean isPostionValid(Ship ship, Position position, int direction) {
        if (!position.isOccupied()) {
            return true;

        }

        return false;

    }

    // to Implment tomworow
    private boolean hasOverLap(Position position, Ship ship, int direction) {

        return false;

    }

    private boolean insideTheGrid(Position position, Ship ship, int direction) {
        if (direction == Ship.SHIP_VERTICAL) {
            return position.getYCord() >= 0 && position.getYCord() + ship.getSize() <= GRID_Y;

        } else {
            return position.getXcord() >= 0 && position.getXcord() + ship.getSize() <= GRID_X;

        }

    }

    public List<Position> getPostions() {
        return postions;
    }


}
