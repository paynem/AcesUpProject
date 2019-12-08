package models;

import org.junit.Test;

import java.lang.reflect.Field;

import static models.Card.Suit.Diamonds;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    // Test the getSuit function of Class Card ~ Acquired from the Sprint 4 Template
    public void getSuitTest() {
        Card c = new Card(5, Card.Suit.Clubs);
        assertEquals(Card.Suit.Clubs,c.getSuit());
    }

    @Test
    // Test the setSuit function of Class Card without using the gettor in the class.
    public void setSuitTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        Card c = new Card(5, Card.Suit.Clubs);

        //when
        c.setSuit(Diamonds);

        //then
        final Field field = c.getClass().getDeclaredField("suit");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(c), Diamonds);
    }

    @Test
    // Test the getValue function of Class Card
    public void getValueTest() {
        Card c = new Card(5, Card.Suit.Clubs);
        assertEquals(5,c.getValue());
    }

    @Test
    // Test the setValue function of Class Card without using the gettor in the class.
    public void setValueTest() throws NoSuchFieldException, IllegalAccessException {
        //given
        Card c = new Card(5, Card.Suit.Clubs);

        //when
        c.setValue(7);

        //then
        final Field field = c.getClass().getDeclaredField("value");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(c), 7);
    }

    @Test
    // Test the isCardJoker function of Class Card
    public void isCardJokerTRUETest() {
        //given
        Card c = new Card(5, Card.Suit.Jokera);

        //then
        assertTrue(c.isCardJoker());
    }

    @Test
    // Test the isCardJoker function of Class Card
    public void isCardJokerFALSETest() {
        //given
        Card c = new Card(5, Card.Suit.Clubs);

        //then
        assertFalse(c.isCardJoker());
    }

    @Test
    // Test the toString function of Class Card ~ Acquired from Sprint 4 Template
    public void testToString() {
        Card c = new Card(5, Card.Suit.Clubs);
        assertEquals("5Clubs",c.toString());
    }
}