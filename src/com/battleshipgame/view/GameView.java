package com.battleshipgame.view;

import com.battleshipgame.controller.GameEventListener;
import com.battleshipgame.model.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


/**
 * This class contains the view of the windows, the two grids and the buttons and the ship selection view
 * @author MohamedOsman
 */
public class GameView extends  BorderPane {


    /***
     * The user and AIPlayree gridview  from The BattleGridView Class
      */
   private BattleGridView userBattleGridView;
   private BattleGridView AIPlayerBattleGridview;
    /**
     * the ships selcetion view
     */
   private ShipSelection shipSelection;
    /**
     * a start button
     */
   private  Button startButton;
    /**
     * Two label  for titels on hte girdviwq
     */
   private Label userName;
   private Label computer;

    public GameView() {

    }


    /**
     * This method creates and Initalizes all the controlls and views, and also setting a BAckground image for the game
     * @param game the Game in Model
     * @param gameEventListener  The event Listener
     */
    public  void  createGameWindow(Game game , GameEventListener gameEventListener) {
        setBackground(new Background(new BackgroundImage(new Image("/final-large.jpg",800,500,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
        initializeGrid(gameEventListener);
        createSelectionShips(game, gameEventListener);
        createControls();
        createNameTitles();
        // we hide controlls at start but then latter when startbutton gets clicked we show them
        hideElements();

        }


    /**
     *  This Method creates  girdview for both user and AIPlayer by putting them in Hbox and latter att center of the window
      * @param gameEventListener passed to hte gridview
     */
    private void initializeGrid( GameEventListener gameEventListener) {
        this.userBattleGridView = new BattleGridView(gameEventListener);
        this.AIPlayerBattleGridview = new BattleGridView(gameEventListener);
        HBox hBox = new HBox(50, AIPlayerBattleGridview, userBattleGridView );
        setMargin(hBox,new Insets(0,50,10,0));
        hBox.setAlignment(Pos.CENTER);
        setCenter(hBox);
    }


    /**
     * Create a selection view from the selection view class and place it on the side
     * @param game
     * @param gameEventListener
     */
    public void createSelectionShips(Game game, GameEventListener gameEventListener){
     shipSelection = new ShipSelection(game.getPlayerShips(),gameEventListener);
        setMargin(shipSelection,new Insets(0,50,10,0));
        setRight(shipSelection);

    }


    /**
     * creating buttons to the viww
     */
    public  void createControls(){

        startButton = new Button("Start");
        startButton.setPrefSize(60,30);
        startButton.setOnAction(event -> {
           showElements();
         getAIPlayerBattleGridview().disableGrid();
           hideButton();

        });



        setMargin(startButton, new Insets(20,30,300,300));
        setBottom(startButton);

    }

    /**
     * hide elments on the view
     */
    public  void hideElements(){
        getAIPlayerBattleGridview().setVisible(false);
        getUserBattleGridView().setVisible(false);
        getShipSelection().setVisible(false);
        userName.setVisible(false);
        computer.setVisible(false);


    }
    /**
     * show elments on the view
     */
    public  void showElements(){
        getAIPlayerBattleGridview().setVisible(true);
        getUserBattleGridView().setVisible(true);
        getShipSelection().setVisible(true);
        computer.setVisible(true);
        userName.setVisible(true);
    }

    /**
     * Creating name titles for the grid view
     */
    public void  createNameTitles(){
        userName  = new Label("Player Grid ");
        computer = new Label("Computer Grid ");
        userName.setTextFill(Color.WHITE);
         computer.setTextFill(Color.WHITE);
         HBox hBox =  new HBox(160,computer,userName);
         setMargin(hBox, new Insets(100,30,0,70));
         setTop(hBox);


    }



    public ShipSelection getShipSelection() {
        return shipSelection;
    }

    public BattleGridView getUserBattleGridView() {
        return userBattleGridView;
    }



    public BattleGridView getAIPlayerBattleGridview() {
        return AIPlayerBattleGridview;
    }



    public void hideButton() {
        startButton.setDisable(true);



    }
}
