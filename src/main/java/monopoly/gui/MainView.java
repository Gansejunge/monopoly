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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import monopoly.GameController;
import monopoly.Player;
import monopoly.deck.Card;
import monopoly.field.Estate;
import monopoly.field.Property;
import monopoly.game.MoveResult;

import java.net.URL;
import java.util.*;

public class MainView implements Initializable {
    private GameController controller;
    private Scene scene;
    public static final int FIELD_WIDTH = 66;
    public static final int FIELD_HEIGHT = FIELD_WIDTH * 2;
    public static final int FIELD_HEADER_HEIGHT = 28;

    private final Map<Integer, Shape> playerCharacters = new HashMap<>();
    private DiceView diceView;
    private Group boardGroup;

    private VBox playerSidebar;
    private List<PlayerCard> playerCards;
    int sidebarHeight;
    int sidebarWidth;

    private List<FieldView> fields = new ArrayList<>();

    private GUIListener listener = new GUIListener() {
        @Override
        public void onMove(MoveResult move) {
            setCharPosition(move.player.getPosition(), playerCharacters.get(move.player.getId()));

            for(Player player : controller.getPlayers()){
                if(player.getPosition() == move.player.getPosition() && !player.equals(move.player)){
                    Node n = playerCharacters.get(move.player.getId());
                    n.setTranslateX((n.getTranslateX() + 10));
                    n.setTranslateY((n.getTranslateY() + 10));
                }
            }
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
            alert.setOnHidden(e -> {
                if(alert.getResult() == ButtonType.OK){
                    controller.buy(controller.getCurrentPlayer(), field);
                }
            });
            alert.show();
        }

        @Override
        public void updatePlayerMoney() {
            playerSidebar.getChildren().clear();
            for(Player player: controller.getPlayers()){
                PlayerCard playerCard = new PlayerCard(sidebarHeight / 4, sidebarWidth, player.getName(), player.getMoney());
                playerSidebar.getChildren().add(playerCard.getNode());
                //this.playerCards.add(playerCard);
            }

        }
    };

    public MainView(GameController controller) {
        this.controller = controller;
        this.controller.addEventListener(listener);

        Random rnd = new Random();

        int i = 0;
        for (Player player : controller.getPlayers()) {
            Circle r = new Circle(12);
            r.setFill(new Color(rnd.nextDouble(), rnd.nextDouble(), rnd.nextDouble(), 1.0));
            r.setStrokeWidth(1.0);
            r.setStroke(Color.BLACK);
            setCharPosition(0, r);

            r.setTranslateX(r.getTranslateX() + i * 10);
            r.setTranslateY(r.getTranslateY() + i * 10);

            playerCharacters.put(player.getId(), r);

            ++i;
        }

        int width = 1200;
        int height = 900;

        int bottomPaneHeight = 100;
        int boardHeight = height - bottomPaneHeight;
        int boardWidth = 800;
        this.sidebarHeight = height - bottomPaneHeight;
        this.sidebarWidth = 400;
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

        this.diceView = new DiceView(controller, boardGroup);

        Button button = new Button("Würfeln");
        button.setOnMouseClicked(e -> diceView.animDiceRoll());

        Button buyHouseButton = new Button("Häuser bauen");

        buyHouseButton.setCancelButton(false);
        buyHouseButton.setOnMouseClicked((e) -> {
            if(buyHouseButton.isCancelButton()){
                buyHouseButton.setCancelButton(false);
                buyHouseButton.setText("Häuser bauen");
                fields.forEach(FieldView::hideOverlay);
            }else{
                buyHouseButton.setText("Bauen beenden");
                buyHouseButton.setCancelButton(true);

                for(FieldView f : fields){
                    if(f.getBase() instanceof Estate){
                        Estate estate = (Estate) f.getBase();
                        if (estate.hasOwner() && estate.getOwner().equals(controller.getCurrentPlayer())){
                            f.showOverlay();
                        }
                    }
                }
            }
        });

        /////////////////////////
        // right side
        ////////////////////////
        this.playerSidebar = new VBox();
        this.playerSidebar.setPrefHeight(sidebarHeight);
        this.playerSidebar.setPrefWidth(sidebarWidth);

        for(Player player: controller.getPlayers()){
            PlayerCard playerCard = new PlayerCard(this.sidebarHeight / 4, this.sidebarWidth, player.getName(), player.getMoney());
            this.playerSidebar.getChildren().add(playerCard.getNode());

        }

        mainLayout.setRight(this.playerSidebar);

        /////////////////////////
        // bottom pane
        ////////////////////////
        VBox bottomPane = new VBox();
        bottomPane.setPrefHeight(bottomPaneHeight);
        bottomPane.getChildren().add(button);
        bottomPane.getChildren().add(buyHouseButton);

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

            for (int rowIndex = 0; rowIndex < 10; ++rowIndex) {
                FieldView field = new FieldView(controller, fields.get(i * 10 + rowIndex), rowIndex);
                setCharPosition2(rowIndex, field.getFieldGroup());
                row.getChildren().add(field.getFieldGroup());

                this.fields.add(field);
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
            setR(TOTAL - (fieldIndex * FIELD_WIDTH) + FIELD_WIDTH * 0.5,
                    TOTAL + FIELD_HEADER_HEIGHT * 2, r);
        } else if (fieldIndex <= 20) {
            setR(0, FIELD_WIDTH * 0.5 + TOTAL - ((fieldIndex - 10) * FIELD_WIDTH), r);
        } else if (fieldIndex <= 30) {
            setR(FIELD_WIDTH * 0.5 +(fieldIndex - 20) * FIELD_WIDTH,
                    - FIELD_HEADER_HEIGHT, r);
        } else {
            setR(TOTAL + FIELD_HEADER_HEIGHT * 2, ((fieldIndex - 30) * FIELD_WIDTH) + FIELD_WIDTH * 0.5, r);
        }
    }

    private void setCharPosition2(int fieldIndex, Node r) {
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