package monopoly.deck;

import monopoly.GameController;

public class DrawCard {
    public void perfom(GameController controller, CardType cardType){
        controller.drawCard(cardType);
    }
}
