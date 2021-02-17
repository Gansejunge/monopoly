package monopoly.field;

import java.util.ArrayList;
import math.pow;

public class Trainstation extends Property {

    @Override
    public double getRent() {
        ArrayList<Estate> Estate = owner.getEstate();
        int count = Estate.size();
        double price = count > 0 ? Math.pow(25,count-1) : 0;
        return price;
    }




}
