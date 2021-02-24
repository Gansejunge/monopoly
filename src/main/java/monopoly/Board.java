package monopoly;

import monopoly.field.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Field> fields;

    public Board(){
        fields = new ArrayList<>();
        initBoard();
    }

    public Field movePlayer(Player player, int step){
        int resultingPosition = (player.getPosition() + step) % fields.size();
        player.setPosition(resultingPosition);
        return fields.get(resultingPosition);
    }

    private void initBoard(){
        fields.add(new Go());
        fields.add(new Estate("Schlossallee", "red", new double[]{0.1}));
        fields.add(new Trainstation());
        fields.add(new Prison());
    }
}
