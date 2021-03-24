package monopoly.deck;

import monopoly.GameController;

public class MoveToLocationWhilePossiblyPayingHigherRent implements Action{
    private int[] location;
    private int rentMultiplier;

    public MoveToLocationWhilePossiblyPayingHigherRent(int[] location,int rentMultiplier){
        this.location=location;
        this.rentMultiplier=rentMultiplier;
    }
    @Override
    public void perfom(GameController controller) {
        //todo
        int currentLocation=controller.getCurrentPlayer().getLocation();
        int locationToMoveTo=0;
        //todo take advantage of the new Property layout
        if (currentLocation>location[location.length-1]) locationToMoveTo=location[0];
        else{
            for (int i = 0; i < location.length; i++) {
                if(currentLocation<location[i]) locationToMoveTo=i;
                break;
            }
        }
        //todo
//        if  (!controller.getMonopolyBoard().getFieldAtIndex(locationToMoveTo).hasOwner()){
//            int rent=controller.getMonopolyBoard().getFieldAtIndex(locationToMoveTo).getRent()*rentMultiplier;
//        }
        controller.getCurrentPlayer().moveToField(locationToMoveTo,true);
    }
}
