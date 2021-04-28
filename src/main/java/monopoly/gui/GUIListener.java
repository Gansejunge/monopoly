package monopoly.gui;

import monopoly.Player;
import monopoly.deck.Card;
import monopoly.field.Property;
import monopoly.game.MoveResult;

public interface GUIListener {
    void onMove(MoveResult move);
    void onNextPlayer(Player player);
    void onDrawCard(Card card);
    void onRequestPropertyPurchase(Property field);
    void updatePlayerMoney();
    void onCanRoll(boolean canRoll);
}
