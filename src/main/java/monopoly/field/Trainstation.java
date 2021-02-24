package monopoly.field;

import java.util.ArrayList;

import math.pow;

public class Trainstation extends Property {

    @Override
    public double getRent() {
        ArrayList<Property> property = owner.getProperties();
        estate = estate.stream().filter(e -> e instanceof Trainstation);
        int count = estate.size();
        double price = count > 0 ? Math.pow(25,count-1) : 0;
        return price;
    }




}
