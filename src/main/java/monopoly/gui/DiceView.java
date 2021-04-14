package monopoly.gui;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import monopoly.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceView {

    private GameController controller;

    public DiceView(GameController controller){
        this.controller = controller;
    }

    public void animDiceRoll(Group parent, List<Integer> rolls){
        List<Node> dice = new ArrayList<>();

        for(int i = 0; i < rolls.size(); ++i){
            Node single_dice = drawDice(3);
            single_dice.setTranslateX(i * 70);
            parent.getChildren().add(single_dice);

            dice.add(single_dice);
        }

        AnimationTimer timer = new AnimationTimer() {
            private long last = 0;
            private long anim = 0;
            private long total = 0;
            private boolean done;
            private boolean done_anim;

            @Override
            public void handle(long now) {
                if(last == 0) {
                    last = now;
                }

                long delta = now - last;
                total += delta;
                anim += delta;

                if(!done_anim && anim >= 900000000L){
                    anim = 0;
                    parent.getChildren().removeAll(dice);
                    dice.clear();

                    for(int i = 0; i < rolls.size(); ++i){
                        Node single_dice = drawDice(new Random().nextInt(6) + 1);
                        single_dice.setTranslateX(i * 70);
                        parent.getChildren().add(single_dice);

                        dice.add(single_dice);
                    }

                    dice.forEach(d -> d.setRotate(now * 0.0000002));
                }

                if(done) {
                    parent.getChildren().removeAll(dice);
                    return;
                }

                if(!done_anim && total >= 4000000000L){
                    done_anim = true;

                    parent.getChildren().removeAll(dice);
                    dice.clear();

                    for(int i = 0; i < rolls.size(); ++i){
                        Node single_dice = drawDice(rolls.get(i));
                        single_dice.setTranslateX(i * 70);
                        parent.getChildren().add(single_dice);
                        dice.add(single_dice);
                    }
                }

                if(total >= 21000000000L){
                    done = true;
                }
            }
        };

        timer.start();
    }

    private Node drawDice(int num){
        Group dice = new Group();
        Rectangle cube = new Rectangle(50, 50);
        cube.setFill(Color.BEIGE);
        cube.setStrokeWidth(2.0);
        cube.setStroke(Color.DARKGRAY);
        cube.setArcHeight(10.0);
        cube.setArcWidth(10.0);
        dice.getChildren().add(cube);

        switch (num){
            case 5:
                Circle cube5 = new Circle(25 - 15, 25 + 15, 5, Color.BLACK);
                Circle cube6 = new Circle(25 + 15, 25 - 15, 5, Color.BLACK);
                dice.getChildren().addAll(cube5, cube6);
            case 3:
                Circle cube3 = new Circle(25 - 15, 25 - 15, 5, Color.BLACK);
                Circle cube4 = new Circle(25 + 15, 25 + 15, 5, Color.BLACK);
                dice.getChildren().addAll(cube3, cube4);
            case 1:
                Circle cube2 = new Circle(25, 25, 5, Color.BLACK);
                dice.getChildren().add(cube2);
                break;
            case 2:
                Circle cube7 = new Circle(25 - 10, 25 - 10, 5, Color.BLACK);
                Circle cube8 = new Circle(25 + 10, 25 + 10, 5, Color.BLACK);
                dice.getChildren().addAll(cube7, cube8);
                break;
            case 4:
                for(int i = 0; i < 4; ++i) {
                    Circle c = new Circle(15 + i % 2 * 20, 15 + (i >> 1) * 20, 5, Color.BLACK);
                    dice.getChildren().add(c);
                }
                break;
            case 6:
                for(int x = 0; x < 3; ++x) {
                    for(int y = 0; y < 2; ++y){
                        Circle c = new Circle(15 + y * 20, 11 + x * 14, 5, Color.BLACK);
                        dice.getChildren().add(c);
                    }
                }
        }

        return dice;
    }
}
