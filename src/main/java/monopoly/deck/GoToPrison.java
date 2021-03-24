package monopoly.deck;

import monopoly.GameController;

public class GoToPrison implements Action{
    public void perfom(GameController controller){
        controller.getCurrentPlayer().moveToField(10,false);
        controller.getCurrentPlayer().setInPrison(true);
    }
}
