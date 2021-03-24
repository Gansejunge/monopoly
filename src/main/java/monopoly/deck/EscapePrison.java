package monopoly.deck;

import monopoly.GameController;

public class EscapePrison implements Action{
    @Override
    public void perfom(GameController controller) {
        controller.getCurrentPlayer().setInPrison(false);
    }
}
