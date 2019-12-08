package models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SpanDealTest {

    @Test
    // Method functions exactly the same way as dealFour from Class DealPile
    public void dealFour() {
        // Assign a temp variable to the constructor of SpanDeal class
        SpanDeal temp = new SpanDeal();

        // Create an array of columns
        java.util.ArrayList<Column> cols = new ArrayList<>(4);

        // Create 4 new columns and append them to the "cols" array list
        Column a1 = new Column();
        cols.add(a1);
        Column a2 = new Column();
        cols.add(a2);
        Column a3 = new Column();
        cols.add(a3);
        Column a4 = new Column();
        cols.add(a4);

        // Assert that equal column is empty
        assertEquals(true, a1.isEmpty());
        assertEquals(true, a2.isEmpty());
        assertEquals(true, a3.isEmpty());
        assertEquals(true, a4.isEmpty());

        // Deal the four cards
        temp.dealFour(cols);

        // Assert that each column is not empty
        assertEquals(false, a1.isEmpty());
        assertEquals(false, a2.isEmpty());
        assertEquals(false, a3.isEmpty());
        assertEquals(false, a4.isEmpty());
    }

    @Test
    // Method functions exactly the same way as dealFour from Class DealPile
    public void dealFourSpanDealEmpty() {
        // Assign a temp variable to the constructor of SpanDeal class
        SpanDeal temp = new SpanDeal();

        // Empty deck
        for (int i = 0; !temp.isEmpty();) {
            temp.removeCard(i);
        }

        // Assert that deck is empty
        assertEquals(true, temp.isEmpty());

        // Create an array of columns
        java.util.ArrayList<Column> cols = new ArrayList<>(4);

        // Create 4 new columns and append them to the "cols" array list
        Column a1 = new Column();
        cols.add(a1);
        Column a2 = new Column();
        cols.add(a2);
        Column a3 = new Column();
        cols.add(a3);
        Column a4 = new Column();
        cols.add(a4);

        // Assert that equal column is empty
        assertEquals(true, a1.isEmpty());
        assertEquals(true, a2.isEmpty());
        assertEquals(true, a3.isEmpty());
        assertEquals(true, a4.isEmpty());

        // Deal the four cards
        temp.dealFour(cols);

        // Assert that each column is empty
        assertEquals(true, a1.isEmpty());
        assertEquals(true, a2.isEmpty());
        assertEquals(true, a3.isEmpty());
        assertEquals(true, a4.isEmpty());
    }
}