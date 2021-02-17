package monopoly.deck;

import monopoly.GameController;
import monopoly.Player;

public class RedistributeMoneyToOrFromCurrentPlayer implements Action{
    private int moneyToGiveOrTake;
    public RedistributeMoneyToOrFromCurrentPlayer(int moneyToGiveOrTake){
        this.moneyToGiveOrTake=moneyToGiveOrTake;
    }
    @Override
    public void perfom(GameController controller) {
        for (Player otherPlayer:controller.getOtherPlayers(controller.getCurrentPlayer())){
            controller.getCurrentPlayer().giveMoney(otherPlayer,moneyToGiveOrTake);
        }
    }
}
