package models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get
 * AcesUp to build/run
 */
public class Game {

    public GroupOfCards deck = new GroupOfCards();
    // My understanding is that List is an interface in java (not a class). Setting
    // cols up like this gives you
    // the flexibility to change it to something like a linked list later on if you
    // need to.
    public java.util.List<Column> cols = new java.util.ArrayList<Column>();

    public GroupOfCards discardPile = new GroupOfCards();

    public Game() {
        // Since we have an array list of arraylists. We need to set up the arraylist in
        // each index
        Column a1 = new Column(1);
        cols.add(a1);
        Column a2 = new Column(2);
        cols.add(a2);
        Column a3 = new Column(3);
        cols.add(a3);
        Column a4 = new Column(4);
        cols.add(a4);

    }

    public void buildDeck() {
        for (int i = 2; i < 15; i++) {
            deck.addCard((new Card(i, Card.Suit.Hearts)));
            deck.addCard((new Card(i, Card.Suit.Diamonds)));
            deck.addCard((new Card(i, Card.Suit.Spades)));
            deck.addCard((new Card(i, Card.Suit.Clubs)));
        }
    }

    public void shuffle() {
        // Thankfully, Collections has a shuffle method built into it. This, well,
        // shuffles the deck
        Collections.shuffle(deck.cards);
    }

    public void dealFour() {
        // As long as the deck isn't empty, we pull 4 cards from it and put one of each
        // of them into the 4 columns.
        if (deck.cards.size() >= 4) {
            for (int i = 0; i < 4; i++) {
                addCardToCol(i, deck.getCard(0));
                this.deck.removeCard(0);
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
                this.cols.get(columnNumber).removeCard(this.cols.get(columnNumber).getSize() - 1);
                this.discardPile.addCard(c);
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false,
        // otherwise return true
        if (this.cols.get(columnNumber).getSize() > 0) {
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).getCard(this.cols.get(columnNumber).getSize() - 1);
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
        cols.get(columnTo).addCard(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).removeCard(this.cols.get(colFrom).getSize() - 1);
    }
}
