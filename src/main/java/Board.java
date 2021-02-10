import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<FieldTest> fields;

    public Board(){
        fields = new ArrayList<>();
    }

    public FieldTest movePlayer(PlayerTest player, int step){
        int resultingPosition = (player.getPosition() + step) % fields.size();
        player.setPosition(resultingPosition);
        return fields.get(resultingPosition);
    }
}
