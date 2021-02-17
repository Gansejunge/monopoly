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
        int currentLocation=controller.getCurentPlayer().getLocation();
        int locationToMoveTo=0;
        if (currentLocation>location[location.length-1]) locationToMoveTo=location[0];
        else{
            for (int i = 0; i < location.length; i++) {
                if(currentLocation<location[i]) locationToMoveTo=i;
                break;
            }
        }
        if  (!monopoly.Board.getPropertyAtIndex(locationToMoveTo).isEmpty()){
            int rent=monopoly.Board.getPropertyAtIndex(locationToMoveTo).getRent()*rentMultiplier;
        }
        controller.moveToField(locationToMoveTo,true);
    }
}