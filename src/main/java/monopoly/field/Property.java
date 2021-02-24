package monopoly.field;

import monopoly.Player;

public abstract class Property extends Field {
    protected double price;
    protected Player owner;
    public abstract double getRent();

    public Property(String name){
        super(name);
    }
}
