package monopoly.field;

import monopoly.deck.Action;


public abstract class Field {
    protected String name;
    protected Action fieldAction;

    public Field(){
        this.name = "test"; //todo
    }

    public Field(String name){
        this.name = name;
    }

    public Action getFieldAction() {
        return this.fieldAction;
    }

    public String getName(){
        return name;
    }
}
