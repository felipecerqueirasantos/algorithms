package chess;

/**
 * Created by sky on 04/06/15.
 */
public final class MoveResult {
    public enum MoveResultType {
        NONE,
        MATE,
        CHECKMATE,
        CAPTURED;
    }

    private final MoveResultType moveResultType;
    private final Piece targetPiece;

    public MoveResult(MoveResultType moveResultType, Piece targetPiece) {
        this.moveResultType = moveResultType;
        this.targetPiece = targetPiece;
    }

    @Override
    public String toString() {
        if (targetPiece == null)
            return "[" + moveResultType + "]";

        return "[" + moveResultType + ", " + targetPiece + "]";
    }
}
