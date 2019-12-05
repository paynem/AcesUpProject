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
    public void testFinalDeal()
    {
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

        //deal 4 cards for the first 13 tests, the 14th should only deal 2 cards to the first 2 columns
        for(int i = 0; i < 14; i++)
        {
            temp.dealFour(cols);
        }

        assertEquals(14, a1.numCards());
        assertEquals(14, a2.numCards());
        assertEquals(13, a3.numCards());
        assertEquals(13, a4.numCards());
    }
}