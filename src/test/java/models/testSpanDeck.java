package models;

import models.Game;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testSpanishDeck {

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

    @Test
    public void testGameCreation(){
        SpanishGame s = new SpanishGame();
        assertNotNull(s);
    }

    @Test
    public void testShuffle(){
        SpanishGame s1 = new SpanishGame();
        s1.deck.shuffle();
        SpanishGame s2 = new SpanishGame();
        s2.deck.shuffle();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(s1.deck.cards.toArray(),s2.deck.cards.toArray()));
    }

    @Test
    public void testDealQuattro(){
        SpanishGame s = new SpanishGame();
        assertEquals(4,s.deck.dealQuattro().size());
    }
    public void testDealQuattroFalse(){
        SpanishGame s = new SpanishGame();
        assertNotEquals(5,s.deck.dealFour().size());
    }
}