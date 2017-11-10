package models;

import java.util.ArrayList;

public class Deck {

    public java.util.List<Card> cards = new ArrayList<>(); // 'cards' is the array of cards

    public Deck() {

        //builds the deck
        for (int i = 2; i < 15; i++) {
            cards.add(new Card(i, Suit.Clubs));
            cards.add(new Card(i, Suit.Hearts));
            cards.add(new Card(i, Suit.Diamonds));
            cards.add(new Card(i, Suit.Spades));
        }

        //shuffles the deck
        for (int i = 0; i < 51; i++) {
            int random = i + (int) (Math.random() * (52 - i)); //Randomly generates a number from 1 - 51
            Card temp = cards.get(random); //Initialize a temp variable that stores the position of a card
            cards.set(random, cards.get(i)); //Switch the card
            cards.set(i, temp); //Store the card in index i in temp
        } //Run through 52 iterations

        for (int i = 0; i < 52; i++) {
            System.out.println(cards.get(i)); //Print out the deck to test the shuffle function
        }
    }
}
