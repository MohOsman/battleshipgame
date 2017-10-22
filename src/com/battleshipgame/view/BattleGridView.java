package com.battleshipgame.view;


import com.battleshipgame.model.ship.Ship;
import com.sun.org.apache.xerces.internal.xni.grammars.Grammar;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import com.battleshipgame.model.*;
import javafx.scene.paint.Color;



public class BattleGridView extends GridPane {

    private BattleGrid battleGrid;
    private boolean CanPlaceShips ;
    private Game game;
    private GameEventHandler mouseListener;
    private Square square;


    public BattleGridView(Game game ,GameEventHandler mouseListener) {
        this.mouseListener = mouseListener;
        this.game = game;
        initializeGrid();



    }



    private void initializeGrid() {

        for(Position p : game.getUserPlayer().getBattleGrid().getPostions()){

           square= new Square(p.getXcord(),p.getYCord());
            setRowIndex(square,p.getYCord());
            square.setOnMouseClicked(getListener());
            square.setUserData(p);
            setColumnIndex(square,p.getXcord());
            getChildren().addAll(square);
        }

    }

  public void uppdateSquare(int xCord, int ycord, int shipLenght, int derection ){
      switch (derection) {
          case Ship.SHIP_VERTICAL:
              for (int i = ycord; i < ycord + shipLenght; i++) {
                  Square square = getSquare(xCord, i);
                  square.setFill(Color.LIGHTBLUE);

              }
                  break;
          case  Ship.SHIP_HORIZONTAL:
                  for (int i =xCord; i < xCord + shipLenght; i++) {
                      Square square = getSquare(i,ycord);
                      square.setFill(Color.GREEN);

                  }
                  break;

      }
    }

    private Square getSquare(int xCord, int ycord){
      return (Square)getChildren().get(ycord*10+xCord);
    }


    public EventHandler<? super MouseEvent> getListener() {
        return this.mouseListener;
    }

    public void CanPlaceShips(Boolean CanPlaceship) {
        this.CanPlaceShips = CanPlaceShips;

    }
}





