package monopoly.field;

public class Estate extends Property{
    private String color;
    private int houses;
    private int[] rent;
    private int housePrice;
  
    public Estate(String name, PropertyGroup group, int price, int[] rent, int housePrice){
        super(name, group, price);
        this.color = color;
        this.houses = 0;
        this.rent = rent;
        this.housePrice = housePrice;
    }
    public int getBuildings(){return this.houses;}
    public int getRent(){
        return rent[houses];
    }
}
