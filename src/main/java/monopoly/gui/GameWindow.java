package monopoly.gui;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import monopoly.Player;

public class GameWindow extends Application{

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Monopoly");

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

        /////////////////////////
        // right side
        ////////////////////////
        String[] players = {"Florian", "Dennis", "Tobias"};
        PlayerSidebar playerSidebar = new PlayerSidebar(sidebarWidth, sidebarHeight, players);


        mainLayout.setRight(playerSidebar.getNode());

        /////////////////////////
        // bottom pane
        ////////////////////////
        VBox bottomPane = new VBox();
        bottomPane.setPrefHeight(bottomPaneHeight);
        mainLayout.setBottom(bottomPane);
        Scene scene = new Scene(mainLayout, width, height);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
