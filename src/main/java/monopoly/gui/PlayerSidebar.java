package monopoly.gui;

import javafx.scene.layout.VBox;
import monopoly.Player;

import java.util.List;

public class PlayerSidebar {
    VBox vBox;

    public PlayerSidebar(int width, int height, List<Player> players){
        this.vBox = new VBox();
        this.vBox.setPrefHeight(height);
        this.vBox.setPrefWidth(width);

        for(Player player: players){
            PlayerCard playerCard = new PlayerCard(height / 4, width, player.getName(), player.getMoney());
            this.vBox.getChildren().add(playerCard.getNode());
        }
    }

    public VBox getNode(){
        return this.vBox;
    }
}
