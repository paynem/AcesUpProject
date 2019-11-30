package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Card implements Serializable {
    private int value;
    private Suit suit;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit) {
        this.value = value;
        this.suit = suit;

    }

    // Instead of creating a class that inherits from card, I simply put the new Spanish suits into this enum thingy.  Perhaps creating a new class would be better, though
    // since that seems to be what they're trying to push us to do with the assignment.
    public enum Suit  implements Serializable {
        Hearts, Spades, Diamonds, Clubs, Bastos, Oros, Copas, Espadas, Jokera, Jokerb
    }

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

    // I created this function to make processing discards with jokers a little easier.
    @JsonIgnore
    public boolean isCardJoker()
    {
        if (this.getSuit() == Suit.Jokera || this.getSuit() == Suit.Jokerb){
            return true;
        }
        return false;
    }


    public String toString() {
        return this.value + this.suit.toString();
    }
}
