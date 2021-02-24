package monopoly;

import monopoly.dice.Dice;
import monopoly.dice.DiceResult;
import monopoly.field.Field;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Monopoly {
    public static void main( String[] args ) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Spieleranzahl eingeben: ");
        int playerCount = inputScanner.nextInt();

        String[] playerNames = new String[playerCount];
        for(int i = 0; i < playerCount; ++i){
            System.out.println("Spielername für Spieler " + i + " eingeben: ");
            playerNames[i] = inputScanner.next();
        }

        List<Player> players = Arrays.stream(playerNames).map(Player::new).collect(Collectors.toList());
        Board board = new Board();

        int currentPlayer = 0;
        while(true){
            System.out.println("Würfeln? (j/n)");
            String result = inputScanner.next();
            if("n".equals(result.strip())){
                break;
            } else if("j".equals(result.strip())){
                DiceResult diceResult = Dice.roll2Dice();
                System.out.println("Spieler " + players.get(currentPlayer).getName() + " hat " + diceResult.getTotal() + " gewürfelt.");
                Field resultField = board.movePlayer(players.get(currentPlayer), diceResult.getTotal());

                System.out.println("Du bist auf dem Feld " + resultField.getName() + " gelandet");

                if(diceResult.isPair()){
                    System.out.println("Pasch. Du darfst nochmal.");
                }else{
                    currentPlayer = (currentPlayer + 1) % playerCount;
                }

            }
        }
    }
}