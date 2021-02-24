package monopoly.field;

public abstract class Field {
    protected String name;
    protected monopoly.deck.Action fieldAction;

    public Field(){
        this.name = "test"; //todo
    }

    public Field(String name){
        this.name = name;
    }

    public monopoly.deck.Action getFieldAction() {
        return this.fieldAction;
    }

    public String getName(){
        return name;
    }
}
