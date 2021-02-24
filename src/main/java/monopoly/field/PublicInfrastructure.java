package monopoly.field;

public class PublicInfrastructure extends Property{

    public PublicInfrastructure(){
        super("Werke");
    }

    @Override
    public float getRent() {
        return 0;
    }
}
