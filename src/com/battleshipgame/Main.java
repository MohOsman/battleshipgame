package com.battleshipgame;

import com.battleshipgame.controller.GameController;
import com.battleshipgame.controller.GameEventListener;
import com.battleshipgame.model.Game;
import javafx.application.Application;
import javafx.stage.Stage;
import com.battleshipgame.view.*;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game();
        BattleShipGameStage  Stage = new BattleShipGameStage(stage);
        GameEventListener gameEventListener = new GameEventListener(Stage,game);
        GameController gameController = new GameController(game,Stage,gameEventListener);
        Stage.setGameController(gameController);
        gameController.playGame(game,Stage,gameEventListener);

    }

    public static void main(String[] args) {
        launch(args);
    }
}