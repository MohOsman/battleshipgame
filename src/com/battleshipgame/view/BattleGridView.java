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
import javafx.scene.text.Text;

import java.util.List;


public class BattleGridView extends GridPane {
    private GameEventHandler mouseListener;
    private Square[][] squares;
    public BattleGridView(GameEventHandler mouseListener) {
        this.mouseListener = mouseListener;
        this.squares = new Square[10][10];

        initializeGrid();

    }

    private void initializeGrid() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {

                squares[y][x] = new Square(y, x);
                squares[y][x].setOnMouseClicked(getListener());
                squares[y][x].setUserData(new Position(x, y));
                setRowIndex(squares[y][x], y);
                setColumnIndex(squares[y][x], x);
                getChildren().addAll(squares[y][x]);
            }
        }

    }


    public void uppdateSquare(Position pos, int shipLenght, int derection) {
        switch (derection) {
            case Ship.SHIP_VERTICAL:
                for (int i = pos.getYCord(); i < pos.getYCord() + shipLenght; i++) {
                    Square square = getSquare(pos.getXcord(), i);
                    square.setFill(Color.LIGHTBLUE);
                }
                break;
            case Ship.SHIP_HORIZONTAL:
                for (int i = pos.getXcord(); i < pos.getXcord() + shipLenght; i++) {
                    Square square = getSquare(i, pos.getYCord());
                    square.setFill(Color.GREEN);
                }
                break;

        }
    }


    private Square getSquare(int xCord, int ycord) {
        return (Square) getChildren().get(ycord * 10 + xCord);
    }


    public EventHandler<? super MouseEvent> getListener() {
        return this.mouseListener;
    }


    public void disableGrid() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                squares[y][x].setFill(Color.LIGHTGRAY);
                squares[y][x].setDisable(true);


            }
        }
    }

    public void enableGrid() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                squares[y][x].setFill(Color.BLUE);


            }
        }
    }
}





