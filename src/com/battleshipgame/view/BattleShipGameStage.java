package com.battleshipgame.view;

import com.battleshipgame.controller.GameController;
import com.battleshipgame.controller.GameEventListener;
import com.battleshipgame.model.Game;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***
 * This class is the motherView called the Stage, extends the stage class in javafx
 * this conectes all the views to the game and eventListner and controller
 * @author MohamedOsman
 */
public class BattleShipGameStage extends Stage{
    /**
     * Stage class of javafx to create a stage
     */
    private Stage stage;

    /**
     * Gameview which shows all the controlls and grids on the window
     */
    private GameView gameView;
    /**
     * makes sure to start the game
     */
    private GameController gameController;


    public BattleShipGameStage(Stage stage) {
        this.stage = stage;
        this.gameView = new GameView();
        // we create a scecen here to with window size 800X500
        this.stage.setScene(new Scene(gameView, 800, 500));
        this.stage.setResizable(false);


    }

    /**
     * Method that creates gameview and shows the stage, its called from the gaecontroller class
     * @param game the Game model to play
     * @param gameEventListener the listener to that listens to events
     */
    public void createGameWindow(Game game, GameEventListener gameEventListener) {
        this.gameView.createGameWindow(game,gameEventListener);
        this.stage.show();

    }
    public GameView getGameView() {
        return gameView;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }




}



