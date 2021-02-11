package monopoly.deck;

import monopoly.GameController;

public class MoveToLocation implements Action{
    private int location;
    private boolean getMoneyFromStart;
    public MoveToLocation(int location, boolean getMoneyFromStart){
        this.location=location;
        this.getMoneyFromStart=getMoneyFromStart;
    }
    @Override
    public void perfom(GameController controller) {
        controller.moveToField(this.location,this.getMoneyFromStart);
    }
}
