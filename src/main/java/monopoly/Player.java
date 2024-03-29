package monopoly;

import monopoly.deck.Card;
import monopoly.field.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    public static final int START_MONEY = 10000;

    private String name;

    private static int counter = 0;

    private int money = START_MONEY;
    private int id;
    private int position = 0;
    private boolean isInPrison;
    private int turnsInPrison;
    private ArrayList<Property> properties = new ArrayList<>();
    private ArrayList<Card> Card= new ArrayList<>();
    private String color;

    public Player(String name, String color){
        this.name = name;
        this.color = color;
        this.id = counter;
        ++counter;
    }

    public String getColor() {
        return color;
    }

    public void addTurnInPrison(){
        turnsInPrison++;
    }

    public int getTurnsInPrison(){
        return turnsInPrison;
    }

    public void setInPrison(boolean isInPrison){
        this.isInPrison = isInPrison;
        if(! this.isInPrison){
            turnsInPrison = 0;
        }
    }

    public boolean isInPrison(){
        return isInPrison;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getMoney() {
        return this.money;
    }

    public List<Property> getProperties() {
        return this.properties;
    }

    public ArrayList<monopoly.deck.Card> getCard() {
        return this.Card;
    }

    public void addMoney(int amountOfMoney){
        this.money += amountOfMoney;
    }

    public void addMoneyFromOtherPlayer(Player otherPlayer,int moneyToGiveOrTake){
        this.money += moneyToGiveOrTake;
        otherPlayer.addMoney(-moneyToGiveOrTake);
    }

    public void movePlayer(int amountOfMoves){
        this.position += amountOfMoves;
    }

    public void moveToField(int location,boolean getMoneyFromStart){
        this.setPosition(location);
        if(getMoneyFromStart) this.addMoney(1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return money == player.money && position == player.position && isInPrison == player.isInPrison && turnsInPrison == player.turnsInPrison && name.equals(player.name) && properties.equals(player.properties) && Card.equals(player.Card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, position, isInPrison, turnsInPrison, properties, Card);
    }

    public int getId() {
        return id;
    }
}
