package monopoly.game;

import monopoly.Player;
import monopoly.dice.DiceResult;
import monopoly.field.Field;

public class MoveResult {
    public Field field;
    public Player player;
    public DiceResult roll;

    public MoveResult(Field field, Player player, DiceResult roll){
        this.field = field;
        this.player = player;
        this.roll = roll;
    }
}
