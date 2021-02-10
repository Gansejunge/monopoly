package monopoly.field;

public abstract class Field {
    protected String name;
    protected monopoly.deck.Action fieldAction;
    public monopoly.deck.Action getFieldAction() {
        return this.fieldAction;
    }


}
