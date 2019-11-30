package models;

import java.util.ArrayList;
import java.util.Collections;
import com.fasterxml.jackson.annotation.JsonIgnore;


//DealPile is a child of GroupOfCards.
public class SpanDeal extends GroupOfCards {
// DealPile's constructor generates an arraylist with 52 cards
    public SpanDeal() {
        cards = new ArrayList<>();
        for (int i = 2; i < 14; i++) {
            cards.add(new Card(i, Card.Suit.Bastos));
            cards.add(new Card(i, Card.Suit.Oros));
            cards.add(new Card(i, Card.Suit.Copas));
            cards.add(new Card(i, Card.Suit.Espadas));
        }
        cards.add(new Card(14, Card.Suit.Jokera));
        cards.add(new Card(14, Card.Suit.Jokerb));
    }
    // Shuffle uses the shuffle function from Collections to shuffle the deck
    
    @JsonIgnore
    public boolean spanDealPileStillGood(){
        if (cards.size() >= 4 ){
            return true;
        }
        return false;
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }
}