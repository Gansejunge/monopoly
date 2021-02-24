package monopoly;

import monopoly.deck.Card;
import monopoly.field.Property;
import java.util.ArrayList;

public class Player {
    private String name;
    private int money = 0;
    private int position = 0;
    private ArrayList<Property> properties = new ArrayList<>();
    private ArrayList<Card> Card= new ArrayList<>();
    private int amountOfHouses;
    private int amountOfHotels;

    public int getAmountOfHouses() {
        return this.amountOfHouses;
    }

    public int getAmountOfHotels() {
        return this.amountOfHotels;
    }

    public Player(String name){
        this.name = name;
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

    public ArrayList<monopoly.field.Property> getProperties() {
        return this.properties;
    }

    public ArrayList<monopoly.deck.Card> getCard() {
        return this.Card;
    }
}
