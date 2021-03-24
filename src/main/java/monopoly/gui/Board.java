package monopoly.gui;

import javafx.scene.Group;

public class Board {
    Group hbox;

    public Board(int width, int height){
//        this.hbox = new HBox();
//        this.hbox.setPrefHeight(height);
//        this.hbox.setPrefWidth(width);
//        this.hbox.setStyle("-fx-background-color: #cce3c7");
        this.hbox = new Group();
    }

    public Group getNode(){
        return this.hbox;
    }
}
