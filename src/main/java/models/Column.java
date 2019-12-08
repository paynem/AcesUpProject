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
        //if top card in this column is an ace, don't discard
        int topCardVal = this.getCard(this.numCards() - 1).getValue();
        if(topCardVal == 14 || topCardVal == 15)
        {
            return;
        }

        int jokerNum = -1;
        if (!this.cards.isEmpty()) {
            Card c = this.cards.get(cards.size() - 1);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (!cards.equals(cols.get(i)) && !cols.get(i).isEmpty()) {
                    Card compare = cols.get(i).getCard((cols.get(i).numCards() - 1));
                    if (compare.getSuit() == c.getSuit() && compare.getValue() > c.getValue()) {
                        removeCard = true;
                    } else if (compare.isCardJoker()) {
                        jokerNum = i;
                    }
                }
            }
            if (removeCard || (jokerNum != -1)) {
                removeCardFromCol();
                discardPile.addCard(c);
                if (!removeCard){
                    discardPile.addCard(cols.get(jokerNum).getCard(cols.get(jokerNum).numCards() - 1));
                    cols.get(jokerNum).removeCard(cols.get(jokerNum).numCards() - 1);
                }
        }
    }
}

    protected void removeCardFromCol() {
        this.cards.remove(cards.size() - 1);
    }
}
