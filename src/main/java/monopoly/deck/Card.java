package monopoly.deck;

public class Card {
    private String text;
    private Action action;
    private CardType cardType;
    public Card(String text, Action action, CardType cardType){
        this.text=text;
        this.action=action;
        this.cardType=cardType;
    }
    public Action getAction(){
        return this.action;
    }
}
