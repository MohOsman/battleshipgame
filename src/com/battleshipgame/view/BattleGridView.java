package com.battleshipgame.view;


import com.battleshipgame.controller.GameEventListener;
import com.battleshipgame.model.ship.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import com.battleshipgame.model.*;
import javafx.scene.paint.Color;


/**
 * class the represents the view of hte grid, it extends javafx grid pane
 * there you have both rows and columns
 * @author MohamedOsman
 */

public class BattleGridView extends GridPane{
    /**
     * GameeventListenr listens to user evetns
     */
    private GameEventListener gameEventListener;
    /**
     * Square class to represents postion in the grid
     */
    private Square[][] squares;

    /**
     * Constructor to Initilze
     * @param gameEventListener listens to events when clicking the borad
     */
    public BattleGridView(GameEventListener gameEventListener)  {
        this.gameEventListener = gameEventListener;
        //  10 by 10 grid
        this.squares = new Square[10][10]; // 2darray
        initializeGrid();

    }

    /**
     * Create a grid by using a neasted forlopp and creating a 2DArray for with rows and columns
     */

    private void initializeGrid() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {

                squares[y][x] = new Square(x, y);// new Square
                squares[y][x].setOnMouseClicked(getListener()); // set on every square a Listener
                squares[y][x].setUserData(new Position(x, y));  // set user  data to Postion object
                setRowIndex(squares[y][x], y); // use the gridpane to set the rows
                setColumnIndex(squares[y][x], x);
                getChildren().addAll(squares[y][x]); // add it to the gridpane
            }
        }

    }


    /***
     * This method updates the color of the squares in the grid when a ships has been positon on it
     * @param pos  postion  to start form
     * @param shipLenght the shiplenght is how many squares we change the color on
     * @param derection  the direction for changeing color and start poing
     */

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

    /**
     * this method gives us a singele square using the index of the grid pance
     *  for example if we want x = 4 and y =3 the sqaure we get is in index 43
     * @param xCord   X to map on the square postion on the grid
     * @param ycord  Y to map the Square Postion on the Grid
     * @return SQuare with that postion(x,Y)
     *
     */
    private Square getSquare(int xCord, int ycord) {
        return (Square) getChildren().get(ycord * 10 + xCord);
    }


    public EventHandler<? super MouseEvent> getListener() {
        return this.gameEventListener;
    }


    /**
     * Disble all the gridview and clicking useful when userplayer and AI Player change turns
     */
    public void disableGrid() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                squares[y][x].setFill(Color.LIGHTGRAY);
                squares[y][x].setDisable(true);
            }
        }
    }

    /**
     * enbalbe all the gridview and clicking useful when userplayer and AI Player change turns
     */
    public void enableGrid() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                squares[y][x].setFill(Color.BLUE);
                squares[y][x].setDisable(false);
            }
        }
    }

    /**
     *  This method gets called when and attack is occured if is a hit RED else Black
     * @param position to update color on
     */

    public void uppdateSingelSquare(Position position) {
        Square square = getSquare(position.getXcord(),position.getYCord());
        if (position.isHit()) {
                square.setFill(Color.RED);
            } else
                square.setFill(Color.BLACK);
        }


}












