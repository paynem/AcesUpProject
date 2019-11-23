package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Card implements Serializable {
    private int value;
    private Suit suit;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit) {
        this.value = value;
        this.suit = suit;

    }

    public enum Suit  implements Serializable {
        Hearts, Spades, Diamonds, Clubs
    }

    //@JsonProperty("GetValue")
    public int getValue() {
        return this.value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }


    public String toString() {
        return this.value + this.suit.toString();
    }
}
