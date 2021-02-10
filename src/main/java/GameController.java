import java.util.ArrayList;

public class GameController {
    private Player[] player;
    private int currentPlayer = 0;

    public void initPlayer(int amount){
        this.player = new Player[amount];
        for(Player p : this.player){
            p = new Player();
        }
    }

    public Player nextPlayer() {
        this.currentPlayer++;
        this.currentPlayer %= this.player.length;
        return this.player[this.currentPlayer];
    }
}
