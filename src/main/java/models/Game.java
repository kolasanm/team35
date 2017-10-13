package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++)
        {
            java.util.List<Card> newCardList = new ArrayList<>(); // creates an empty new list of Cards and allocates to heap
            cols.set(i, newCardList); // sets the column to point to the new ArrayList of Cards
        }
    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns

        int beforeSize = deck.size();
        System.out.println("Size of deck before deal is" + beforeSize);     //find the initial size of the deck

        for(int i = 0; i < 4; i++)
        {
            Card topCard = deck.get(0);     //get topmost card from deck

            deck.remove(0);           //remove the card from the deck

            addCardToCol(i, topCard);       //add topmost card from deck into a column

        }

        int afterSize = deck.size();
        System.out.println("Size of deck after deal is" + afterSize);       //the new size of the deck should be 4 less
    }

    public void remove(int columnNumber) {
        // Implemented by Bharath P.
        // remove the top card from the indicated columns
        if(columnHasCards(columnNumber)) {
            this.cols.get(columnNumber).remove(getTopCard(columnNumber));
        } else {
            // output if columnHasCards returns false
            System.out.println("---Sorry you can't remove from an empty column---");
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // Implemented by Bharath P.
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if (this.cols.get(columnNumber).isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (!columnHasCards(columnTo))
        {
            Card moveCard = getTopCard(columnFrom); //gets top card
            addCardToCol(columnTo, moveCard); // adds moveCard to "to" col
            removeCardFromCol(columnFrom); //removes the top card from the "from" col
        }
        else
            System.out.println("Cannot move card to unempty column.");
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
