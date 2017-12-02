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
        if (cards.size() >= 4) {
            for (int i = 0; i < 4; i++) {
                four.add(cards.get(i));
                cards.remove(i);
                System.out.println("size of deck" + cards.size());
            }
        }
        System.out.println("size of four " + four.size());
        return four;
    }
}