package com.battleshipgame.view;

import com.battleshipgame.model.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


/**
 * Created by MohamedOsman on 2017-10-21.
 */
public class GameSence extends  BorderPane {


   private BattleGridView userBattleGridView;
   private BattleGridView AIPlayerBattleGridview;
   private ShipSelection shipSelection;
   private Button startButton;
   private  Button setupButton;
   private Alert alert;

    public GameSence() {

    }


    public  void  createGameWindow(Game game , GameEventListener gameEventListener) {
        initializeGrid(game, gameEventListener);
        createSelectionShips(game, gameEventListener);
        createControls(gameEventListener);
        hideElements();

        }

    private void initializeGrid(Game game, GameEventListener mouseListenr) {
        this.userBattleGridView = new BattleGridView(mouseListenr);
        this.AIPlayerBattleGridview = new BattleGridView(mouseListenr);
        HBox hBox = new HBox(50, AIPlayerBattleGridview, userBattleGridView );
        setMargin(hBox,new Insets(50,50,10,0));
        hBox.setAlignment(Pos.CENTER);
        setCenter(hBox);
    }



    public void createSelectionShips(Game game, GameEventListener mouseListener){
     shipSelection = new ShipSelection(game.getPlayerShips(),mouseListener);
        setMargin(shipSelection,new Insets(50,50,10,0));
        setRight(shipSelection);

    }

    public  void createControls(GameEventListener gameEventListener){

        setupButton = new Button("SetUp");
        setupButton.setPrefSize(60,30);
        setupButton.setOnAction(event -> {
           showElements();
         getAIPlayerBattleGridview().disableGrid();
           hideButton();

        });

        startButton = new Button("Start");
        startButton.setPrefSize(60,30);
        startButton.setOnAction(event -> {
                    if (getShipSelection().getSelectedships().size() == 0) {
                        getAIPlayerBattleGridview().enableGrid();
                        getUserBattleGridView().disableGrid();
                    }
                }

        );

        setMargin(setupButton, new Insets(20,30,300,400));
        HBox hBox = new HBox(50,setupButton,startButton);
        setMargin(hBox, new Insets(20,30,300,300));
        setBottom(hBox);
    }

    public  void hideElements(){
        getAIPlayerBattleGridview().setVisible(false);
        getUserBattleGridView().setVisible(false);
        getShipSelection().setVisible(false);
        startButton.setDisable(true);

    }

    public  void showElements(){
        getAIPlayerBattleGridview().setVisible(true);
        getUserBattleGridView().setVisible(true);
        getShipSelection().setVisible(true);
        startButton.setDisable(false);

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
        setupButton.setDisable(true);



    }
}
