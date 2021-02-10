import dice.Dice;

import java.util.Scanner;

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

        int currentPlayer = 0;
        while(true){
            System.out.println("Würfeln? (j/n)");
            String result = inputScanner.next();
            if("n".equals(result.strip())){
                break;
            } else if("j".equals(result.strip())){
                System.out.println("Spieler " + playerNames[currentPlayer] + " hat " + Dice.roll2Dice().getTotal() + " gewürfelt.");
                currentPlayer = (currentPlayer + 1) % playerCount;
            }
        }
    }
}