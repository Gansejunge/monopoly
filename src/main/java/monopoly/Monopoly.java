package monopoly;

import monopoly.dice.Dice;
import monopoly.dice.DiceResult;
import monopoly.field.Field;

import java.util.Arrays;
import java.util.Scanner;

public class Monopoly {
    public static void main( String[] args ) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Spieleranzahl eingeben: ");
        int playerCount = inputScanner.nextInt();

        String[] playerNames = new String[playerCount];
        for(int i = 0; i < playerCount; ++i){
            System.out.println("Spielername für Spieler " + i + 1 + " eingeben: ");
            playerNames[i] = inputScanner.next();
        }

        GameController controller = new GameController(Arrays.asList(playerNames));

        while(true){
            System.out.println("Würfeln? (j/n)");
            String result = inputScanner.next();
            if("n".equals(result.strip())){
                break;
            } else if("j".equals(result.strip())){
                DiceResult diceResult = Dice.roll2Dice();
                System.out.println("Spieler " + controller.getCurrentPlayer().getName() + " hat " + diceResult.getTotal() + " gewürfelt.");
                Field resultField = controller.getMonopolyBoard().movePlayer(controller.getCurrentPlayer(), diceResult.getTotal());

                System.out.println("Du bist auf dem Feld " + resultField.getName() + " gelandet");

                if(diceResult.isPair()){
                    System.out.println("Pasch. Du darfst nochmal.");
                }else{
                    controller.nextPlayer();
                }
            }
        }
    }
}