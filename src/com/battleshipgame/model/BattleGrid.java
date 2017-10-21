package com.battleshipgame.model;
import com.battleshipgame.*;
import com.battleshipgame.model.ship.Ship;


import java.util.ArrayList;
import java.util.List;

public class BattleGrid {

    // Responsblields
    // Create a battleField
    // Position Ships recvied from player in the recivced postion, checke if the postion is not occpiuied by
    // other ship

    public  List<Position> postions;



    private static final int GRID_Y = 10;
    private static final int GRID_X = 10;
    private boolean postionValid;

    public BattleGrid() {
        // list the keeps track of postions
        this.postions = new ArrayList<Position>();
        createBattleField();

    }

  private void createBattleField() {
        for (int y = 0; y < GRID_Y; y++) {
            for (int x = 0; x < GRID_X; x++) {
               Position position = new Position(x,y);
               this.postions.add(position);



            }
        }

    }

    public void  postionShipsOnGrid(Ship ship, Position position, boolean verticaly){




    }

    public boolean isPostionValid(Ship SelectedShip ,Position position) {
return false;


    }

    public List<Position> getPostions() {
        return postions;
    }


}
