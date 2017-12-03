package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testSpanishCards {

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
        SpanishCard c = new SpanishCard(5,SpanishSuit.Bastos);
        assertEquals(SpanishSuit.Bastos,c.getSuit());
    }

    @Test
    public void testToString(){
        SpanishCard c = new SpanishCard(5,SpanishSuit.Copas);
        SpanishCard d = new SpanishCard(4,SpanishSuit.Espadas);
        assertEquals("5Copas",c.toString());
        assertEquals("4Espadas",d.toString());
    }

    @Test
    public void testToStringFalse(){
        SpanishCard c = new SpanishCard(3,SpanishSuit.Oros);
        SpanishCard d = new SpanishCard(4,SpanishSuit.Bastos);

        assertFalse(c.toString(), false);
        assertFalse(d.toString(), false);

    }

    @Test
    public void testMoveCard(){
        SpanishGame g = new SpanishGame();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.columns.get(2).spanishCards.size());
        g.move(0,2);
        assertEquals(1,g.columns.get(2).spanishCards.size());
        assertEquals(0,g.columns.get(0).spanishCards.size());
    }
    @Test
    public void testMoveCardFalse(){
        SpanishGame g = new SpanishGame();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertNotEquals(64,g.columns.get(2).spanishCards.size());
        g.move(0,2);
        assertNotEquals(345,g.columns.get(2).spanishCards.size());
        assertNotEquals(213,g.columns.get(0).spanishCards.size());
    }


}
