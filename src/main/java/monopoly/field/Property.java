package monopoly.field;

import monopoly.Player;
import monopoly.deck.PropertyAction;

public abstract class Property extends Field {
    protected int price;
    protected Player owner;
    protected PropertyGroup group;

    public Property(String name, PropertyGroup group, int price){
        super(name);
        this.group = group;
        this.price = price;
        this.fieldAction = new PropertyAction(this);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean hasOwner(){
        return this.owner != null;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PropertyGroup getGroup() {
        return group;
    }
}
