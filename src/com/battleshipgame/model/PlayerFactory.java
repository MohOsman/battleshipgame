package com.battleshipgame.model;

/**
 * Created by MohamedOsman on 2017-10-22.
 */
public class PlayerFactory {

    public Player createPlayer(PlayerType type){
        switch (type){
            case AIPLAYER:
                return createAIPlayer();
            case USERPLAYER:
                return createUserPlayer();

            default:return null;

        }
    }

    private Player createUserPlayer() {
        return new UserPlayer();
    }

    private Player createAIPlayer() {
        return new AIPlayer();
    }
}
