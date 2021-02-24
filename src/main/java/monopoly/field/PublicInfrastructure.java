package monopoly.field;

import java.util.List;
import java.util.stream.Collectors;

public class PublicInfrastructure extends Property{

    public PublicInfrastructure(){

    }


    @Override
    public int getRent() {
        List<Property> properties = owner.getProperties();
        properties = properties.stream().filter(p -> p instanceof PublicInfrastructure).collect(Collectors.toList());
        int count = properties.size();
        return 0;
    }
}
