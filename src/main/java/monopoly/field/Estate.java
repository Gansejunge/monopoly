package monopoly.field;

public class Estate extends Property{
    private int houses;
    private int[] rent;
    private int housePrice;
  
    public Estate(String name, PropertyGroup group, int price, int[] rent, int housePrice){
        super(name, group, price);
        this.houses = 0;
        this.rent = rent;
        this.housePrice = housePrice;
    }
    public int getBuildings(){return this.houses;}

    public int getRent(int dice){
        boolean ownsAllProperties = getGroup().getProperties().stream()
                .allMatch(p -> this.owner.equals(p.owner));
        if(ownsAllProperties && houses == 0){
            return rent[houses] * 2;
        }else{
            return rent[houses];
        }
    }

    public int getHousePrice() {
        return housePrice;
    }
}
