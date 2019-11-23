package models;

import javax.swing.*;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {

    // My understanding is that List is an interface in java (not a class). Setting
    // cols up like this gives you
    // the flexibility to change it to something like a linked list later on if you
    // need to.
    @JsonProperty("DealPile")
    private DealPile dealPile;
    @JsonProperty("Cols")
    private java.util.List<Column> cols = new ArrayList<>(4);
    @JsonProperty("DiscardPile")
    private SuccessPile discardPile;

    public Game() {

        dealPile = new DealPile();

        Column a1 = new Column();
        cols.add(a1);
        Column a2 = new Column();
        cols.add(a2);
        Column a3 = new Column();
        cols.add(a3);
        Column a4 = new Column();
        cols.add(a4);

        discardPile = new SuccessPile();
    }

    public void shuffle() {
        dealPile.shuffle();
    }

    public void dealFour() {
        // As long as the deck isn't empty, we pull 4 cards from it and put one of each
        // of them into the 4 columns.
        if (dealPile.dealPileStillGood()) {
            for (int i = 0; i < 4; i++) {
                addCardToCol(i, dealPile.getCard(0));
                this.dealPile.removeCard(0);
            }
        }
    }

    public int getDiscardPileSize() {
        return discardPile.getSize();
    }

    public void remove(int columnNumber) {

        if (columnHasCards(columnNumber)) {
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
                removeCardFromCol(columnNumber);
                this.discardPile.addCard(c);

            }
        }

    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false,
        // otherwise return true
        if (!this.cols.get(columnNumber).isEmpty()) {
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).getCard((cols.get(columnNumber).numCards() - 1));
    }

    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (columnHasCards(columnFrom)) {
            if (!(columnHasCards(columnTo))) {
                Card cardToMove = getTopCard(columnFrom);
                removeCardFromCol(columnFrom);
                addCardToCol(columnTo, cardToMove);
            }
        }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).addCard(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        cols.get(colFrom).removeCard(cols.get(colFrom).numCards() - 1);
    }
}
