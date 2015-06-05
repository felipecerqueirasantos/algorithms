package chess;

/**
 * Created by sky on 04/06/15.
 */
public class Player {
    private final ColorType colorType;

    public Player(ColorType colorType) {
        this.colorType = colorType;
    }

    public ColorType getColorType() {
        return colorType;
    }
}
