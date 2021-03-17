package monopoly.deck;

import monopoly.GameController;
import monopoly.deck.CardType;
public class DrawCommunityCard implements Action{
    public void perfom(GameController controller){
        controller.drawCard(CardType.Gemeinschaftskarte);
    }
}
