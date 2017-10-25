package com.battleshipgame;

import com.battleshipgame.model.Game;
import javafx.application.Application;
import javafx.stage.Stage;
import com.battleshipgame.view.*;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game();
        BattleShipGameStage  gameView = new BattleShipGameStage(stage);
        GameEventListener gameEventListener = new GameEventListener(gameView,game);
        GameController gameController = new GameController(game,gameView,gameEventListener);
        gameView.setGameController(gameController);
        game.addObserver(gameView);
        gameController.playGame(game,gameView,gameEventListener);

    }

    public static void main(String[] args) {
        launch(args);
    }
}