package monopoly.field;

public class Estate extends Property{
    private String color;
    private int houses;
    private int[] rent;
  
    public void Estate(String name, String color, int[] rent){
        this.name = name;

        this.color = color;
        this.houses = 0;
        this.rent = rent;
    }
    @Override
    public int getRent(){
        return rent[houses];
    }


}
