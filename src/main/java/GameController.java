import java.util.ArrayList;

public class GameController {
    private Player[] player;
    private int currentPlayer = 0;

    public void initPlayer(int amount){
        this.player = new Player[amount];
        String name = "";
        for(int i = 0; i<amount; i++){
           this.player[i] = new Player(name);
        }
    }

    public Player nextPlayer() {
        this.currentPlayer++;
        this.currentPlayer %= this.player.length;
        return this.player[this.currentPlayer];
    }
}
