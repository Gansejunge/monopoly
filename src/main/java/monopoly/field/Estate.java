package monopoly.field;

public class Estate extends Property{
    private String color;
    private int houses;
    private double[] rent;

    public void Estate(String name, String color, double[] rent){
        this.name = name;
        this.color = color;
        this.houses = 0;
        this.rent = rent;
    }
    @Override
    public double getRent(){
        return rent[houses];
    }


}
