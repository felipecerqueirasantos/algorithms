package chess;

/**
 * Created by sky on 04/06/15.
 */
public final class BoardGameFactory {
    public static ChessGame makeChessGame() {
        return new ChessGame(new Player(ColorType.WHITE), new Player(ColorType.BLACK), new ChessBoard());
    }
}
