package monopoly.field;

import java.util.ArrayList;

public class Trainstation extends Property {

    public Trainstation(){
        super("Bahnhof");
    }

    @Override
    public double getRent() {
        ArrayList<Estate> Estate = owner.getEstate();
        int count = Estate.size();
        double price = count > 0 ? Math.pow(25,count-1) : 0;
        return price;
    }
}
