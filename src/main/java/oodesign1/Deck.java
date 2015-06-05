package oodesign1;

import java.util.Collections;
import java.util.List;

/**
 * Created by sky on 6/3/15.
 */
public class Deck implements DeckOperations {
    private List<Card> cards;
    private boolean shuffled;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
        shuffled = true;
    }

    @Override
    public Card getCard() throws DeckOperationException {
        if (cards.size() == 0)
            throw new DeckOperationException("Deck is empty");

        return cards.remove(0);
    }

    @Override
    public void returnCard(Card card) {
        cards.add(card);
    }
}
