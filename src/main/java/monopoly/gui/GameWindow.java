package monopoly.gui;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import monopoly.GameController;
import monopoly.Player;

public class GameWindow extends Application{
    public Stage stage;

    GameController gameController;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        this.stage = stage;
        this.showMainMenu();
    }

    public void initGameController(ArrayList<Player> players){
        this.gameController = new GameController(players);
    }

    private void showMainMenu(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/mainmenu.fxml"));
            Parent root = loader.load();
            MainMenu mainMenuController = loader.getController();
            mainMenuController.setGameWindow(this);
            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void showGameSetup(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/gamesetup.fxml"));
            Parent root = loader.load();
            GameSetup gameSetupController = loader.getController();
            gameSetupController.setGameWindow(this);
            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void showGameBoard(){
        MainView gameWindow2 = new MainView(this.gameController);
        this.stage.setScene(gameWindow2.getScene());
    }

    public static void main(String[] args) {
        launch();
    }
}
