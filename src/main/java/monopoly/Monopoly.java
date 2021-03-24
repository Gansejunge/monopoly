package monopoly;

import java.util.Arrays;
import java.util.Scanner;

public class Monopoly {
    public static void main( String[] args ) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Spieleranzahl eingeben: ");
        int playerCount = inputScanner.nextInt();

        String[] playerNames = new String[playerCount];
        for(int i = 0; i < playerCount; ++i){
            System.out.println("Spielername für Spieler " + (i + 1) + " eingeben: ");
            playerNames[i] = inputScanner.next();
        }

        GameController controller = new GameController();
        controller.setPlayers(Arrays.asList(playerNames));
        while(true){
            System.out.println("Würfeln? (j/n)");
            String result = inputScanner.next();
            if("n".equals(result.strip())){
                break;
            } else if("j".equals(result.strip())){
                Player currentPlayer = controller.getCurrentPlayer();
                // todo wegwerfen
//                //Field resultField = controller.nextMove();
//
//                System.out.println("Du bist auf dem Feld " + resultField.getName() + " gelandet");
//
//                if(currentPlayer.equals(controller.getCurrentPlayer())){
//                    System.out.println("Du darfst nochmal.");
//                }
            }
        }
    }
}