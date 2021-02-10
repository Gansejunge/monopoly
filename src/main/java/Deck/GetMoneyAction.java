package Deck;

public class GetMoneyAction implements Action{
    private int amountOfMoney;
    public GetMoneyAction(int amountOfMoney){
        this.amountOfMoney=amountOfMoney;
    }
    @Override
    public void perfom(GameController controller) {
        controller.giveMoney(this.amountOfMoney);
    }
}
