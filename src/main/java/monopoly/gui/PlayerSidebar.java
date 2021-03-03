package monopoly.gui;

import javafx.scene.layout.VBox;

public class PlayerSidebar {
    VBox vBox;
    public PlayerSidebar(int width, int height, String[] players){
        this.vBox = new VBox();
        this.vBox.setPrefHeight(height);
        this.vBox.setPrefWidth(width);

        for(String playerName: players){
            PlayerCard player = new PlayerCard(height / players.length, width, playerName);
            this.vBox.getChildren().add(player.getNode());
        }
    }

    public VBox getNode(){
        return this.vBox;
    }
}
