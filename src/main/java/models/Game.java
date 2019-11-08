package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get
 * AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();
    // My understanding is that List is an interface in java (not a class). Setting
    // cols up like this gives you
    // the flexibility to change it to something like a linked list later on if you
    // need to.
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public Game() {
        // Since we have an array list of arraylists. We need to set up the arraylist in
        // each index
        ArrayList<Card> a1 = new ArrayList<Card>();
        cols.add(a1);
        ArrayList<Card> a2 = new ArrayList<Card>();
        cols.add(a2);
        ArrayList<Card> a3 = new ArrayList<Card>();
        cols.add(a3);
        ArrayList<Card> a4 = new ArrayList<Card>();
        cols.add(a4);
    }

    public void buildDeck() {
        for (int i = 2; i < 15; i++) {
            deck.add(new Card(i, Suit.Clubs));
            deck.add(new Card(i, Suit.Hearts));
            deck.add(new Card(i, Suit.Diamonds));
            deck.add(new Card(i, Suit.Spades));
        }
    }

    public void shuffle() {
        // Thankfully, Collections has a shuffle method built into it. This, well,
        // shuffles the deck
        Collections.shuffle(deck);
    }

    public void dealFour() {
        // As long as the deck isn't empty, we pull 4 cards from it and put one of each
        // of them into the 4 columns.
        if (deck.size() >= 4) {
            for (int i = 0; i < 4; i++) {
                addCardToCol(i, deck.get(0));
                this.deck.remove(0);
            }
        }
    }

    public void remove(int columnNumber) {
     if(columnHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false,
        // otherwise return true
         if(this.cols.get(columnNumber).size()>0){
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size() - 1);
    }

    public void move(int columnFrom, int columnTo) {
       // remove the top card from the columnFrom column, add it to the columnTo column
        if (columnHasCards(columnFrom)) {
            if (!(columnHasCards(columnTo))) {
                Card cardToMove = getTopCard(columnFrom);
                this.removeCardFromCol(columnFrom);
                this.addCardToCol(columnTo, cardToMove);
            }
        }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size() - 1);
    }
}
