package models;

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
    protected java.util.ArrayList<Column> cols = new ArrayList<>(4);
    /*@JsonProperty("A1")
    private Column a1 = new Column();
    @JsonProperty("A2")
    private Column a2 = new Column();
    @JsonProperty("A3")
    private Column a3 = new Column();
    @JsonProperty("A4")
    private Column a4 = new Column();*/

    public java.util.List<java.util.List<Card>> discardPile = new ArrayList<>(1);

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

        ArrayList<Card> discard = new ArrayList<Card>();
        discardPile.add(discard);
    }

    public void shuffle() {
        // Thankfully, Collections has a shuffle method built into it. This, well,
        // shuffles the deck
        dealPile.shuffle();
    }

    public void dealFour() {
        // As long as the deck isn't empty, we pull 4 cards from it and put one of each
        // of them into the 4 columns.
        if (dealPile.numCards() >= 4) {
            for (int i = 0; i < 4; i++) {
                addCardToCol(i, dealPile.getCard(0));
                this.dealPile.removeCard(0);
            }
        }
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

            }
        }

    }

    /*public Column getColumn(int i) {
        if (i == 0) {
            return a1;
        } else if (i == 1) {
            return a1;
        } else if (i == 2) {
            return a1;
        } else {
            return a1;
        }

    }*/

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false,
        // otherwise return true
        if (this.cols.get(columnNumber).numCards() > 0) {
            return true;
        }
        return false;
        /*
        if (columnNumber == 0) {
            if (this.a1.numCards() > 0) {
                return true;
            }
            return false;
        }
        if (columnNumber == 1) {
            if (this.a1.numCards() > 0) {
                return true;
            }
            return false;
        }
        if (columnNumber == 2) {
            if (this.a1.numCards() > 0) {
                return true;
            }
            return false;
        }
        if (columnNumber == 3) {
            if (this.a1.numCards() > 0) {
                return true;
            }
            return false;
        }*/
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).getCard((cols.get(columnNumber).numCards() - 1));
        
        /*if (columnNumber == 0) {
            return this.a1.getCard(a1.numCards() - 1);
        } else if (columnNumber == 1) {
            return this.a2.getCard(a2.numCards() - 1);
        } else if (columnNumber == 2) {
            return this.a3.getCard(a3.numCards() - 1);
        } else {
            return this.a4.getCard(a4.numCards() - 1);
        }*/

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
        /*if (columnTo == 0) {
            a1.addCard(cardToMove);
        }
        if (columnTo == 1) {
            a2.addCard(cardToMove);
        }
        if (columnTo == 2) {
            a3.addCard(cardToMove);
        }
        if (columnTo == 3) {
            a4.addCard(cardToMove);
        }*/

    }

    private void removeCardFromCol(int colFrom) {
        cols.get(colFrom).removeCard(cols.get(colFrom).numCards() - 1);
        /*if (colFrom == 0) {
            a1.removeCard(a1.numCards() - 1);
        }
        if (colFrom == 1) {
            a2.removeCard(a2.numCards() - 1);
        }
        if (colFrom == 2) {
            a3.removeCard(a3.numCards() - 1);
        }
        if (colFrom == 3) {
            a4.removeCard(a4.numCards() - 1);
        }*/

    }
}
