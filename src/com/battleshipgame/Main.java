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
        GameEventHandler mouseListener = new GameEventHandler(gameView,game);
        GameController gameController = new GameController();

        gameController.playGame(game,gameView,mouseListener);

    }

    public static void main(String[] args) {
        launch(args);
    }
}