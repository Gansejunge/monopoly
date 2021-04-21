package monopoly.gui;

import javafx.scene.layout.VBox;
import monopoly.Player;

import java.util.List;

public class PlayerSidebar {
    VBox vBox;

    int width;
    int height;

    public PlayerSidebar(int width, int height, List<Player> players){
        this.vBox = new VBox();

        this.vBox.setPrefHeight(this.height);
        this.vBox.setPrefWidth(this.width);

        for(Player player: players){
            PlayerCard playerCard = new PlayerCard(height / 4, width, player.getName(), player.getMoney());
            this.vBox.getChildren().add(playerCard.getNode());
        }
    }



    public VBox getNode(){
        return this.vBox;
    }
}
