package chess;

/**
 * Created by sky on 04/06/15.
 */
public final class ChessGame {
    private final ChessBoard chessBoard;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private boolean isWhiteTurn;

    public ChessGame(Player whitePlayer, Player blackPlayer, ChessBoard chessBoard) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.chessBoard = chessBoard;
        this.isWhiteTurn = true;

        assert(blackPlayer.getColorType() == ColorType.BLACK);
        assert(whitePlayer.getColorType() == ColorType.WHITE);
    }

    public MoveResult move(Position from, Position to) throws ChessGameException {
        if ((isWhiteTurn && from.getColorType() != ColorType.WHITE) ||
                (!isWhiteTurn && from.getColorType() != ColorType.BLACK)) {
            throw new ChessGameException("Invalid movement. It is not your turn.");
        }

        if (!validatePieceMovement(from, to)) {
            throw new ChessGameException("Invalid movement. Destination position is not reachable by this piece.");
        }

        return null;
    }

    private boolean validatePieceMovement(Position from, Position to) throws ChessGameException {
        //TODO: implement piece movement validation
        return true;
    }
}
