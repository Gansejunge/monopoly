package monopoly.deck;

import monopoly.GameController;
import monopoly.field.Estate;


public class MoveToLocationWhilePossiblyPayingHigherRent implements Action{
    final int[] locationOfEstatesPlayerIsMovingTo;
    final int rentMultiplier;

    public MoveToLocationWhilePossiblyPayingHigherRent(int[] locationOfEstatesPlayerIsMovingTo, int rentMultiplier){
        this.locationOfEstatesPlayerIsMovingTo = locationOfEstatesPlayerIsMovingTo;
        this.rentMultiplier=rentMultiplier;
    }
    @Override
    public void perfom(GameController controller) {
        int currentLocation=controller.getCurrentPlayer().getPosition();
        int locationToMoveTo=0;
        //todo take advantage of the new Property layout
        if (currentLocation> locationOfEstatesPlayerIsMovingTo[locationOfEstatesPlayerIsMovingTo.length-1]) locationToMoveTo= locationOfEstatesPlayerIsMovingTo[0];
        else{
            for (int i = 0; i < locationOfEstatesPlayerIsMovingTo.length; i++) {
                if(currentLocation< locationOfEstatesPlayerIsMovingTo[i]) {
                    locationToMoveTo = i;
                    break;
                }
            }
        }
        //todo
        Estate propertyAtNewLocation= (Estate) controller.getMonopolyBoard().getFieldAtIndex(locationToMoveTo);
        if  (!propertyAtNewLocation.hasOwner()){
            int rent=-1*propertyAtNewLocation.getRent()*this.rentMultiplier;
            controller.getCurrentPlayer().addMoneyFromOtherPlayer(propertyAtNewLocation.getOwner(), rent);
        }
        controller.getCurrentPlayer().moveToField(locationToMoveTo,true);

    }
}
