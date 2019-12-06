package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupOfCardsTest {

    @Test
    public void numCards() {
        // Create a new variable "temp" as GroupOfCards constructor
        GroupOfCards temp = new GroupOfCards();

        // Assert it is empty (as it should be)
        assertEquals(true, temp.isEmpty());

        // Add an ace into the group of cards
        Card randomCard = new Card(14, Card.Suit.Clubs);
        temp.addCard(randomCard);

        // Assert that the card added was indeed the "randomCard"
        assertEquals(randomCard, temp.getCard(0));

        // Compare prior result with our "numCards()" function
        assertEquals(1, temp.numCards());

        // Remove the card from the group of cards, so array now holds zero
        temp.removeCard(0);

        // Ensure numCards returns 0
        assertEquals(0, temp.numCards());
    }

    @Test
    public void isEmpty() {
        // Instantiate a new GroupOfCards variable
        GroupOfCards temp = new GroupOfCards();

        // Assert that it is empty (as it should be given the constructor doesn't assign
        // any values.
        assertEquals(true, temp.isEmpty());

        // Ensure the isEmpty method works, so we compare the empty array with "0"
        assertEquals(0, temp.numCards());
    }
}