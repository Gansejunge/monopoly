package monopoly.field;

public class Estate extends Property{
    private String color;
    private int houses;
    private float[] rent;

    public void Estate(String name, String color, float[] rent){
        this.name = name;
        this.color = color;
        this.houses = 0;
        this.rent = rent;
    }
    @Override
    public float getRent(){
        return rent[houses];
    }


}
