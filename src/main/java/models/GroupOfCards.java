package models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

// GroupOfCards is the parent class of a large number of classes in our program.  It is designed to be a framework or skeleton for
// any class that needs to house and manipulate playing cards

public class GroupOfCards {
    @JsonProperty("Cards")
    protected java.util.ArrayList<Card> cards;

    // The constructor creates an ArrayList, but it doesn't populate it with
    // anything
    public GroupOfCards() {

    }

    // numCards returns the size of the arrayList

    public int numCards() {

        return cards.size();
    }

    public Card getCard(int index) {

        return cards.get(index);
    }

    // addCard adds the passed in card to the GroupOfCards arraylist
    public void addCard(Card card) {
        cards.add(card);
    }

    // removeCard removes a card from the passed-in index
    public void removeCard(int index) {
        cards.remove(index);
    }

}
