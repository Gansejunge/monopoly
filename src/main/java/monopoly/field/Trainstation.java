package monopoly.field;

import monopoly.deck.Action;

public class Trainstation extends Property {
    public Trainstation(String name, PropertyGroup group, int price, Action action){
        super(name, group, price, action);
    }

    public int getRent() {
        long count = owner.getProperties().stream().filter(p -> p.group == this.group).count();
        return (int) (25 * Math.pow(2, count - 1));
    }
}

