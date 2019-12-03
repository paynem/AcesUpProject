package models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {

    // My understanding is that List is an interface in java (not a class). Setting
    // cols up like this gives you
    // the flexibility to change it to something like a linked list later on if you
    // need to.
    @JsonProperty("DealPile")
    public DealPile dealPile;
    @JsonProperty("Cols")
    protected java.util.ArrayList<Column> cols = new ArrayList<>(4);
    @JsonProperty("DiscardPile")
    protected SuccessPile discardPile;

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

    @JsonIgnore
    public DealPile getDealPile() {
        return dealPile;
    }

    @JsonIgnore
    public ArrayList<Column> getColumns() {
        return cols;
    }
}
