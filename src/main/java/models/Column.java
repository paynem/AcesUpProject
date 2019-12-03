package models;

import java.util.ArrayList;

public class Column extends GroupOfCards {

    public Column() {
        cards = new ArrayList<>();
    }

    public void move(Column columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (!this.cards.isEmpty()) {
            if (columnTo.isEmpty()) {
                columnTo.addCard(this.cards.get((cards.size() - 1)));
                removeCardFromCol(); 
            }
        }
    }
    
    public void discard(ArrayList<Column> cols, SuccessPile discardPile) {
        int jokerNum = -1;
        Card joker = new Card(14, Card.Suit.Jokera);
        if (!this.cards.isEmpty()) {
            Card c = this.cards.get(cards.size() - 1);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (!cards.equals(cols.get(i))) {
                    if (!cols.get(i).isEmpty()) {
                        Card compare = cols.get(i).getCard((cols.get(i).numCards() - 1));
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                        else if (compare.isCardJoker()) {
                            jokerNum = i;
                            joker = compare;
                        }
                    }
                }
            }
            if (removeCard) {
                removeCardFromCol();
                discardPile.addCard(c);
            }
            else if (!removeCard && jokerNum != -1){
                removeCardFromCol();
                discardPile.addCard(c);
                discardPile.addCard(cols.get(jokerNum).getCard(cols.get(jokerNum).numCards() - 1));
                cols.get(jokerNum).removeCard(cols.get(jokerNum).numCards() - 1);
            }
        }
    }
    protected void removeCardFromCol() {
        this.cards.remove(cards.size() - 1);
    }
}
