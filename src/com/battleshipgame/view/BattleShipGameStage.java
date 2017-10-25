package com.battleshipgame.view;

import com.battleshipgame.model.Game;
import com.battleshipgame.model.Observer;
import com.battleshipgame.model.State;
import com.battleshipgame.model.Subject;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BattleShipGameStage extends Stage implements Observer {
    private Stage stage;
    private Game game;
    private GameSence gameScene;
    private GameController gameController;


    public BattleShipGameStage(Stage stage) {
        this.stage = stage;

        this.gameScene = new GameSence();
        this.stage.setScene(new Scene(gameScene, 800, 500));
        this.stage.setResizable(false);
        this.stage.show();
    }


    public void createGameWindow(Game game, GameEventListener mouseListener) {
        this.game = game;
        this.gameScene.createGameWindow(game,mouseListener);


    }

    // eventlullet resna här




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


    @Override
    public void update() {

        if(getGameController().getGameState() == State.PLAYMODE){
            System.out.println("update");
           getGameScene().getUserBattleGridView().disableGrid();
           getGameScene().getAIPlayerBattleGridview().enableGrid();
           getGameScene().getAIPlayerBattleGridview().uppdateSingelSquare(game.getAIPlayer().getBattleGrid().getHitPostion());

           }
        }


}



