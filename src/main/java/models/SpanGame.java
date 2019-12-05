package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    public SpanDeal getSpanDealPile() {
        return spanDeal;
    }
}
