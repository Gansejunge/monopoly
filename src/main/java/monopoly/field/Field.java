package monopoly.field;

import monopoly.deck.Action;


public abstract class Field{
    protected String name;
    protected Action fieldAction;

    public Field(String name, Action fieldAction){
        this.name = name;
        this.fieldAction = fieldAction;
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
