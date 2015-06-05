package oodesign1;

/**
 * Created by sky on 6/3/15.
 */
public class Card implements Comparable<Card> {
    public enum Color {
        BLACK,
        RED;

    }

    public enum Suit {
        HEART,
        DIAMOND,
        SPADES,
        CLUBS;
    }

    private char value;
    private Color color;
    private Suit suit;

    public Card(Color color, Suit suit, char value) {
        this.value = value;
        this.color = color;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        int cmp = value - o.value;
        if (cmp != 0)
            return cmp;

        if (suit == o.suit) {
            if (color == o.color)
                return 0;
            else
                return 1;
        }

        return 1;
    }

    @Override
    public String toString() {
        return "[Card: " + color + ", " + suit + ", " + value + "]";
    }
}
