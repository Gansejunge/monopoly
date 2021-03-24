package monopoly.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import monopoly.GameController;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class GameSetup implements Initializable {
    GameWindow gameWindow;

    @FXML
    private Button startButton;
    @FXML
    private TextField playerOneTextField;
    @FXML
    private TextField playerTwoTextField;
    @FXML
    private TextField playerThreeTextField;
    @FXML
    private TextField playerFourTextField;
    @FXML
    private ColorPicker playerOneColour;
    @FXML
    private ColorPicker playerTwoColour;
    @FXML
    private ColorPicker playerThreeColour;
    @FXML
    private ColorPicker playerFourColour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startButton.setOnAction(e -> this.setupGame());
    }

    private void setupGame(){
        String[] players = new String[4];
        players[0] = playerOneTextField.getText();
        players[1] = playerTwoTextField.getText();
        players[2] = playerThreeTextField.getText();
        players[3] = playerFourTextField.getText();
        this.gameWindow.initGameController(Arrays.asList(players));
        this.gameWindow.showGameBoard();
    }

    public void setGameWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
    }
}
