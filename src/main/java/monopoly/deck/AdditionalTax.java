package monopoly.deck;

import monopoly.GameController;

public class AdditionalTax implements Action{
    @Override
    public void perfom(GameController controller) {
        controller.getCurrentPlayer().addMoney(-500);
    }
}
