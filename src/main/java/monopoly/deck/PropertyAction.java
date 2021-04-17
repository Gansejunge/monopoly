package monopoly.deck;

import monopoly.GameController;
import monopoly.field.Property;

public class PropertyAction implements Action{
    private Property field;

    public PropertyAction(Property field){
        this.field = field;
    }

    @Override
    public void perfom(GameController controller) {
        if(!this.field.hasOwner()){
            controller.requestBuy(field);
        } else{
            controller.payRent(field);
        }
    }
}