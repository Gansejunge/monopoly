package monopoly.field;
import java.util.List;
import java.util.stream.Collectors;

public class PublicInfrastructure extends Property{

    public PublicInfrastructure(){
        super("Werke");
    }

    public int getRent(int diceValue) {
        List<Property> properties = owner.getProperties();
        properties = properties.stream().filter(p -> p instanceof PublicInfrastructure).collect(Collectors.toList());
        int count = properties.size();
        int rent = count == 1 ? diceValue * 4 : diceValue * 10;
        return rent;

    }
}
