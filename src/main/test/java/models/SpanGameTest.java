package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpanGameTest {

    @Test
    public void getSpanDealPile() {
        // Create a temporary spanish game
        SpanGame temp = new SpanGame();

        // Assert the spanDeal object that was instantiated in the constructor is the same one
        // that getSpanDealPile() returns
        assertEquals(temp.spanDeal, temp.getSpanDealPile());
    }
}