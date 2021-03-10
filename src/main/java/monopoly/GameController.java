package monopoly;

import monopoly.deck.CardType;
import monopoly.deck.Decks;
import monopoly.dice.Dice;
import monopoly.dice.DiceResult;
import monopoly.field.Field;
import monopoly.field.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    public static final int MOVE_TO_PRISON_ROLL_COUNT = 3;

    private Board board;
    private List<Player> players;
    private int currentPlayer = 0;
    private Decks decks;
    private int currentRollCount = 0;
    private DiceResult currentDiceResult;

    public GameController(List<String> playerNames){
        this.board = new Board();
        this.players = playerNames.stream().map(Player::new).collect(Collectors.toList());
        this.decks = new Decks();
    }

    public Field nextMove(){
        Field result;

        currentDiceResult = Dice.roll2Dice();
        currentRollCount++;

        if(getCurrentPlayer().isInPrison()){
            getCurrentPlayer().addTurnInPrison();

            if(currentDiceResult.isPair()){
                getCurrentPlayer().setInPrison(false);
                result = board.movePlayer(getCurrentPlayer(), currentDiceResult.getTotal());
            } else{
                result = board.getFieldAtIndex(getCurrentPlayer().getPosition());
                if(getCurrentPlayer().getTurnsInPrison() == 3) {
                    //todo: pay your dirty moneys to become a free (wo-)man
                }
            }

            nextPlayer();
        } else{
            if(currentRollCount == MOVE_TO_PRISON_ROLL_COUNT && currentDiceResult.isPair()){
                getCurrentPlayer().setPosition(11); //todo nicht über index?
                getCurrentPlayer().setInPrison(true);
                result = board.getFieldAtIndex(getCurrentPlayer().getPosition());
            } else{
                result = board.movePlayer(getCurrentPlayer(), currentDiceResult.getTotal());
            }

            if(!currentDiceResult.isPair()){
                nextPlayer();
            }
        }

        return result;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Player getCurrentPlayer(){
        return players.get(this.currentPlayer);
    }

    public void nextPlayer(){
        currentRollCount = 0;
        currentDiceResult = null;
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


    public void drawCard(CardType cardType){
        this.decks.drawCard(cardType);
    }

    public void startAuction(Property property){
        List<Player> tempPlayers = new ArrayList<>(players);
        int tempCurrentPlayer = this.currentPlayer;
        double bid = 0.0;
        double tempBid;
        while(tempPlayers.size()>1){
            tempBid = tempPlayers.get(tempCurrentPlayer).insertBid(bid);
            if(tempBid == 0) {
                tempPlayers.remove(tempCurrentPlayer);
                continue;
            }
            bid = tempBid;
            tempCurrentPlayer = (tempCurrentPlayer + 1) % tempPlayers.size();
        }
        property.setOwner(tempPlayers.get(0));
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
