package com.battleshipgame.view;

import com.battleshipgame.model.Game;

/**
 * Created by MohamedOsman on 2017-10-20.
 */
public class GameController {


    public void playGame(Game game, BattleShipGameStage gameView, GameEventHandler mouseListener) {
     gameView.createGameWindow(game,mouseListener);
    }


}
