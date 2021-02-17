package monopoly.deck;

import monopoly.GameController;

public class MaintainOwnedEstate implements Action {
    private int houseMultiplier;
    private int hotelMultiplier;

    public MaintainOwnedEstate(int houseMultiplier, int hotelMultiplier) {
        this.houseMultiplier = houseMultiplier;
        this.hotelMultiplier = hotelMultiplier;
    }

    @Override
    public void perfom(GameController controller) {
        //todo
//        int rentDue = (controller.getCurrentPlayer().getAmountOfHouses() * houseMultiplier)
//                + (controller.getCurrentPlayer().getAmountOfHotels * hotelMultiplier);
//        controller.transferMoneyToOrFromBank(-1 * rentDue);
    }
}
