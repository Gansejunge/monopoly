package dice;

import java.security.SecureRandom;
import java.util.function.IntSupplier;

public class RandomNumberGenerator implements IntSupplier {
    private SecureRandom random;
    private int minValue;
    private int maxValue;

    public RandomNumberGenerator(int minValue, int maxValue){
        this.random = new SecureRandom();
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public int getAsInt() {
        return minValue + random.nextInt(1 + maxValue - minValue);
    }
}
