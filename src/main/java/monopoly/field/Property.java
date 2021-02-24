package monopoly.field;

import monopoly.Player;

public abstract class Property extends Field {
    protected int price;
    protected Player owner;

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract int getRent();
}
