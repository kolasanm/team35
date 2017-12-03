package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testEnglishDeck {

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
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void shuffle(){
        Game g1 = new Game();
        g1.deck.shuffle();
        Game g2 = new Game();
        g2.deck.shuffle();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.deck.cards.toArray(),g2.deck.cards.toArray()));
    }

    @Test
    public void dealFour(){
        Game g = new Game();
        assertEquals(4,g.deck.dealFour().size());
    }
    @Test
    public void dealFourFalse(){
        Game g = new Game();
        assertNotEquals(5,g.deck.dealFour().size());
    }


}