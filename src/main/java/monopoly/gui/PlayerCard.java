package monopoly.gui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PlayerCard {
    VBox main;
    HBox title;
    HBox body;
    Text name;
    Text money;


    public PlayerCard(int height, int width, String name, Integer money){
        this.main = new VBox();

        this.title = new HBox();
        this.body = new HBox();
        this.title.setPrefWidth(width);
        this.body.setPrefWidth(width);

        this.name = new Text(name);
        this.money = new Text(money.toString());

        this.title.getChildren().add(this.name);
        this.body.getChildren().add(this.money);
        this.main.getChildren().add(title);
        this.main.getChildren().add(body);
        this.main.setPrefHeight(height);
        this.main.setStyle("-fx-border-style: solid inside; -fx-border-color: black");
    }

    public void updateMoney(Integer money){
        this.money.setText(money.toString());
    }



    public VBox getNode(){
        return this.main;
    }

}
