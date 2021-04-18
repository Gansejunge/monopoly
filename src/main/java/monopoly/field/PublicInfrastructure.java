package monopoly.field;

public class PublicInfrastructure extends Property{
    public PublicInfrastructure(String name, PropertyGroup group, int price){
        super(name, group, price);
    }

    public int getRent(int diceValue) {
        return allOfGroupOwnedBySamePlayer() ? diceValue * 10 : diceValue * 4;
    }
}
