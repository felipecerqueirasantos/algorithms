package chess;

/**
 * Created by sky on 04/06/15.
 */
public final class ChessBoard {
    private Piece[][] board = new Piece[8][8];

    public ChessBoard() {
        setUp();
    }

    private void setUp() {
        // White board setup
        int line = 6;
        for (int column = 0; column < board[line].length; column++)
            board[line][column] = new Piece(Piece.PieceType.PAWN, ColorType.WHITE);

        line = 7;
        board[line][0] = new Piece(Piece.PieceType.ROCK, ColorType.WHITE);
        board[line][1] = new Piece(Piece.PieceType.KNIGHT, ColorType.WHITE);
        board[line][2] = new Piece(Piece.PieceType.BISHOP, ColorType.WHITE);
        board[line][3] = new Piece(Piece.PieceType.KING, ColorType.WHITE);
        board[line][4] = new Piece(Piece.PieceType.QUEEN, ColorType.WHITE);
        board[line][5] = new Piece(Piece.PieceType.BISHOP, ColorType.WHITE);
        board[line][6] = new Piece(Piece.PieceType.KNIGHT, ColorType.WHITE);
        board[line][7] = new Piece(Piece.PieceType.ROCK, ColorType.WHITE);

        // Black board setup
        line = 1;
        for (int column = 0; column < board[line].length; column++)
            board[line][column] = new Piece(Piece.PieceType.PAWN, ColorType.BLACK);

        line = 0;
        board[line][0] = new Piece(Piece.PieceType.ROCK, ColorType.BLACK);
        board[line][1] = new Piece(Piece.PieceType.KNIGHT, ColorType.BLACK);
        board[line][2] = new Piece(Piece.PieceType.BISHOP, ColorType.BLACK);
        board[line][3] = new Piece(Piece.PieceType.KING, ColorType.BLACK);
        board[line][4] = new Piece(Piece.PieceType.QUEEN, ColorType.BLACK);
        board[line][5] = new Piece(Piece.PieceType.BISHOP, ColorType.BLACK);
        board[line][6] = new Piece(Piece.PieceType.KNIGHT, ColorType.BLACK);
        board[line][7] = new Piece(Piece.PieceType.ROCK, ColorType.BLACK);
    }

    public Piece getPiece(int line, int column) throws ChessGameException {
        if (!validateLineColumn(line, column))
            throw new ChessGameException("Invalid line or column.");

        return board[line][column];
    }

    // Set a piece in line/column and return the previous piece located there
    public Piece setPiece(Piece piece, int line, int column) throws ChessGameException {
        if (!validateLineColumn(line, column))
            throw new ChessGameException("Invalid line or column.");

        Piece t = board[line][column];
        board[line][column] = piece;
        return t;
    }

    private boolean validateLineColumn(int line, int column) {
        if (line < 0 || line >= board.length)
            return false;

        if (column < 0 || column >= board[line].length)
            return false;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);

        sb.append("   a   b   c   d   e   f   g   h").append(System.lineSeparator());

        for (int line = 0; line < board.length; line++) {
            sb.append(line + 1).append(" ");

            for (int column = 0; column < board[line].length; column++) {
                if (column > 0)
                    sb.append(" ");

                if (board[line][column] == null)
                    sb.append("[ ]");
                else
                    sb.append(board[line][column]);
            }

            sb.append(System.lineSeparator());
        }

        sb.append("   a   b   c   d   e   f   g   h").append(System.lineSeparator());
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
