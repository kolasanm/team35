package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testGame {

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
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        assertEquals(52,g.deck.cards.size());
    }

    @Test
    public void testGameBuildDeckFalse(){
        Game g = new Game();
        assertNotEquals(43,g.deck.cards.size());
    }

    @Test
    public void testDealFour(){
        Game g = new Game();
        assertEquals(4,g.deck.dealFour().size());
    }

    @Test
    public void testDealFourFalse(){
        Game g = new Game();
        assertNotEquals(56,g.deck.dealFour().size());
    }

    @Test
    public void testGameShuffle(){
        Game g1 = new Game();
        g1.deck.shuffle();
        Game g2 = new Game();
        g2.deck.shuffle();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.deck.cards.toArray(),g2.deck.cards.toArray()));
    }

    @Test
    public void testGameStart(){
        Game g = new Game();
        g.deck.shuffle();
        g.dealFour();
        assertEquals(1,g.columns.get(0).cards.size());
        assertEquals(1,g.columns.get(1).cards.size());
        assertEquals(1,g.columns.get(2).cards.size());
        assertEquals(1,g.columns.get(3).cards.size());
    }

    @Test
    public void testGameStartFalse(){
        Game g = new Game();
        g.deck.shuffle();
        g.dealFour();
        assertNotEquals(5,g.columns.get(0).cards.size());
        assertNotEquals(6,g.columns.get(1).cards.size());
        assertNotEquals(3,g.columns.get(2).cards.size());
        assertNotEquals(8,g.columns.get(3).cards.size());
    }

    @Test
    public void testCustomDeal(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        assertEquals("2Clubs",g.columns.get(0).cards.get(0).toString());
        assertEquals("3Clubs",g.columns.get(1).cards.get(0).toString());
        assertEquals("4Clubs",g.columns.get(2).cards.get(0).toString());
        assertEquals("5Clubs",g.columns.get(3).cards.get(0).toString());
    }
    @Test
    public void testCustomDealFalse(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        assertNotEqualsString("6Clubs",g.columns.get(0).cards.get(0).toString());
        assertNotEqualsString("4Spades",g.columns.get(1).cards.get(0).toString());
        assertNotEqualsString("7Hearts",g.columns.get(2).cards.get(0).toString());
        assertNotEqualsString("9Spades",g.columns.get(3).cards.get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.columns.get(2).cards.size());
    }
    @Test
    public void testRemoveFunctionFalse(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertNotEquals(7,g.columns.get(2).cards.size());
    }

}
