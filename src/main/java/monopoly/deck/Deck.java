package monopoly.deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> drawDeck = new ArrayList<>();
    private ArrayList<Card> graveyard = new ArrayList<>();

    public Deck() {
    }

    public void add(Card card){
        drawDeck.add(card);
    }

    public void reshuffle(){
        drawDeck.addAll(graveyard);
        Collections.shuffle(drawDeck);
        graveyard.clear();
    }

    public void addCardToGraveyard(Card card) {
        graveyard.add(card);
    }

    public Card drawCard() {
        if (this.drawDeck.isEmpty())
            this.reshuffle();

        return drawDeck.remove(0);
    }
}
