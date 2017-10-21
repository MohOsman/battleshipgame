package com.battleshipgame.view;

import com.battleshipgame.model.Game;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BattleShipGameStage extends Stage {
    private Stage stage;
    private GameSence gameScene;
    private GameController gameController;


    public BattleShipGameStage(Stage stage) {
        this.stage = stage;
        this.gameController = gameController;
        this.gameScene = new GameSence();
        this.stage.setScene(new Scene(gameScene, 800, 500));
        this.stage.setResizable(false);
        this.stage.show();
    }


    public void createGameWindow(Game game, GameEventHandler mouseListener) {
        this.gameScene.createGameWindow(game,mouseListener);

    }







    public GameSence getGameScene() {
        return gameScene;
    }

    public void setGameScene(GameSence gameScene) {
        this.gameScene = gameScene;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }




}



