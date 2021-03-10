package monopoly.deck;

import monopoly.GameController;

public class DrawCommunityCard implements Action{
    public void perfom(GameController controller){
        controller.drawCard();
    }
}
