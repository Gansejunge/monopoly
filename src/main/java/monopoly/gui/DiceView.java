package monopoly.gui;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import monopoly.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceView {
    private GameController controller;
    private List<Dice> dice = new ArrayList<>();
    private static final int COUNT = 2;

    public DiceView(GameController controller, Group parent){
        this.controller = controller;

        for(int i = 0; i < COUNT; ++i){
            Dice single_dice = new Dice();
            single_dice.setTranslate(300 + i * 70, 300);
            dice.add(single_dice);

            parent.getChildren().add(single_dice.getDiceGroup());
        }
    }

    public void animDiceRoll(){
        AnimationTimer timer = new AnimationTimer() {
            private long last = 0;
            private long anim_cycle = 0;
            private long total = 0;

            @Override
            public void handle(long now) {
                if(last == 0) {
                    last = now;
                }

                long delta = now - last;
                last = now;
                total += delta;
                anim_cycle += delta;

                if(anim_cycle >= 40000000L){
                    anim_cycle = 0;
                    dice.forEach(d -> d.setNumber(new Random().nextInt(6) + 1));
                    dice.forEach(d -> d.getDiceGroup().setRotate(now * 0.0000004));
                }

                if(total >= 400000000L){
                    stop();

                    var result = controller.nextMove();
                    var rolls = result.roll.getResult();
                    for(int i = 0; i < rolls.size(); ++i){
                        dice.get(i).setNumber(rolls.get(i));
                        dice.forEach(d -> d.getDiceGroup().setRotate(0));
                    }
                }
            }
        };

        timer.start();
    }
}
