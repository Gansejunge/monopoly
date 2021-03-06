package monopoly.field;

public class Estate extends Property{
    private String color;
    private int houses;
    private int[] rent;
  
    public Estate(String name, String color, int[] rent){
        super(name);
        this.color = color;
        this.houses = 0;
        this.rent = rent;
    }

    public int getRent(){
        return rent[houses];
    }
}
