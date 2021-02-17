package monopoly.deck;

import monopoly.GameController;

public class MoveFields implements Action{
    private int amountOfMoves;

    public MoveFields(int amountOfMoves){
        this.amountOfMoves=amountOfMoves;
    }

    @Override
    public void perfom(GameController controller) {
        controller.movePlayer(this.amountOfMoves);
    }
}
