package chess;

/**
 * Created by sky on 04/06/15.
 */
public final class Piece {
    public enum PieceType {
        PAWN,
        KNIGHT,
        ROCK,
        BISHOP,
        QUEEN,
        KING;
    }

    private final ColorType colorType;
    private final PieceType pieceType;

    public Piece(PieceType pieceType, ColorType colorType) {
        this.pieceType = pieceType;
        this.colorType = colorType;
    }

    @Override
    public String toString() {
        String s = null;
        switch(pieceType) {
            case PAWN:
                s = "[" + "P" + "]";
                break;
            case KNIGHT:
                s = "[" + "N" + "]";
                break;
            case ROCK:
                s = "[" + "R" + "]";
                break;
            case BISHOP:
                s = "[" + "B" + "]";
                break;
            case QUEEN:
                s = "[" + "Q" + "]";
                break;
            case KING:
                s = "[" + "K" + "]";
                break;
            default:
                throw new IllegalStateException("Unknown piece type");
        }

        return s;
    }
}
