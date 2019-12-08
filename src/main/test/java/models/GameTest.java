package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getDealPile() {
        // Create a new game, which assigns a deal pile
        Game g = new Game();

        // See if the accessor returns the same deal pile as the one instantiated
        assertEquals(g.dealPile, g.getDealPile());
    }

    @Test
    public void getColumns() {
        // Create a new game, which assigns a column array
        Game g = new Game();

        // See if the accessor returns the same array column as the one instantiated
        assertEquals(g.cols, g.getColumns());
    }

    @Test
    public void getDiscardPile() {
        // Create a new game, which assigns a discard pile
        Game g = new Game();

        // See if the accessor returns the same discard pile as the one instantiated
        assertEquals(g.discardPile, g.getDiscardPile());
    }
}