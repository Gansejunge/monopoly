package monopoly;

import monopoly.dice.Dice;
import monopoly.dice.DiceResult;
import monopoly.field.Property;

import java.util.*;
import java.util.stream.Collectors;

public class GameController {
    private Board board;
    private List<Player> players;
    private int currentPlayer = 0;

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
        this.nextPlayer();
        return this.players.get(this.currentPlayer);
    }

    public void initPlayer(int amount){
        String name = "";
        for(int i = 0; i<amount; i++){
           players.add(new Player(name));
        }
    }

    public void startAuction(Property property){
        List<Player> tempPlayers = new ArrayList<>(players);
        int tempCurrentPlayer = this.currentPlayer;
        double bid = 0.0;
        double tempBid;
        while(tempPlayers.size()>1){
            tempBid = this.insertBid(tempPlayers.get(tempCurrentPlayer), bid);
            if(tempBid == 0) {
                tempPlayers.remove(tempCurrentPlayer);
                continue;
            }
            bid = tempBid;
            tempCurrentPlayer = (tempCurrentPlayer + 1) % tempPlayers.size();
        }
        property.setOwner(tempPlayers.get(0));
    }
    public double insertBid(Player player, double bid){
        Scanner inputScanner = new Scanner(System.in);
        double tempBid;
        do{
            System.out.printf("%s, bitte geben Sie ein Gebot ein. Es muss größer als sein als %f", player.getName(), bid);
            tempBid = inputScanner.nextDouble();
        }
        while(tempBid < bid || tempBid == 0);
        return tempBid;
    }

    public void setPlayersOrder(){
        HashMap<Player, Integer> hm = new HashMap<>();
        for(Player p : players){
            DiceResult result = Dice.roll2Dice();
            hm.put(p, result.getTotal());
        }
        hm.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue());
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
