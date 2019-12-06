package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    // Test the getSuit function of Class Card ~ Acquired from the Sprint 4 Template
    public void getSuit() {
        Card c = new Card(5, Card.Suit.Clubs);
        assertEquals(Card.Suit.Clubs,c.getSuit());
    }

    @Test
    // Test the toString function of Class Card ~ Acquired from Sprint 4 Template
    public void testToString() {
        Card c = new Card(5, Card.Suit.Clubs);
        assertEquals("5Clubs",c.toString());
    }
}