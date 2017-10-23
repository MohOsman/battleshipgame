package com.battleshipgame.model;


import com.battleshipgame.model.ship.Ship;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import javafx.geometry.Pos;


import java.util.ArrayList;
import java.util.List;

public class BattleGrid {

    // Responsblields
    // Create a battleField
    // Position Ships recvied from player in the recivced postion, checke if the postion is not occpiuied by
    // other ship

    private List<Position> gridPositions;
    private List<Position> occupiedPositions;
    private Status status;
    private static final int GRID_Y = 10;
    private static final int GRID_X = 10;

    public enum Status {
        PLACEBLE,
        RISKCOLLISON,
        ENDPOINT

    }


    public BattleGrid() {
        // list the keeps track of postions
        this.gridPositions = new ArrayList<>();
        this.occupiedPositions = new ArrayList<>();


        createBattleField();

    }

    private void createBattleField() {
        for (int y = 0; y < GRID_Y; y++) {
            for (int x = 0; x < GRID_X; x++) {
                Position position = new Position(x, y);
                this.gridPositions.add(position);
            }
        }

    }


    public boolean postionShipsOnGrid(Ship ship, Position position, int direction) {
        if (postionIsavailable(ship, position, direction)) {
            placeShip(ship, position, direction);
            return true;
        } else
            return false;

    }

    private void placeShip(Ship ship, Position position, int direction) {
        switch (direction) {
            case Ship.SHIP_HORIZONTAL:
                for (int i = position.getXcord(); i < position.getXcord() + ship.getSize(); i++) {
                    Position p = getPostion(i,position.getYCord());
                    p.setOccupied(true);
                    this.occupiedPositions.add(p);
                }
                break;
            case Ship.SHIP_VERTICAL:
                for (int i = position.getYCord(); i < position.getYCord() + ship.getSize(); i++) {
                    Position p = getPostion(position.getXcord(), i);
                    p.setOccupied(true);
                    this.occupiedPositions.add(p);
                }
                break;

        }

    }

    private boolean postionIsavailable(Ship ship, Position position, int direction) {

        switch (direction) {
            case Ship.SHIP_HORIZONTAL:
                for (int i = position.getXcord(); i < position.getXcord() + ship.getSize(); i++) {
                    Position p = getPostion(i, position.getYCord());

                    if (ValidatePosition(p)) return false;
                }
                break;
            case Ship.SHIP_VERTICAL:
                for (int i = position.getYCord(); i < position.getYCord() + ship.getSize(); i++) {
                    Position p = getPostion(position.getXcord(),i);


                    if (ValidatePosition(p)) return false;
                }
                break;
        }

        status= Status.PLACEBLE;

        return true;
    }

    private boolean ValidatePosition(Position p) {
        if (!insideTheGrid(p)) {
            this.status= Status.ENDPOINT;
            return true;
        }
        if (postionsOccuppiedContians(p)) {

            return true;
        }
        if (hasOverLap(p)) {
            status = Status.RISKCOLLISON;
            return true;
        }
        return false;
    }

    private boolean postionsOccuppiedContians(Position p) {
        for (Position position : occupiedPositions) {
            if (p.getXcord() == position.getXcord() && p.getYCord() == position.getYCord())
                return true;
        }
        return false;
    }


    private Position getPostion(int x, int y) {
        int posX = -1;
        int posY = -1;
        for (Position p : gridPositions) {
            if (p.getXcord() == x && p.getYCord() == y) {
                posX = p.getXcord();
                posY = p.getYCord();

            }
        }

        return new Position(posX, posY);
    }

    public Position getPostion(Position position) {
        Position returnPostion = null;
        for (Position p : gridPositions) {
            if (p.getXcord() == position.getXcord() && p.getYCord() == position.getYCord()) {
                returnPostion = p;
            }
        }
        return returnPostion;
    }


    // to Implment tomworow
    private boolean hasOverLap(Position position) {
        for (Position pos : getNeighbors(position)) {
            if (insideTheGrid(pos) && postionsOccuppiedContians(pos))
                return true;
        }

        return false;

    }

    private List<Position> getNeighbors(Position position) {
        List<Position> neigborList = new ArrayList<>();
        neigborList.add(new Position(position.getXcord() + 1, position.getYCord()));
        neigborList.add(new Position(position.getXcord() - 1, position.getYCord()));
        neigborList.add(new Position(position.getXcord(), position.getYCord() + 1));
        neigborList.add(new Position(position.getXcord(), position.getYCord() - 1));

        return neigborList;
    }

    private boolean insideTheGrid(Position position) {
        return position.getXcord() >= 0 && position.getXcord() <= 9 && position.getYCord() >= 0 && position.getYCord() <= 9;

    }


    public List<Position> getPostions() {
        return gridPositions;
    }

    public List<Position> getOccupiedPositions() {
        return occupiedPositions;
    }

    public Status getStatus() {
        return this.status;
    }



}
