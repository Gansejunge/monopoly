package monopoly.gui;

import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import monopoly.field.Estate;
import monopoly.field.Field;

import static monopoly.gui.MainView.*;

public class FieldView {
    private monopoly.field.Field base;
    private int rowIndex;
    private Group fieldGroup;
    private Rectangle overlay;

    public FieldView(monopoly.field.Field field, int rowIndex){
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
            Rectangle header = new Rectangle(FIELD_WIDTH, FIELD_HEADER_HEIGHT);
            header.setFill(Color.web(estate.getGroup().getColor()));
            header.setStrokeWidth(1.0);
            header.setStroke(Color.BLACK);

            fieldGroup.getChildren().add(header);
        }

        Text text = new Text();
        text.setFont(new Font(12));
        text.setWrappingWidth(FIELD_WIDTH - 6);
        text.setText(base.getName());
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

        Rectangle overlayRect = new Rectangle(FIELD_WIDTH, FIELD_HEIGHT);
        if (rowIndex == 0) {
            overlayRect.setWidth(FIELD_HEIGHT);
        }

        overlayRect.setFill(Color.color(0.5, 0.5, 0.5, 0.4));

        fieldGroup.getChildren().add(overlayRect);

        overlayRect.hoverProperty().addListener((observable, oldValue, newHoverValue) -> {
            Estate es = (Estate) base;
            Color c;
            if(es.allOfGroupOwnedBySamePlayer()){
                c = newHoverValue ? Color.color(0.1, 0.6, 0.1, 0.4) : Color.color(0.5, 1.0, 0.5, 0.4);
            } else{
                c = newHoverValue ? Color.color(0.1, 0.1, 0.1, 0.4) : Color.color(0.5, 0.5, 0.5, 0.4);
            }

            overlayRect.setFill(c);
        });

        overlayRect.setOnMouseClicked(ev -> {
            Estate es = (Estate) base;
            if(es.allOfGroupOwnedBySamePlayer()){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Haus auf " + es.getName() + " für " + es.getHousePrice() + "€ bauen?");
                alert.setOnHidden(eve -> {
                    if(alert.getResult() == ButtonType.OK){
                        //controller.buy(controller.getCurrentPlayer(), field);
                    }
                });
                alert.show();
            }
        });

        this.overlay = overlayRect;
        this.overlay.setVisible(false);
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

            overlay.setFill(c);

            this.overlay.setVisible(true);
        }
    }

    public void hideOverlay(){
        if(overlay != null){
            this.overlay.setVisible(false);
        }
    }
}
