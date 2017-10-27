package com.battleshipgame.model;

/**
 *   A Player Factory class to Initialize Players att game start
 *   @author MohamedOsman
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
