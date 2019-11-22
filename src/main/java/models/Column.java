package models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Column extends GroupOfCards{
    private int colNumber;

    @JsonCreator
    public Column(@JsonProperty("colNumber") int colNumber) {
        this.colNumber = colNumber;
    }
}
