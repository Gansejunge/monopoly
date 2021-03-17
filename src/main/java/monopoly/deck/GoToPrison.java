package monopoly.deck;

import monopoly.GameController;

public class GoToPrison implements Action{
    public void perfom(GameController controller){
        //toDo
        controller.getCurrentPlayer().moveToField(10,false);
    }
}
