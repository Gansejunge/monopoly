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

    public void animDiceRoll(List<Integer> rolls){
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
                    dice.forEach(d -> d.setNumber(new Random().nextInt(6) + 1));
                    dice.forEach(d -> d.getDiceGroup().setRotate(now * 0.0000002));
                }

                if(done) {
                    return;
                }

                if(!done_anim && total >= 4000000000L){
                    done_anim = true;
                    for(int i = 0; i < rolls.size(); ++i){
                        dice.get(i).setNumber(rolls.get(i));
                        dice.forEach(d -> d.getDiceGroup().setRotate(0));
                    }
                }

                if(total >= 21000000000L){
                    done = true;
                }
            }
        };

        timer.start();
    }
}
