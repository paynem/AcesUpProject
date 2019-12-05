package models;

import java.util.ArrayList;
import java.util.Collections;

//DealPile is a child of GroupOfCards.
public class DealPile extends GroupOfCards {
    // DealPile's constructor generates an arraylist with 52 cards
    public DealPile() {
        cards = new ArrayList<>();
        for (int i = 2; i < 15; i++) {
            cards.add(new Card(i, Card.Suit.Clubs));
            cards.add(new Card(i, Card.Suit.Hearts));
            cards.add(new Card(i, Card.Suit.Diamonds));
            cards.add(new Card(i, Card.Suit.Spades));
        }
    }

    public void dealFour(ArrayList<Column> cols) {
        // As long as the deck isn't empty, we pull 4 cards from it and put one of each
        // of them into the 4 columns.
        if (cards.size() >= 4) {
            for (int i = 0; i < 4; i++) {
                cols.get(i).addCard(cards.get(0));
                cards.remove(0);
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }
}