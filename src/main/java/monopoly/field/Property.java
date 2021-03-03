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

    public boolean hasOwner(){
        if(this.owner == null){
            return false;
        }
        return true;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }
}
