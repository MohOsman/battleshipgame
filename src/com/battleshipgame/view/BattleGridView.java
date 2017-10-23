package com.battleshipgame.view;


import com.battleshipgame.model.ship.Ship;
import com.sun.org.apache.xerces.internal.xni.grammars.Grammar;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import com.battleshipgame.model.*;
import javafx.scene.paint.Color;

import java.util.List;


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

        for(Player player :game.getPlayers()) {
            for (Position p : player.getBattleGrid().getPostions()) {

                square = new Square(p.getXcord(), p.getYCord());
                setRowIndex(square, p.getYCord());
                square.setOnMouseClicked(getListener());
                square.setUserData(p);
                setColumnIndex(square, p.getXcord());
                getChildren().addAll(square);
                if (!CanPlaceShips) {
                    square.setFill(Color.GRAY);
                    square.setDisable(true);

                }

            }
        }

    }

  public void uppdateSquare(Position pos, int shipLenght, int derection ){
      switch (derection) {
          case Ship.SHIP_VERTICAL:
              for (int i = pos.getYCord(); i < pos.getYCord() + shipLenght; i++) {
                  Square square = getSquare(pos.getXcord(), i);
                  square.setFill(Color.LIGHTBLUE);



              }
                  break;
          case  Ship.SHIP_HORIZONTAL:
                  for (int i =pos.getXcord(); i < pos.getXcord() + shipLenght; i++) {
                      Square square = getSquare(i,pos.getYCord());
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





