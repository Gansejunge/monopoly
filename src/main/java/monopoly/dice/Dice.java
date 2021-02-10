package monopoly.dice;

public class Dice {
    private static RandomNumberGenerator rng = new RandomNumberGenerator(1, 6);

    public static DiceResult roll2Dice(){
        return new DiceResult(2, rng);
    }
}
