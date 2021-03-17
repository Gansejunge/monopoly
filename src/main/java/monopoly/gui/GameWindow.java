package monopoly.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import monopoly.GameController;
import monopoly.field.Property;
import monopoly.game.MoveResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameWindow extends Application{
    private GameController controller;

    private static final int FIELD_WIDTH = 48;
    private static final int FIELD_HEIGHT = 96;
    private static final int FIELD_HEADER_HEIGHT = 16;

    private static final String[] players ={"Florian", "Tobias", "Dennis"};
    private final Map<String, Rectangle> playerCharacters = new HashMap<>();

    public GameWindow(){
        controller = new GameController(List.of(players));
        Random rnd = new Random();

        for(String name : players){
            Rectangle r = new Rectangle(16, 16);
            r.setFill(new Color(rnd.nextDouble(), rnd.nextDouble(), rnd.nextDouble(), 1.0));
            setR(FIELD_WIDTH * 11, FIELD_WIDTH * 11, r);
            playerCharacters.put(name, r);
        }
    }

    private Group drawBoard(){
        Group board = new Group();
        Rectangle r = new Rectangle(FIELD_WIDTH * 11, FIELD_WIDTH * 11);
        r.setFill(Color.DARKGRAY);
        r.setStrokeWidth(2.0);
        r.setStroke(Color.BLACK);

        var fields = controller.getMonopolyBoard().getAllFields();
        for(int i = 0; i < fields.size(); ++i){
            Group fieldGroup = new Group();
            Rectangle field = new Rectangle(FIELD_WIDTH, FIELD_HEIGHT);
            if(i % 10 == 0){
                field.setWidth(field.getHeight());
            }

            field.setFill(Color.WHITE);
            field.setStrokeWidth(1.0);
            field.setStroke(Color.BLACK);
            fieldGroup.getChildren().add(field);

            setCharPosition(i, fieldGroup);

            fieldGroup.setRotate(90 * Math.floorDiv(i, 10));//todo

            if(fields.get(i) instanceof Property){
                Property p = (Property) fields.get(i);
                Rectangle header = new Rectangle(FIELD_WIDTH, FIELD_HEADER_HEIGHT);
                header.setFill(Color.web(p.getGroup().getColor()));
                header.setStrokeWidth(1.0);
                header.setStroke(Color.BLACK);

                fieldGroup.getChildren().add(header);
            }

            board.getChildren().add(fieldGroup);
        }

        return board;
    }

    private void setCharPosition(int fieldIndex, Node r){
        final int TOTAL = 10 * FIELD_WIDTH;

        if(fieldIndex <= 10){
            setR(TOTAL - (fieldIndex * FIELD_WIDTH), TOTAL, r);
        } else if(fieldIndex <= 20){
            setR(0, TOTAL - ((fieldIndex - 10) * FIELD_WIDTH), r);
        } else if(fieldIndex <= 30){
            setR((fieldIndex - 20) * FIELD_WIDTH, 0, r);
        } else{
            setR(TOTAL, ((fieldIndex - 30) * FIELD_WIDTH), r);
        }
    }

    private void setR(double x, double y, Node r){
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

        Group boardGroup = drawBoard();
        for(var character : playerCharacters.values()){
            boardGroup.getChildren().add(character);
        }
        board.getNode().getChildren().add(boardGroup);

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
