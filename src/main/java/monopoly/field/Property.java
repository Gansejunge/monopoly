package monopoly.field;

import monopoly.Player;

public abstract class Property extends Field {
    protected int price;
    protected Player owner;
    protected PropertyGroup group;

    public Property(String name){
        super(name);

        group = new PropertyGroup(); //todo
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
