package monopoly.field;

import monopoly.deck.Action;

import java.util.List;

public class PublicInfrastructure extends Property{
    public PublicInfrastructure(String name, PropertyGroup group, int price, Action action){
        super(name, group, price, action);
    }

    public int getRent(int diceValue) {
        List<Property> properties = owner.getProperties();
        long count = properties.stream().filter(p -> p instanceof PublicInfrastructure).count();
        return count == 1 ? diceValue * 4 : diceValue * 10;
    }
}
