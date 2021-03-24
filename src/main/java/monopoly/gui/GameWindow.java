package monopoly.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import monopoly.GameController;

public class GameWindow extends Application{
    public Stage stage;

    GameController gameController;

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        this.stage = stage;
        this.gameController = new GameController();
        this.showMainMenu();
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

    }

    private static File[] getResourceFolderFiles (String folder) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(folder);
        String path = url.getPath();
        return new File(path).listFiles();
    }
    public static void main(String[] args) {
        launch();
    }
}
