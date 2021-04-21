package monopoly.gui;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import monopoly.deck.Card;
import monopoly.deck.CardType;

public class CardView {

    public Group getCard(Card cardToRender){
        Group cardGroup = new Group();
        Rectangle card = new Rectangle(200, 418);
        card.setFill(Color.WHITE);
        card.setStrokeWidth(2.0);
        card.setStroke(Color.DARKGRAY);
        card.setArcHeight(10.0);
        card.setArcWidth(10.0);
        cardGroup.getChildren().add(card);

        if(cardToRender.getCardType() == CardType.Ereigniskarte){
            Image i = new Image(CardView.class.getResourceAsStream("/monopoly/gui/questionmark.png"));
            ImageView img = new ImageView(i);
            int size_dif = 72;
            img.setX(size_dif);
            img.setY(30);
            img.setFitWidth(200 - size_dif * 2);
            img.setPreserveRatio(true);
            cardGroup.getChildren().add(img);
        }

        Text text = new Text();
        text.setFont(new Font(16));
        text.setWrappingWidth(200 - 20);
        text.setText(cardToRender.getText());
        text.setTranslateX(10);
        text.setTranslateY(140);
        cardGroup.getChildren().add(text);


        return cardGroup;
    }

    public void animCard(Group card){
        AnimationTimer timer = new AnimationTimer() {
            private long last = 0;
            private long total = 0;
            private boolean done;

            @Override
            public void handle(long now) {
                if(last == 0) {
                    last = now;
                }

                long delta = now - last;
                total += delta;

                if(!done){
                    card.setScaleX(Math.cos(total * 0.000000002));
                }

                if(total >= 21000000000L){
                    done = true;
                    card.setScaleX(1);
                }
            }
        };

        timer.start();
    }
}
