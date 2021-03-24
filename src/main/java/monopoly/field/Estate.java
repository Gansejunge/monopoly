package monopoly.field;

public class Estate extends Property{
    private String color;
    private int houses;
    private int[] rent;
  
    public Estate(String name, PropertyGroup group, int[] rent){
        super(name, group);
        this.color = color;
        this.houses = 0;
        this.rent = rent;
    }
    public int getBuildings(){return this.houses;}
    public int getRent(){
        return rent[houses];
    }
}
