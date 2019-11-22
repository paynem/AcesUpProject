package models;

import java.util.ArrayList;

// GroupOfCards is the parent class of a large number of classes in our program.  It is designed to be a framework or skeleton for
// any class that needs to house and manipulate playing cards
public class GroupOfCards {
    protected java.util.List<Card> cards;

    // The constructor creates an ArrayList, but it doesn't populate it with
    // anything
    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    // numCards returns the size of the arrayList
    public int numCards() {
        return cards.size();
    }

    // isEmpty is a boolean tmethod that returns true if GroupOfCards is empty
    public boolean isEmpty() {
        if (numCards() == 0) {
            return true;
        }
        return false;
    }

    // getCard returns the value of whatever card currently resides in the chosen
    // index
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
