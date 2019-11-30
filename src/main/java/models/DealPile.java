package models;

import java.util.ArrayList;
import java.util.Collections;
import com.fasterxml.jackson.annotation.JsonIgnore;


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
    // Shuffle uses the shuffle function from Collections to shuffle the deck
    @JsonIgnore
    public boolean dealPileStillGood(){
        if (cards.size() >= 4 ){
            return true;
        }
        return false;
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }
}