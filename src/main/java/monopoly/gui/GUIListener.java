package monopoly.gui;

import monopoly.deck.Card;
import monopoly.field.Property;
import monopoly.game.MoveResult;

public interface GUIListener {
    void onMove(MoveResult move);
    void onDrawCard(Card card);
    void onRequestPropertyPurchase(Property field);
}
