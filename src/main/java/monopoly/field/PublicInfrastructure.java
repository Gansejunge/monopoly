package monopoly.field;

public class PublicInfrastructure extends Property{

    public PublicInfrastructure(){
        super("Werke");
    }

    @Override
    public double getRent() {
        return 0;
    }
}
