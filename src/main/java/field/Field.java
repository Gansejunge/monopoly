package field;

public abstract class Field {
    protected String name;
    protected Deck.Action fieldAction;
    public Deck.Action getFieldAction() {
        return this.fieldAction;
    }


}
