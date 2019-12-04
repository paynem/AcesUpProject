package models;

import java.util.ArrayList;

//DealPile is a child of GroupOfCards.
public class SpanDeal extends DealPile {
// DealPile's constructor generates an arraylist with 52 cards
    public SpanDeal() {
        cards = new ArrayList<>();
        for (int i = 3; i < 15; i++) {
            cards.add(new Card(i, Card.Suit.Bastos));
            cards.add(new Card(i, Card.Suit.Oros));
            cards.add(new Card(i, Card.Suit.Copas));
            cards.add(new Card(i, Card.Suit.Espadas));
        }
        cards.add(new Card(15, Card.Suit.Jokera));
        cards.add(new Card(15, Card.Suit.Jokerb));
    }
    // Shuffle uses the shuffle function from Collections to shuffle the deck
    public void dealFour(ArrayList<Column> cols) {
        // As long as the deck isn't empty, we pull 4 cards from it and put one of each
        // of them into the 4 columns.
        if (cards.size() >= 4) {
            for (int i = 0; i < 4; i++) {
                cols.get(i).addCard(cards.get(0));
                cards.remove(0);
            }
        } else if (cards.size() == 2) {
            cols.get(0).addCard(cards.get(0));
            cards.remove(0);
            cols.get(1).addCard(cards.get(0));
            cards.remove(0);
        }
    }
}