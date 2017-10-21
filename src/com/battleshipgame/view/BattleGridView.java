package com.battleshipgame.view;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import com.battleshipgame.model.*;
import javafx.scene.paint.Color;


public class BattleGridView extends GridPane {
    private BattleGrid battleGrid;
    private boolean CanPlaceShips ;
    private GameEventHandler mouseListener;
    private Square square;


    public BattleGridView( GameEventHandler mouseListener) {
        this.battleGrid= new BattleGrid();
        this.mouseListener = mouseListener;
        initializeGrid();



    }



    private void initializeGrid() {
        for(Position p : battleGrid.getPostions()){
           square= new Square(p.getXcord(),p.getYCord());
            setRowIndex(square,p.getYCord());
            square.setOnMouseClicked(getListener());
            setColumnIndex(square,p.getXcord());
            getChildren().addAll(square);
        }

    }

  public void uppdateSquare(Position postion){
        if(postion.isHit()){
            square.setFill(Color.RED);
        } else if(!postion.isHit()){
            square.setFill(Color.BLACK);
        } else if(postion.isOccupied()){
            square.setFill(Color.YELLOW);
        }
        else
            square.setFill(Color.BLUE);



    }






    public EventHandler<? super MouseEvent> getListener() {
        return this.mouseListener;
    }

    public void CanPlaceShips(Boolean CanPlaceship) {
        this.CanPlaceShips = CanPlaceShips;

    }
}





