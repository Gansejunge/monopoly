package monopoly.gui;

import javafx.scene.layout.HBox;

public class Board {
    HBox hbox;

    public Board(int width, int height){
        this.hbox = new HBox();
        this.hbox.setPrefHeight(height);
        this.hbox.setPrefWidth(width);
        this.hbox.setStyle("-fx-background-color: #cce3c7");
    }

    public HBox getNode(){
        return this.hbox;
    }
}
