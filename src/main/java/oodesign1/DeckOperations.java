package oodesign1;

/**
 * Created by sky on 6/3/15.
 */
public interface DeckOperations {
    void shuffle();
    Card getCard() throws DeckOperationException;
    void returnCard(Card card);
}
