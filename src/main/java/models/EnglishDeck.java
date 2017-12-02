package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class EnglishDeck extends Deck{

    public java.util.List<Card> cards = new ArrayList<>();

    public EnglishDeck() {
        for(int i = 2; i < 15; i++){
            cards.add(new Card(i,Suit.Clubs));
            cards.add(new Card(i,Suit.Hearts));
            cards.add(new Card(i,Suit.Diamonds));
            cards.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        System.out.println("in english shuffle");
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    public ArrayList<Card> dealFour() {
        System.out.println("in english deal four");
        ArrayList<Card> four = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                if (cards.size() > 0) {
                    four.add(cards.get(0));
                    cards.remove(0);
            }
        }
        return four;
    }
}