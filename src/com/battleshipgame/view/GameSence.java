package com.battleshipgame.view;

import com.battleshipgame.model.Game;
import com.battleshipgame.model.State;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by MohamedOsman on 2017-10-21.
 */
public class GameSence extends  BorderPane {

   private List<BattleGridView> battleGridViews;
   private BattleGridView userBattleGridView;
   private BattleGridView AIPlayerBattleGridview;
   private ShipSelection shipSelection;
   private  Button startButton;

    public GameSence() {
       this.battleGridViews = new ArrayList<>();
    }


    public  void  createGameWindow(Game game , GameEventHandler gameEventHandler) {
        initializeGrid(game, gameEventHandler);
        createSelectionShips(game,gameEventHandler);
        createStartButton(gameEventHandler);
        hideElements();

        }

    private void initializeGrid(Game game, GameEventHandler mouseListenr) {
        this.userBattleGridView = new BattleGridView(mouseListenr);
        this.AIPlayerBattleGridview = new BattleGridView(mouseListenr);
        HBox hBox = new HBox(50, AIPlayerBattleGridview, userBattleGridView );
        setMargin(hBox,new Insets(50,50,10,0));
        hBox.setAlignment(Pos.CENTER);
        setCenter(hBox);
    }



    public void createSelectionShips(Game game, GameEventHandler mouseListener){
     shipSelection = new ShipSelection(game.getPlayerShips(),mouseListener);
        setMargin(shipSelection,new Insets(50,50,10,0));
        setRight(shipSelection);

    }

    public  void createStartButton(GameEventHandler gameEventHandler){

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

    public  void hideElements(){
        getAIPlayerBattleGridview().setVisible(false);
        getUserBattleGridView().setVisible(false);
        getShipSelection().setVisible(false);

    }

    public  void showElements(){
        getAIPlayerBattleGridview().setVisible(true);
        getUserBattleGridView().setVisible(true);
        getShipSelection().setVisible(true);

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
