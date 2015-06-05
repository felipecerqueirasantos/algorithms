package oodesign1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sky on 6/3/15.
 */
public class DeckFactory {
    public static Deck createFullCardsDeck() {
        List<Card> list = new LinkedList<>();

        char[] values = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'J', 'Q', 'R'};
        for (Card.Color color: Card.Color.values()) {
            for (Card.Suit suit: Card.Suit.values()) {
                for (int i = 0; i < values.length; i++) {
                    list.add(new Card(color, suit, values[i]));
                }
            }
        }

        return new Deck(list);
    }

    public static Deck createPokerDeck() {
        //TODO: create a deck to play poker
        return null;
    }

    /*
     * Sueca: brazilian card game used to be played by at least and maximum 4 players
     */
    public static Deck createSuecaDeck() {
        //TODO: create a deck to play poker
        return null;
    }
}
