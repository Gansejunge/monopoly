package monopoly.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import monopoly.GameController;
import monopoly.game.MoveResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameWindow extends Application{
    private GameController controller;

    private static final String[] players ={"Florian", "Tobias"};
    private final Map<String, Rectangle> playerCharacters = new HashMap<>();

    public GameWindow(){
        controller = new GameController(List.of(players));
        Random rnd = new Random();

        for(String name : players){
            Rectangle r = new Rectangle(16, 16);
            r.setFill(Color.BLACK);
            r.setFill(new Color(rnd.nextDouble(), rnd.nextDouble(), rnd.nextDouble(), 1.0));
            r.setStrokeWidth(2.0);
            r.setStroke(Color.DARKGRAY);
            setR(16 * 10, 16 * 10, r);
            playerCharacters.put(name, r);
        }
    }

    private void setCharPosition(int fieldIndex, Rectangle r){
        final int FIELD_WIDTH = 16;
        final int TOTAL = 10 * FIELD_WIDTH;

        if(fieldIndex <= 10){
            setR(TOTAL - (fieldIndex * FIELD_WIDTH), TOTAL, r);
        } else if(fieldIndex <= 20){
            setR(0, TOTAL - ((fieldIndex - 10) * FIELD_WIDTH), r);
        } else if(fieldIndex <= 30){
            setR((fieldIndex - 20) * FIELD_WIDTH, TOTAL, r);
        } else{
            setR(TOTAL, ((fieldIndex - 30) * FIELD_WIDTH), r);
        }
    }

    private void setR(double x, double y, Rectangle r){
        r.setTranslateX(x);
        r.setTranslateY(y);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Monopoly");

        Button button = new Button("Würfeln");
        button.setOnMouseClicked((e) -> {
            MoveResult move = controller.nextMove();
            setCharPosition(move.player.getPosition(), playerCharacters.get(move.player.getName()));
            System.out.println(move.player.getName() + ": " + move.player.getPosition());
        });

        int width = 1200;
        int height = 900;

        int bottomPaneHeight = 100;
        int boardHeight = height - bottomPaneHeight;
        int boardWidth = 800;
        int sidebarHeight = height - bottomPaneHeight;
        int sidebarWidth = 400;
        // main layout
        BorderPane mainLayout = new BorderPane();

        /////////////////////////
        // left side
        ////////////////////////
        Board board = new Board(boardWidth, boardHeight);
        mainLayout.setLeft(board.getNode());

//        Group playerCharGroup = new Group();
//        for(var character : playerCharacters.values()){
//            playerCharGroup.getChildren().add(character);
//        }
        board.getNode().getChildren().addAll(playerCharacters.values());

        /////////////////////////
        // right side
        ////////////////////////
        PlayerSidebar playerSidebar = new PlayerSidebar(sidebarWidth, sidebarHeight, players);


        mainLayout.setRight(playerSidebar.getNode());

        /////////////////////////
        // bottom pane
        ////////////////////////
        VBox bottomPane = new VBox();
        bottomPane.setPrefHeight(bottomPaneHeight);
        bottomPane.getChildren().add(button);

        mainLayout.setBottom(bottomPane);
        Scene scene = new Scene(mainLayout, width, height);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
