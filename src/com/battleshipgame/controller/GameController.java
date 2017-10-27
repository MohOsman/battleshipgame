package com.battleshipgame.controller;

import com.battleshipgame.controller.GameEventListener;
import com.battleshipgame.model.Game;
import com.battleshipgame.model.State;
import com.battleshipgame.view.BattleShipGameStage;

/**
 * Created by MohamedOsman on 2017-10-20.
 */
public class GameController {
    private Game game;
    private BattleShipGameStage stage;
    private GameEventListener gameEventListener;

    public GameController(Game game, BattleShipGameStage gameView, GameEventListener gameEventListener) {
        this.game = game;
        this.stage = gameView;
        this.gameEventListener  = gameEventListener;

    }


    public void playGame(Game game, BattleShipGameStage gameView, GameEventListener mouseListener) {
     gameView.createGameWindow(game,mouseListener);

    }

    public State getGameState(){
        return  game.getState();
    }


    public Game getGame() {
        return game;
    }
}
