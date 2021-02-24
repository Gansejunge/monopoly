package monopoly.field;

import monopoly.deck.Action;


public abstract class Field {
    protected String name;
    protected Action fieldAction;
    public monopoly.deck.Action getFieldAction() {
        return this.fieldAction;
    }


}
