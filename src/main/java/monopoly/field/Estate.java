package monopoly.field;

public class Estate extends Property{
    private String color;
    private int houses;
    private float[] rent;

    public Estate(String name, String color, float[] rent){
        super(name);
        this.color = color;
        this.houses = 0;
        this.rent = rent;
    }
    @Override
    public float getRent(){
        return rent[houses];
    }


}
