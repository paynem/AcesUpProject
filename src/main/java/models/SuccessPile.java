package models;

import java.util.ArrayList;

public class SuccessPile extends GroupOfCards {

    public SuccessPile() {
        cards = new ArrayList<>();

    }
    
    private Card getTopCard() {
        return cards.get(cards.size() - 1);
    }
}