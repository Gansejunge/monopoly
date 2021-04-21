package monopoly.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import monopoly.GameController;
import monopoly.Player;

import java.net.URL;
import java.util.ArrayList;
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
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(playerOneTextField.getText(), playerOneColour.getValue().toString()));
        players.add(new Player(playerTwoTextField.getText(), playerTwoColour.getValue().toString()));
        players.add(new Player(playerThreeTextField.getText(), playerThreeColour.getValue().toString()));
        players.add(new Player(playerFourTextField.getText(), playerFourColour.getValue().toString()));
        this.gameWindow.initGameController(players);
        this.gameWindow.showGameBoard();
    }

    public void setGameWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
    }
}
