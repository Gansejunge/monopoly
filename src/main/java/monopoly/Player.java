package monopoly;

import monopoly.deck.Card;
import monopoly.field.Estate;

public class Player {
    public String name;
    private int money = 0;
    private int position = 0;
    private Estate[] ownedEstate;
    private Card[] cards;

    public Player(String name){
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
