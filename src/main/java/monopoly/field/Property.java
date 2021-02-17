package monopoly.field;

import monopoly.Player;

public abstract class Property extends Field {
    protected float price;
    protected Player owner;
    public abstract float getRent();
}
