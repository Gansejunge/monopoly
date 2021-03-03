package monopoly.gui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PlayerCard {
    HBox hBox;
    Text name;
    VBox title;

    public PlayerCard(int height, int width, String name){
        this.hBox = new HBox();
        this.name = new Text(name);
        this.title = new VBox();

        this.title.getChildren().add(this.name);
        this.hBox.getChildren().add(title);
        this.hBox.setPrefHeight(height);
        this.hBox.setStyle("-fx-border-style: solid inside; -fx-border-color: black");
    }

    public HBox getNode(){
        return this.hBox;
    }

}
