package monopoly.deck;

import monopoly.GameController;

public class AdditionalTax implements Action{
    int amountOfMoney;
    public AdditionalTax(int amountOfMoney){
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public void perfom(GameController controller) {
        controller.getCurrentPlayer().addMoney(amountOfMoney);
    }
}
