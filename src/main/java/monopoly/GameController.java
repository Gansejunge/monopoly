package monopoly;

import java.util.ArrayList;

public class GameController {
    private ArrayList<Player> player = new ArrayList<>();
    private int currentPlayer = 0;

    public ArrayList<Player> getPlayer(){
        return player;
    }

    public Player getCurrentPlayer(){
        return player.get(this.currentPlayer);
    }

    public ArrayList<Player> getOtherPlayers(){
        ArrayList<Player> otherPlayer = new ArrayList<>(player);
        otherPlayer.remove(currentPlayer);
        return otherPlayer;
    }

    public Player getNextPlayer() {
        this.currentPlayer++;
        this.currentPlayer %= this.player.size();
        return this.player.get(this.currentPlayer);
    }

    public void initPlayer(int amount){
        String name = "";
        for(int i = 0; i<amount; i++){
           player.add(new Player(name));
        }
    }

    public void transferMoneyToOrFromBank(int amountOfMoney){
    }

    public void transferMoneyToOrFromPlayer(Player otherPlayer,int moneyToGiveOrTake){
    }

    public void movePlayer(int amountOfMoves){
    }

    public void moveToField(int location,boolean getMoneyFromStart){
    }
    public int getLocation(){
        //todo
        return 0;
    }
    public Board getMonopolyBoard(){
        //todo
        return null;
    }

}
