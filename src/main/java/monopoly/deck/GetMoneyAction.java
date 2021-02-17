package monopoly.deck;

import monopoly.GameController;

public class GetMoneyAction implements Action{
    private int amountOfMoney;
    public GetMoneyAction(int amountOfMoney){
        this.amountOfMoney=amountOfMoney;
    }
    @Override
    public void perfom(GameController controller) {
//        todo
//        controller.transferMoneyToOrFromBank(this.amountOfMoney);
    }
}
