package monopoly.gui;

import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import monopoly.GameController;
import monopoly.Player;
import monopoly.deck.Card;
import monopoly.deck.CardType;
import monopoly.field.Property;
import monopoly.game.MoveResult;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

public class MainView implements Initializable {
    private GameController controller;
    private Scene scene;
    private static final int FIELD_WIDTH = 66;
    private static final int FIELD_HEIGHT = FIELD_WIDTH * 2;
    private static final int FIELD_HEADER_HEIGHT = 28;

    private final Map<Integer, Rectangle> playerCharacters = new HashMap<>();
    private DiceView diceView;
    private Group boardGroup;

    private GUIListener listener = new GUIListener() {
        @Override
        public void onMove(MoveResult move) {
            setCharPosition(move.player.getPosition(), playerCharacters.get(move.player.getId()));


        }

        @Override
        public void onDrawCard(Card card) {
            var c = new CardView();
            var group = c.getCard(card);
            c.animCard(group);

            boardGroup.getChildren().add(group);
        }

        @Override
        public void onRequestPropertyPurchase(Property field) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, field.getName() + " für " + field.getPrice() + "€ kaufen?");
            alert.showAndWait()
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> controller.buy(controller.getCurrentPlayer(), field));
        }

        @Override
        public void updatePlayerMoney() {
            for(Player p : controller.getPlayers()){
                //todo
                System.out.println(p.getMoney());
            }
        }
    };

    public MainView(GameController controller) {
        this.controller = controller;
        this.controller.addEventListener(listener);

        this.diceView = new DiceView(controller);

        Random rnd = new Random();

        for (Player player : controller.getPlayers()) {
            Rectangle r = new Rectangle(16, 16);
            r.setFill(new Color(rnd.nextDouble(), rnd.nextDouble(), rnd.nextDouble(), 1.0));
            setR(FIELD_WIDTH * 11, FIELD_WIDTH * 11, r);
            playerCharacters.put(player.getId(), r);
        }

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

        boardGroup = drawBoard();
        for (var character : playerCharacters.values()) {
            boardGroup.getChildren().add(character);
        }
        board.getNode().getChildren().add(boardGroup);

        Button button = new Button("Würfeln");
        button.setOnMouseClicked((e) -> {
            MoveResult move = controller.nextMove();
            diceView.animDiceRoll(boardGroup, move.roll.getResult());
        });

        Button drawCardTestButton = new Button("Karte ziehen");
        drawCardTestButton.setOnMouseClicked((e) ->
            controller.drawCard(CardType.Ereigniskarte)
        );

        /////////////////////////
        // right side
        ////////////////////////
        PlayerSidebar playerSidebar = new PlayerSidebar(sidebarWidth, sidebarHeight, controller.getPlayers());


        mainLayout.setRight(playerSidebar.getNode());

        /////////////////////////
        // bottom pane
        ////////////////////////
        VBox bottomPane = new VBox();
        bottomPane.setPrefHeight(bottomPaneHeight);
        bottomPane.getChildren().add(button);
        bottomPane.getChildren().add(drawCardTestButton);

        mainLayout.setBottom(bottomPane);
        this.scene = new Scene(mainLayout, width, height);
    }

    private Group drawBoard() {
        Group board = new Group();
        Rectangle r = new Rectangle(FIELD_WIDTH * 11, FIELD_WIDTH * 11);
        r.setFill(Color.DARKGRAY);
        r.setStrokeWidth(2.0);
        r.setStroke(Color.BLACK);

        var fields = controller.getMonopolyBoard().getAllFields();

        for (int i = 0; i < 4; ++i) {
            Group row = new Group();

            for (int x = 0; x < 10; ++x) {
                Group fieldGroup = new Group();
                Rectangle field = new Rectangle(FIELD_WIDTH, FIELD_HEIGHT);
                if (x == 0) {
                    field.setWidth(FIELD_HEIGHT);
                }
                setCharPosition(x % 10, fieldGroup);

                field.setFill(Color.WHITE);
                field.setStrokeWidth(1.0);
                field.setStroke(Color.BLACK);
                fieldGroup.getChildren().add(field);


                if (fields.get(i * 10 + x) instanceof Property) {
                    Property p = (Property) fields.get(i * 10 + x);
                    Rectangle header = new Rectangle(FIELD_WIDTH, FIELD_HEADER_HEIGHT);
                    header.setFill(Color.web(p.getGroup().getColor()));
                    header.setStrokeWidth(1.0);
                    header.setStroke(Color.BLACK);

                    fieldGroup.getChildren().add(header);
                }

                Text text = new Text();
                text.setFont(new Font(12));
                text.setWrappingWidth(FIELD_WIDTH - 6);
                text.setText(fields.get(i * 10 + x).getName());
                text.setTranslateX(6);
                text.setTranslateY(20 + FIELD_HEADER_HEIGHT);
                fieldGroup.getChildren().add(text);

                if (x == 0) {
                    text.setRotate(-45);
                    text.setWrappingWidth(FIELD_HEIGHT);
                    text.setTranslateX(12);
                    text.setTranslateY(30 + FIELD_HEADER_HEIGHT);
                }

                row.getChildren().add(fieldGroup);
            }

            row.setRotate(i * 90);
            if (i == 1) {
                row.setTranslateX(0.5 * -i * FIELD_WIDTH * 11 - FIELD_WIDTH);
                row.setTranslateY(0.5 * -i * FIELD_WIDTH * 11 + FIELD_WIDTH);
            } else if (i == 2) {
                row.setTranslateX(-FIELD_WIDTH * 2);
                row.setTranslateY(0.5 * -i * FIELD_WIDTH * 11);
            } else if (i == 3) {
                row.setTranslateX(0.25 * i * FIELD_WIDTH * 10 - 3 * FIELD_WIDTH);
                row.setTranslateY(0.25 * -i * FIELD_WIDTH * 10 + FIELD_WIDTH);
            }
            board.getChildren().add(row);
        }

        return board;
    }

    private void setCharPosition(int fieldIndex, Node r) {
        final int TOTAL = 10 * FIELD_WIDTH;

        if (fieldIndex <= 10) {
            setR(TOTAL - (fieldIndex * FIELD_WIDTH), TOTAL, r);
        } else if (fieldIndex <= 20) {
            setR(0, TOTAL - ((fieldIndex - 10) * FIELD_WIDTH), r);
        } else if (fieldIndex <= 30) {
            setR((fieldIndex - 20) * FIELD_WIDTH, 0, r);
        } else {
            setR(TOTAL, ((fieldIndex - 30) * FIELD_WIDTH), r);
        }
    }

    private void setR(double x, double y, Node r) {
        r.setTranslateX(x);
        r.setTranslateY(y);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public Scene getScene(){
        return this.scene;
    }
}