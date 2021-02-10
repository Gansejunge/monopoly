package deck;

import main.GameController;

public class MoveFields implements Action{
    private int amountOfMoves;
    private boolean getMoneyFromStart;
    public MoveFields(int amountOfMoves,boolean getMoneyFromStart){
        this.amountOfMoves=amountOfMoves;
        this.getMoneyFromStart=getMoneyFromStart;
    }
    @Override
    public void perfom(GameController controller) {
        controller.movePlayer(this.amountOfMoves,this.getMoneyFromStart);
    }
}
