package monopoly;

import monopoly.field.Field;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields;

    public Board(){
        fields = new ArrayList<>();
    }

    public Field movePlayer(Player player, int step){
        int resultingPosition = (player.getPosition() + step) % fields.size();
        player.setPosition(resultingPosition);
        return fields.get(resultingPosition);
    }
}
