package com.battleshipgame.view;


import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends  Rectangle {

    private static  final Color OCCUPIED_COLOR  = Color.GRAY;
    private static  final Color OCCUPIED_STROKE = Color.AQUA;
    private static final Color SQUARE_COLOR = Color.BLUE;
    private static final Color SQUARE_STROKE = Color.WHITE;





    private  int xPostison ;
    private int yPosttion ;
    private boolean Occupied;
    private boolean clicked;


    public Square(int xPostison, int yPosttion) {
        super(20,20);
        this.xPostison = xPostison;
        this.yPosttion = yPosttion;
        setup();
    }

    public Square() {
        super(20,20);
        setup();
    }

    private void setup() {
       setFill(SQUARE_COLOR);
       setStroke(SQUARE_STROKE);
    }



    public boolean isOccupied() {
        return Occupied;
    }

    public int getxPostison() {
        return xPostison;
    }

    public int getyPosttion() {
        return yPosttion;
    }




}
