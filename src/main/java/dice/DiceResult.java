package dice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

public class DiceResult {
    private List<Integer> result;

    public DiceResult(int count, IntSupplier randomNumberGenerator){
        this.result = new ArrayList<>();
        for(int i = 0; i < count; ++i){
            result.add(randomNumberGenerator.getAsInt());
        }
    }

    public boolean isPair(){
        return result.size() == 2 && result.get(0).equals(result.get(1));
    }

    public int getTotal(){
        return result.stream().mapToInt(i -> i).sum();
    }
}
