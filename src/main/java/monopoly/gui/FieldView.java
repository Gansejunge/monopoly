package monopoly.gui;

import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import monopoly.GameController;
import monopoly.field.Estate;
import monopoly.field.Field;
import monopoly.field.Property;

import static monopoly.gui.MainView.*;

public class FieldView {
    private monopoly.field.Field base;
    private int rowIndex;
    private Group fieldGroup;
    private Group streetGroup;
    private Group overlay;
    private Rectangle overlayRect;
    private GameController controller;

    public FieldView(GameController controller, monopoly.field.Field field, int rowIndex){
        this.controller = controller;
        this.base = field;
        this.fieldGroup = new Group();
        this.rowIndex = rowIndex;
        init();
        initOverlay();
    }

    public Group getFieldGroup() {
        return fieldGroup;
    }

    public Field getBase() {
        return base;
    }

    private void init(){
        Rectangle field = new Rectangle(FIELD_WIDTH, FIELD_HEIGHT);
        if (rowIndex == 0) {
            field.setWidth(FIELD_HEIGHT);
        }

        field.setFill(Color.WHITE);
        field.setStrokeWidth(1.0);
        field.setStroke(Color.BLACK);
        fieldGroup.getChildren().add(field);

        if (base instanceof Estate) {
            Estate estate = (Estate) base;
            streetGroup = new Group();
            Rectangle header = new Rectangle(FIELD_WIDTH, FIELD_HEADER_HEIGHT);
            header.setFill(Color.web(estate.getGroup().getColor()));
            header.setStrokeWidth(1.0);
            header.setStroke(Color.BLACK);

            streetGroup.getChildren().add(header);
            fieldGroup.getChildren().add(streetGroup);
        }

        Text text = new Text();
        text.setFont(new Font(12));
        text.setWrappingWidth(FIELD_WIDTH - 6);
        if(base instanceof Property) {
            text.setText(base.getName() + "/n" + ((Property) base).getPrice());
        }else{
            text.setText(base.getName());
        }
        text.setTranslateX(6);
        text.setTranslateY(20 + FIELD_HEADER_HEIGHT);

        if (rowIndex == 0) {
            text.setRotate(-45);
            text.setWrappingWidth(FIELD_HEIGHT - 20);
            text.setTranslateX(12);
            text.setTranslateY(30 + FIELD_HEADER_HEIGHT);
        }

        fieldGroup.getChildren().add(text);
    }

    private void initOverlay(){
        if(! (base instanceof Estate)){
            return;
        }

        overlayRect = new Rectangle(FIELD_WIDTH, FIELD_HEIGHT);
        if (rowIndex == 0) {
            overlayRect.setWidth(FIELD_HEIGHT);
        }

        overlayRect.setFill(Color.color(0.5, 0.5, 0.5, 0.4));

        overlayRect.hoverProperty().addListener((observable, oldValue, newHoverValue) -> {
            Estate es = (Estate) base;
            Color c;
            if(es.canBuyHouse()){
                c = newHoverValue ? Color.color(0.1, 0.6, 0.1, 0.8) : Color.color(0.5, 1.0, 0.5, 0.5);
            } else{
                c = newHoverValue ? Color.color(0.1, 0.1, 0.1, 0.8) : Color.color(0.2, 0.2, 0.2, 0.5);
            }

            overlayRect.setFill(c);
        });

        overlayRect.setOnMouseClicked(ev -> {
            Estate es = (Estate) base;
            if(es.canBuyHouse()){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Haus auf " + es.getName() + " für " + es.getHousePrice() + "€ bauen?");
                alert.setOnHidden(eve -> {
                    if(alert.getResult() == ButtonType.OK){
                        Image im = new Image(FieldView.class.getResourceAsStream("/monopoly/gui/house.png"));
                        ImageView img = new ImageView(im);
                        img.setX(2 + es.getBuildings() * 16);
                        img.setY(6);
                        img.setFitWidth(14);
                        img.setPreserveRatio(true);
                        streetGroup.getChildren().add(img);

                        controller.addHouse(controller.getCurrentPlayer(), es);
                    }
                });
                alert.show();
            }
        });

        overlay = new Group();
        overlay.getChildren().add(overlayRect);

        Text text = new Text();
        text.setFont(new Font(20));
        text.setWrappingWidth(FIELD_WIDTH - 6);
        text.setText(String.valueOf(((Estate) base).getHousePrice()) + "€");
        text.setTranslateX(6);
        text.setTranslateY(60 + FIELD_HEADER_HEIGHT);
        text.setFill(Color.WHITE);

        overlay.getChildren().add(text);
        overlay.setVisible(false);
        fieldGroup.getChildren().add(overlay);
    }

    public void showOverlay(){
        if(overlay != null){
            Estate es = (Estate) base;
            Color c;
            if(es.allOfGroupOwnedBySamePlayer()){
                c =  Color.color(0.5, 1.0, 0.5, 0.4);
            } else{
                c = Color.color(0.5, 0.5, 0.5, 0.4);
            }

            overlayRect.setFill(c);
            overlay.setVisible(true);
        }
    }

    public void hideOverlay(){
        if(overlay != null){
            overlay.setVisible(false);
        }
    }
}
