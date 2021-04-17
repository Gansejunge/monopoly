package monopoly;

import monopoly.deck.Card;
import monopoly.deck.CardType;
import monopoly.deck.Decks;
import monopoly.dice.Dice;
import monopoly.dice.DiceResult;
import monopoly.field.Field;
import monopoly.field.Property;
import monopoly.game.MoveResult;
import monopoly.gui.GUIListener;

import java.util.*;
import java.util.stream.Collectors;

public class GameController {
    public static final int MOVE_TO_PRISON_ROLL_COUNT = 3;

    private static final int GO_MONEY = 4000;

    private Board board;
    private List<Player> players;
    private int currentPlayer = 0;
    private Decks decks;
    private int currentRollCount = 0;

    private List<GUIListener> eventListener = new ArrayList<>();

    public GameController(List<String> playerNames){
        this.board = new Board();
        this.players = playerNames.stream().map(Player::new).collect(Collectors.toList());
        this.decks = new Decks();
    }

    public void addEventListener(GUIListener listener){
        this.eventListener.add(listener);
    }

    public void removeEventListener(GUIListener listener){
        this.eventListener.remove(listener);
    }

    public MoveResult nextMove(){
        Field resultField;
        Player currentPlayer = getCurrentPlayer();

        DiceResult currentDiceResult = Dice.roll2Dice();
        currentRollCount++;

        if(getCurrentPlayer().isInPrison()){
            getCurrentPlayer().addTurnInPrison();

            if(currentDiceResult.isPair()){
                getCurrentPlayer().setInPrison(false);

                BoardMoveResult move = board.movePlayer(getCurrentPlayer(), currentDiceResult.getTotal());
                resultField = move.result;

                if(move.passedGo){
                    passedGo();
                }
            } else{
                resultField = board.getFieldAtIndex(getCurrentPlayer().getPosition());
                if(getCurrentPlayer().getTurnsInPrison() == 3) {
                   //todo resultField.getFieldAction().perfom(this);
                }
            }

            nextPlayer();
        } else{
            if(currentRollCount == MOVE_TO_PRISON_ROLL_COUNT && currentDiceResult.isPair()){
                getCurrentPlayer().setPosition(11); //todo nicht über index?
                getCurrentPlayer().setInPrison(true);

                resultField = board.getFieldAtIndex(getCurrentPlayer().getPosition());
            } else{
                BoardMoveResult move = board.movePlayer(getCurrentPlayer(), currentDiceResult.getTotal());
                resultField = move.result;

                if(move.passedGo){
                    passedGo();
                }

                resultField.getFieldAction().perfom(this);
            }

            if(!currentDiceResult.isPair()){
                nextPlayer();
            }
        }

        MoveResult move = new MoveResult(resultField, currentPlayer, currentDiceResult);
        eventListener.forEach(listener -> listener.onMove(move));
        return move;
    }

    private void passedGo(){
        getCurrentPlayer().addMoney(GO_MONEY);
    }

    public void requestBuy(Property property){
        if(property.getPrice() <= getCurrentPlayer().getMoney()) {
            eventListener.forEach(l -> l.onRequestPropertyPurchase(property));
        }
    }

    public void payRent(Property property){
        //todo dice
        property.getOwner().addMoneyFromOtherPlayer(getCurrentPlayer(), property.getRent(1));
        eventListener.forEach(GUIListener::updatePlayerMoney);
    }

    public void buy(Player player, Property property){
        property.setOwner(player);
        player.addMoney(-property.getPrice());
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Player getCurrentPlayer(){
        return players.get(this.currentPlayer);
    }

    public void nextPlayer(){
        currentRollCount = 0;
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
        Card card =  this.decks.drawCard(cardType);
        eventListener.forEach(l -> l.onDrawCard(card));
        card.getAction().perfom(this);
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

    public void setPlayersOrder() {
        HashMap<Player, Integer> hm = new HashMap<>();
        ArrayList<Player> tempPlayers = new ArrayList<>();
        for (Player p : players) {
            DiceResult result = Dice.roll2Dice();
            hm.put(p, result.getTotal());
        }
        hm.entrySet()
                .stream()
                .sorted(Map.Entry.<Player, Integer>comparingByValue().reversed()).forEach(e -> tempPlayers.add(e.getKey()));
        this.players = tempPlayers;
    }

    public Board getMonopolyBoard(){
        return board;
    }


}
