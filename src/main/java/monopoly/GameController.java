package monopoly;

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
    public void giveMoney(int amountOfMoney){
    }

    public void movePlayer(int amountOfMoves){
    }

    public void moveToField(int location,boolean getMoneyFromStart){
    }
}
