package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SpanCard extends Card {
    private int value;
    private Suit suit;

    @JsonCreator
    public SpanCard(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit) {
        this.value = value;
        this.suit = suit;

    }

    public enum Suit implements Serializable {
        Bastos, Oros, Cops, Espadas, Jokera, Jokerb
    }
}
