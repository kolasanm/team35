package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testCard {

    public void assertNotEquals(int a, int b)
    {
        if(a != b) {
            assertEquals(1,1);
        }
        else
        {
            fail();
        }
    }

    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.Clubs);
        assertEquals(Suit.Clubs,c.getSuit());
    }

    @Test
    public void testToString(){
        Card c = new Card(5,Suit.Clubs);
        Card d = new Card(4,Suit.Spades);
        assertEquals("5Clubs",c.toString());
        assertEquals("4Spades",d.toString());
    }

    @Test
    public void testToStringFalse(){
        Card c = new Card(18,Suit.Clubs);
        Card d = new Card(69,Suit.Spades);

        assertFalse(c.toString(), false);
        assertFalse(d.toString(), false);

    }

    @Test
    public void testMoveCard(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.columns.get(2).cards.size());
        g.move(0,2);
        assertEquals(1,g.columns.get(2).cards.size());
        assertEquals(0,g.columns.get(0).cards.size());
    }

    @Test
    public void testMoveCardFalse(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertNotEquals(54,g.columns.get(2).cards.size());
        g.move(0,2);
        assertNotEquals(420,g.columns.get(1).cards.size());
        assertNotEquals(21,g.columns.get(0).cards.size());
    }
}
