package monopoly.dice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DiceResultTest {

    @Test
    void isPair() {
        IntSupplier all_ones = () -> 1;

        DiceResult result = new DiceResult(2, all_ones);
        Assertions.assertTrue(result.isPair(), "Ein Wurf aus 2 Einsen sollte in Pasch sein");

        DiceResult result2 = new DiceResult(3, all_ones);
        assertFalse(result2.isPair(), "Ein Wurf aus 3 Einsen sollte kein Pasch sein");

        Queue<Integer> one_and_two = new LinkedList<>();
        one_and_two.add(1);
        one_and_two.add(2);
        DiceResult result3 = new DiceResult(2, one_and_two::poll);
        assertFalse(result3.isPair(), "Ein Wurf bestehend aus [1,2] sollte kein Pasch sein");
    }

    @Test
    void getTotal() {
        IntSupplier all_twos = () -> 2;
        DiceResult result = new DiceResult(2, all_twos);
        assertEquals(4, result.getTotal(), "Ein Wurf aus 2 Zweien sollte insgesamt 4 sein.");

        Queue<Integer> four_five = new LinkedList<>();
        four_five.add(4);
        four_five.add(5);
        DiceResult result2 = new DiceResult(2, four_five::poll);
        assertEquals(9, result2.getTotal(), "Ein Wurf aus [4, 5] sollte insgesamt 9 sein.");
    }
}