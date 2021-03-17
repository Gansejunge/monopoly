package monopoly.deck;

import monopoly.GameController;

public class DrawActionCard implements Action {
    public void perfom(GameController controller) {
        controller.drawCard(CardType.Ereigniskarte);
    }
}
