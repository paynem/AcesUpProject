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

    @Test
    public void moveNegative() {
        // Create two arbitrary columns
        Column a1 = new Column();
        Column a2 = new Column();

        // Assert both columns are empty
        assertEquals(true, a2.cards.isEmpty());
        assertEquals(true, a1.cards.isEmpty());

        // Create a temp card and add it to column "a1"
        Card randomCard = new Card(14, Card.Suit.Clubs);
        a1.cards.add(randomCard);

        Card randomCard1 = new Card(12, Card.Suit.Clubs);
        a2.cards.add(randomCard1);

        // Assert that columns "a1" and "a2" are not not empty
        assertEquals(false, a1.cards.isEmpty());
        assertEquals(false, a2.cards.isEmpty());
        // Move the card from "a1" to "a2"
        a1.move(a2);

        // Assert that column "a1" is not empty, and "a2" is empty
        assertEquals(false, a1.cards.isEmpty());

        // Assert that move was not successful and that cards in columns "a1" and "a2"
        // are not changed
        assertEquals(randomCard, a1.getCard(0));
        assertEquals(randomCard1, a2.getCard(0));
    }

    @Test
    public void discard() {
        // Create an array of 4 columns (to replicate what is done in Game.Java
        // constructor)

        java.util.ArrayList<Column> cols = new java.util.ArrayList<>(4);
        Column a1 = new Column();
        cols.add(a1);
        Column a2 = new Column();
        cols.add(a2);
        Column a3 = new Column();
        cols.add(a3);
        Column a4 = new Column();
        cols.add(a4);

        // Create a discardPile (so we have a place for the discarded card to go)
        SuccessPile discardPile = new SuccessPile();

        // Assert both columns are empty
        assertEquals(true, cols.get(0).cards.isEmpty());
        assertEquals(true, cols.get(1).cards.isEmpty());
        assertEquals(true, cols.get(2).cards.isEmpty());
        assertEquals(true, cols.get(3).cards.isEmpty());

        // Assert that discardPile is empty
        assertEquals(true, discardPile.isEmpty());

        // Create a temp card and add it to column "0"
        Card randomCard = new Card(9, Card.Suit.Clubs);
        cols.get(0).addCard(randomCard);
        Card randomCard1 = new Card(10, Card.Suit.Clubs);
        cols.get(1).addCard(randomCard1);
        // Assert that columns 1 and 0 are not empty
        assertEquals(false, cols.get(0).isEmpty());
        assertEquals(false, cols.get(1).isEmpty());

        // Discard card in column 0 off of card in column 1
        cols.get(0).discard(cols, discardPile);
        // Assert that column is now empty, and that discardPile is not empty
        assertEquals(true, cols.get(0).isEmpty());
        assertEquals(false, discardPile.isEmpty());

        // Assert that the discard was successful and card from column 0 is in
        // discardPile
        assertEquals(randomCard, discardPile.getCard(0));
    }

    @Test
    public void discardNegative() {
        // Create an array of 4 columns (to replicate what is done in Game.Java
        // constructor)

        java.util.ArrayList<Column> cols = new java.util.ArrayList<>(4);
        Column a1 = new Column();
        cols.add(a1);
        Column a2 = new Column();
        cols.add(a2);
        Column a3 = new Column();
        cols.add(a3);
        Column a4 = new Column();
        cols.add(a4);

        // Create a discardPile (so we have a place for the discarded card to go)
        SuccessPile discardPile = new SuccessPile();

        // Assert both columns are empty
        assertEquals(true, cols.get(0).cards.isEmpty());
        assertEquals(true, cols.get(1).cards.isEmpty());
        assertEquals(true, cols.get(2).cards.isEmpty());
        assertEquals(true, cols.get(3).cards.isEmpty());

        // Assert that discardPile is empty
        assertEquals(true, discardPile.isEmpty());

        // Create a temp card and add it to column "0"
        Card randomCard = new Card(9, Card.Suit.Clubs);
        cols.get(0).addCard(randomCard);
        Card randomCard1 = new Card(8, Card.Suit.Clubs);
        cols.get(1).addCard(randomCard1);

        // Assert that columns 1 and 0 are not empty
        assertEquals(false, cols.get(0).isEmpty());
        assertEquals(false, cols.get(1).isEmpty());

        // Try to Discard card in column 0 off of card in column 1
        cols.get(0).discard(cols, discardPile);
        // Assert that column still has its card, and that the discardPile is still
        // empty
        assertEquals(false, cols.get(0).isEmpty());
        assertEquals(true, discardPile.isEmpty());

        // Assert that the discard was not successful and card from column 0 is still in
        // column 0
        assertEquals(randomCard, cols.get(0).getCard(0));
    }
}