package monopoly.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {
    GameWindow gameWindow;

    @FXML
    private Button startButton;
    @FXML
    private Button exitButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startButton.setOnAction(e -> this.gameWindow.showGameSetup());
        exitButton.setOnAction(e -> System.out.println(rb));
    }

    public void setGameWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
    }
}
