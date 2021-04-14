package monopoly.gui;

import monopoly.deck.Card;
import monopoly.game.MoveResult;

public interface GUIListener {
    void onMove(MoveResult move);
    void onDrawCard(Card card);
}
