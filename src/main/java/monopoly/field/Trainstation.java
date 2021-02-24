package monopoly.field;

import java.util.List;
import java.util.stream.Collectors;

public class Trainstation extends Property {

    @Override
    public double getRent() {
        List<Property> properties = owner.getProperties();
        properties = properties.stream().filter(p -> p instanceof Trainstation).collect(Collectors.toList());
        int count = properties.size();
        double price = count > 0 ? Math.pow(25,count-1) : 0;
        return price;
    }




}
