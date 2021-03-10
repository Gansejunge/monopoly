package monopoly;

import monopoly.deck.CardType;
import monopoly.deck.Decks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private Board board;
    private List<Player> players;
    private int currentPlayer = 0;
    private Decks decks;

    public GameController(List<String> playerNames){
        this.board = new Board();
        this.players = playerNames.stream().map(Player::new).collect(Collectors.toList());
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Player getCurrentPlayer(){
        return players.get(this.currentPlayer);
    }

    public void nextPlayer(){
        currentPlayer = (currentPlayer + 1) % players.size();
    }

    public List<Player> getOtherPlayers(){
        List<Player> otherPlayer = new ArrayList<>(players);
        otherPlayer.remove(currentPlayer);
        return otherPlayer;
    }

    public Player getNextPlayer() {
        this.currentPlayer++;
        this.currentPlayer %= this.players.size();
        return this.players.get(this.currentPlayer);
    }

    public void initPlayer(int amount){
        String name = "";
        for(int i = 0; i<amount; i++){
           players.add(new Player(name));
        }
    }

    public void drawCard(CardType cardType){
        this.decks.drawCard(cardType);
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
        return board;
    }

}
