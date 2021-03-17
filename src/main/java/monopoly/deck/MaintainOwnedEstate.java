package monopoly.deck;

import monopoly.GameController;
import monopoly.field.Estate;
import monopoly.field.Property;
import java.util.List;


public class MaintainOwnedEstate implements Action {
    private int houseMultiplier;
    private int hotelMultiplier;
    public static final int AMOUNT_OF_HOUSES_THAT_REPRESENT_A_HOTEL=5;

    public MaintainOwnedEstate(int houseMultiplier, int hotelMultiplier) {
        this.houseMultiplier = houseMultiplier;
        this.hotelMultiplier = hotelMultiplier;
    }

    @Override
    public void perfom(GameController controller) {
        int amountOfPlayerOwnedHouses=0;
        int amountOfPlayerOwnedHotels=0;
        List<Property> playerProperties = controller.getCurrentPlayer().getProperties();
        for (Property playerProperty : playerProperties) {
            //todo change to PropertyGroup
            if (playerProperty instanceof Estate){
                if (((Estate) playerProperty).getBuildings() == AMOUNT_OF_HOUSES_THAT_REPRESENT_A_HOTEL){
                    amountOfPlayerOwnedHotels+=1;
                    break;
                }
                amountOfPlayerOwnedHouses+=((Estate) playerProperty).getBuildings();
            }
        }
        int rentDue = (amountOfPlayerOwnedHouses * houseMultiplier)
                + (amountOfPlayerOwnedHotels * hotelMultiplier);
        controller.transferMoneyToOrFromBank(-1 * rentDue);
    }
}
