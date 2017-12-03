package models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class testSpanishGame {

    //implemented by Bharath P.

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


    public void assertNotEqualsString(String a, String b)
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
    public void testGameCreation(){
        SpanishGame s = new SpanishGame();
        assertNotNull(s);
    }

    @Test
    public void testGameBuildDeck(){
        SpanishGame g = new SpanishGame();
        assertEquals(50,g.deck.cards.size());
    }
    @Test
    public void testGameBuildDeckFalse(){
        SpanishGame g = new SpanishGame();
        assertNotEquals(456,g.deck.cards.size());
    }
    @Test
    public void testDealFour(){
        SpanishGame g = new SpanishGame();
        assertEquals(4,g.deck.dealQuattro().size());
    }
    @Test
    public void testDealFourFalse(){
        SpanishGame g = new SpanishGame();
        assertNotEquals(235,g.deck.dealQuattro().size());
    }

    @Test
    public void testGameStart(){
        SpanishGame g = new SpanishGame();
        g.deck.shuffle();
        g.dealFour();
        assertEquals(1,g.columns.get(0).spanishCards.size());
        assertEquals(1,g.columns.get(1).spanishCards.size());
        assertEquals(1,g.columns.get(2).spanishCards.size());
        assertEquals(1,g.columns.get(3).spanishCards.size());
    }
    public void testGameStartFalse(){
        SpanishGame g = new SpanishGame();
        g.deck.shuffle();
        g.dealFour();
        assertNotEquals(3,g.columns.get(0).spanishCards.size());
        assertNotEquals(6,g.columns.get(1).spanishCards.size());
        assertNotEquals(4,g.columns.get(2).spanishCards.size());
        assertNotEquals(7,g.columns.get(3).spanishCards.size());
    }

    @Test
    public void testCustomDeal(){
        SpanishGame g = new SpanishGame();
        g.customDeal(0,3,6,9);
        assertEquals("1Bastos",g.columns.get(0).spanishCards.get(0).toString());
        assertEquals("2Bastos",g.columns.get(1).spanishCards.get(0).toString());
        assertEquals("3Bastos",g.columns.get(2).spanishCards.get(0).toString());
        assertEquals("4Bastos",g.columns.get(3).spanishCards.get(0).toString());
    }

    @Test
    public void testCustomDealFalse(){
        SpanishGame g = new SpanishGame();
        g.customDeal(0,3,6,9);
        assertNotEqualsString("1Oros",g.columns.get(0).spanishCards.get(0).toString());
        assertNotEqualsString("2Copas",g.columns.get(1).spanishCards.get(0).toString());
        assertNotEqualsString("3Comodines",g.columns.get(2).spanishCards.get(0).toString());
        assertNotEqualsString("4Espadas",g.columns.get(3).spanishCards.get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        SpanishGame g = new SpanishGame();
        g.customDeal(0,1,2,3);
        g.remove(2);
        assertEquals(0,g.columns.get(2).cards.size());
    }
    @Test
    public void testRemoveFunctionFalse(){
        SpanishGame g = new SpanishGame();
        g.customDeal(0,1,2,3);
        g.remove(2);
        assertNotEquals(8,g.columns.get(2).cards.size());
    }

    @Test
    public void testMovFromCol(){
        SpanishGame g = new SpanishGame();
        g.dealFour();
        g.move(0, 1);
        assertEquals(2, g.columns.get(1).spanishCards.size());
        assertEquals(0, g.columns.get(0).spanishCards.size());

    }
    @Test
    public void testMovFromColFalse(){
        SpanishGame g = new SpanishGame();
        g.dealFour();
        g.move(0, 1);
        assertNotEquals(3, g.columns.get(1).spanishCards.size());
        assertNotEquals(6, g.columns.get(0).spanishCards.size());

    }

}