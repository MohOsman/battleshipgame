package com.battleshipgame.view;


import com.battleshipgame.model.ship.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import com.battleshipgame.model.*;
import javafx.scene.paint.Color;

import java.util.List;



public class BattleGridView extends GridPane{
    private GameEventListener mouseListener;
    private Square[][] squares;

    public BattleGridView(GameEventListener mouseListener)  {
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
                squares[y][x].setDisable(false);
            }
        }
    }

    /// test delete latter !

    public void showShips(List<Position> positions) {
        for (Position p : positions) {
            Square square = getSquare(p.getXcord(), p.getYCord());
            square.setFill(Color.RED);
        }
    }

    public void uppdateSingelSquare(Position position) {
        Square square = getSquare(position.getXcord(),position.getYCord());
        if (position.isHit()) {
                square.setFill(Color.RED);
            } else
                square.setFill(Color.BLACK);
        }


}












