package models;

import com.fasterxml.jackson.annotation.JsonProperty;

// SpanGame inherits from Game.Java
// It generates a spanish deck instead of a regular deck and has a few slightly adjusted methods to deal with the differences in cards
public class SpanGame extends Game {
    @JsonProperty("DealPile")
    private SpanDeal spanDeal;

    public SpanGame() {

        spanDeal = new SpanDeal();

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
        spanDeal.shuffle();
    }

    // This function had to be adjusted so that it deals the two remaining cards
    // (after 50 cards have been dealt)
    public void dealFour() {
        // As long as the deck isn't empty, we pull 4 cards from it and put one of each
        // of them into the 4 columns.
        if (spanDeal.spanDealPileStillGood()) {
            for (int i = 0; i < 4; i++) {
                addCardToCol(i, spanDeal.getCard(0));
                this.spanDeal.removeCard(0);
            }
        } else if (spanDeal.numCards() == 2) {
            addCardToCol(0, spanDeal.getCard(0));
            this.spanDeal.removeCard(0);
            addCardToCol(1, spanDeal.getCard(0));
            this.spanDeal.removeCard(0);
        }
    }

    // Lol what a nightmare this function is. However, it does deal with the Joker
    // cards. It only discards off of Joker cards (it prioritizes non-Joker cards)
    // if there are no other suitable cards to discard off of.
    public void remove(int columnNumber) {
        int jokerNum = -1;
        Card joker = new Card(14, Card.Suit.Jokera);
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
                        } else if (compare.isCardJoker()) {
                            jokerNum = i;
                            joker = compare;
                        }
                    }
                }
            }
            if (removeCard) {
                removeCardFromCol(columnNumber);
                this.discardPile.addCard(c);

            } else if (!removeCard && jokerNum != -1) {
                removeCardFromCol(jokerNum);
                this.discardPile.addCard(joker);
                removeCardFromCol(columnNumber);
                this.discardPile.addCard(c);
            }
        }

    }
}
