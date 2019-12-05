package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnTest {

    @Test
    public void move() {
        //  Create two arbitrary columns
        Column a1 = new Column();
        Column a2 = new Column();

        // Assert both columns are empty
        assertEquals(true, a2.cards.isEmpty());
        assertEquals(true, a1.cards.isEmpty());

        // Create a temp card and add it to column "a1"
        Card randomCard = new Card(14, Card.Suit.Clubs);
        a1.cards.add(randomCard);

        // Assert that column "a1" is not not empty
        assertEquals(false, a1.cards.isEmpty());

        // Move the card from "a1" to "a2"
        a1.move(a2);

        // Assert that column "a1" is now empty, and "a2" holds the randomCard
        assertEquals(true, a1.cards.isEmpty());
        assertEquals(false, a2.cards.isEmpty());

        // Assert that the move was successful from column "a1" to column "a2"
        assertEquals(randomCard, a2.getCard(0));
    }
}