package com.battleshipgame.view;

import com.battleshipgame.model.Game;
import com.battleshipgame.model.Player;
import com.battleshipgame.model.PlayerType;
import com.battleshipgame.model.ship.Ship;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by MohamedOsman on 2017-10-21.
 */
public class GameSence extends  BorderPane {

   private List<BattleGridView> battleGridViews;
   private BattleGridView battleGridView;
   private ShipSelection shipSelection;

    public GameSence() {
       this.battleGridViews = new ArrayList<>();
    }


    public  void  createGameWindow(Game game , GameEventHandler mouseListenr) {
        initializeGrid(game, mouseListenr);
        createSelectionShips(game,mouseListenr);
        }

    private void initializeGrid(Game game, GameEventHandler mouseListenr) {
        for(Player player : game.getPlayers()){
             battleGridView = new BattleGridView(game,mouseListenr);
            if(player.getType() == PlayerType.AIPLAYER )
              battleGridView.CanPlaceShips(false);
            battleGridViews.add(battleGridView);


        }
        HBox hBox = new HBox(50, battleGridViews.get(0), battleGridViews.get(1));
        hBox.setAlignment(Pos.CENTER);
        setCenter(hBox);
    }


    public void createSelectionShips(Game game, GameEventHandler mouseListener){
     shipSelection = new ShipSelection(game.getShips(),mouseListener);
        setMargin(shipSelection,new Insets(50,50,10,0));
        setRight(shipSelection);

    }

    public BattleGridView getBattleGridView() {
        return this.battleGridView;
    }

    public ShipSelection getShipSelection() {
        return shipSelection;
    }
}
