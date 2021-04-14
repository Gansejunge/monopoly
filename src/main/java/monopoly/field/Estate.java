package monopoly.field;

import monopoly.deck.Action;

public class Estate extends Property{
    private int houses;
    private int[] rent;
    private int housePrice;
  
    public Estate(String name, PropertyGroup group, int price, int[] rent, int housePrice, Action action){
        super(name, group, price, action);
        this.houses = 0;
        this.rent = rent;
        this.housePrice = housePrice;
    }
    public int getBuildings(){return this.houses;}
    public int getRent(){
        return rent[houses];
    }
}
