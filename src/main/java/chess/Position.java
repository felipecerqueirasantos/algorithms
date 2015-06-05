package chess;

/**
 * Created by sky on 04/06/15.
 */
public class Position {
    private final ColorType colorType;
    private final char column;
    private final int line;

    public Position(ColorType colorType, char column, int line) {
        this.colorType = colorType;
        this.column = column;
        this.line = line;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public char getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }

    @Override
    public String toString() {
        return "[" + colorType.name() + ", " + column + "," + line + "]";
    }
}
