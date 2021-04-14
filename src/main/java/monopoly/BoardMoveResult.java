package monopoly;

import monopoly.field.Field;

public class BoardMoveResult {
    public Field result;
    boolean passedGo;

    public BoardMoveResult(Field result, boolean passedGo) {
        this.result = result;
        this.passedGo = passedGo;
    }
}
