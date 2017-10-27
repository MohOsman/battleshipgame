package com.battleshipgame.model;
import com.battleshipgame.model.ship.Ship;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  This class represents 10X10 grid where the players will place their ships. The responsibilities of this class is to,
 *   create a grid to play on, position ships on the grid and validating postion before ship placement or attack
 * @author Mohamed Osman
 */


public class BattleGrid {



    /**
     * List of positions in the all postions on grid and a list of occupied positions
     */
    private List<Position> hitPostions;
    private List<Position> gridPositions;
    private List<Position> occupiedPositions;
    private static final int GRID_Y = 10;
    private static final int GRID_X = 10;


    public List<Position> getHitPostions() {
        return hitPostions;

    }







    /**
     *  constructor  to Initialize the objects and to create the Field
     *
     */
    public BattleGrid() {
        // list the keeps track of postions
        this.gridPositions = new ArrayList<>();
        this.occupiedPositions = new LinkedList<>();
        this.hitPostions = new ArrayList<>();
        createBattleField();

    }

    /**
     * Method to create the field. for each y, x coordinate in the grid
     * instantiate a new postion and add it to the gridPositions list
     */
    private void createBattleField() {
        for (int y = 0; y < GRID_Y; y++) {
            for (int x = 0; x < GRID_X; x++) {
                Position position = new Position(x, y);
                this.gridPositions.add(position);
            }
        }

    }

    /**
     * This method checks if the ship received can be placed on the received position with given direction
     * @param ship  The ship to place  on the grid
     * @param position The position to place the ship on
     * @param direction The ship direction in which direction will the ship be place
     * @return true and place the ship if the position is available
     */
    public boolean postionShipsOnGrid(Ship ship, Position position, int direction) {
        if (postionIsAvailable(ship, position, direction)) {
            placeShip(ship, position, direction);
            return true;
        } else
            return false;
    }


    /**
     * This method has the responsibilitiy to place/ postion ship on the grid
     *
     * @param ship  The ship to place  on the grid
     * @param position The position to place the ship on
     * @param direction The ship direction in which direction will the ship be place
     *
     */
    private void placeShip(Ship ship, Position position, int direction) {
        switch (direction) {
            case Ship.SHIP_HORIZONTAL:
                // for hoizontal direction the start index is the x coordinate of the receivdd position
                // the postions that ship will reserv is  received postion + ship size
                for (int i = position.getXcord(); i < position.getXcord() + ship.getSize(); i++) {
                    // we map the received position with the grid positions corrd
                    Position p = getPostion(i, position.getYCord());
                    // set the postion flag to occupied
                    p.setOccupied(true);
                    // add the positions to occupiedpostion lised
                    this.occupiedPositions.add(p);
                    ship.getShipPostions().add(p);
                }
                break;

            // the same operation , but in this case it is the Ycord which is the start index
            case Ship.SHIP_VERTICAL:
                for (int i = position.getYCord(); i < position.getYCord() + ship.getSize(); i++) {
                    Position p = getPostion(position.getXcord(), i);
                    p.setOccupied(true);
                    this.occupiedPositions.add(p);
                    ship.getShipPostions().add(p);
                }
                    break;



        }
    }

    /**
     * This method checks if the postion is available  in taken in consideration the ship size and direction
     *
     * @param ship  The ship to place  on the grid
     * @param position The position to place the ship on
     * @param direction The ship direction in which direction will the ship be place
     * @return true if the received position + the postions that the ship will occupie is available
     *
     */
    private boolean postionIsAvailable(Ship ship, Position position, int direction) {

        switch (direction) {
            case Ship.SHIP_HORIZONTAL:
                for (int i = position.getXcord(); i < position.getXcord() + ship.getSize(); i++) {
                    Position p = getPostion(i, position.getYCord());
                    // validates the postion p if its ok to occupie
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



        return true;
    }


    /**
     * This method validates a postion by
     * first checking if the position is inside the gird boundaries
     * second if the postion is occupied
     * third  if the there will overlap between the ships
     *
     * @param p  The position to validate
     * @return true if the postion is not valid
     */

    private boolean ValidatePosition(Position p) {

        // chceck postion p is not inside the gird boundaries
        if (!insideTheGrid(p)) {
            return true;
        }
        // if the postiion p is in the occupied positions
        if (postionsOccuppiedContians(p)) {

            return true;
        }
        // if the postion p overlapp
        return hasOverLap(p);
    }

    /**
     * This method checks if the givien position is  in side the grid
     *
     * @param position  The position to check
     * @return true if the position is true if the postion is inside the boundaries
     */
    private boolean insideTheGrid(Position position) {
        //   0 and 9 and the startpoint and the end points of the grid, so we check if the given position inside those boundires
        return position.getXcord() >= 0 && position.getXcord() <= 9 && position.getYCord() >= 0 && position.getYCord() <= 9;
    }


    /**
     * This method checks if the givien position is occupied
     *
     * @param p  The position to check
     * @return true if the position is occupied
     */
    private boolean postionsOccuppiedContians(Position p) {
        for (Position position : occupiedPositions) {
            // get postion in occupiedPositions and compare it with the received postion p
            if (p.getXcord() == position.getXcord() && p.getYCord() == position.getYCord())
                // if the x,y coordinates are same
                return true;
        }
        return false;
    }




    /**
     * This method checks if the given postion  will overlap other positions,
     * therefore we have to get the neigbor postions of the received position and check if the are inside the grid and not occupied
     *
     * @param position  The position to check
     * @return true if there is risk for overlap
     */

    // change name later to getPostionNeigbors
    private boolean hasOverLap(Position position) {
        for (Position pos : getPostionNeighbors(position)) {
            // for every neigbor position  check it is occupied and inside the grid
            if (insideTheGrid(pos) && postionsOccuppiedContians(pos))
                return true;
        }

        return false;

    }

    /**
     * This method create4s a list of nieghbor
     *
     * @param position The position to get nieghbors for
     * @return  List of neighbors of the given position
     */
    private List<Position> getPostionNeighbors(Position position) {
        List<Position> neighborList = new ArrayList<>();
        // add to the neigborList a new neighbor postion for both x coordinates and y coordinates
        neighborList.add(new Position(position.getXcord() + 1, position.getYCord()));
        neighborList.add(new Position(position.getXcord() - 1, position.getYCord()));
        neighborList.add(new Position(position.getXcord(), position.getYCord() + 1));
        neighborList.add(new Position(position.getXcord(), position.getYCord() - 1));
        return neighborList;
    }



    /**
     * This method maps the postion from the view to positions of gridPositions list
     *
     * @param x The x coordinate for postion to get
     * @param y the y coordinate for the the postiion to get
     * @return  postion that maSquare square = getSquare(position.getXcord(), position.getYCord());tchs the given x and y coordinate
     */
    private Position getPostion(int x, int y) {
        // we dont want to initialize the posY and PosX with 0 since 0 is a valid postion, i
        //if we dont find the a postion with the given x,y the position to return will contian 0,0 and we dont want that
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



    public List<Position> getPostions() {
        return gridPositions;
    }

    public List<Position> getOccupiedPositions() {
        return occupiedPositions;
    }




}
