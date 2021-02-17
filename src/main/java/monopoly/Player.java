package monopoly;

import monopoly.deck.Card;
import monopoly.field.Estate;

public class Player {
    private String name;
    private int money = 0;
    private int position = 0;
    private Estate[] ownedEstate;
    private Card[] cards;
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
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Estate[] getOwnedEstate() {
        return ownedEstate;
    }

    public Card[] getCards() {
        return cards;
    }
}
