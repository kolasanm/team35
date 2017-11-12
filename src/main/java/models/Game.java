package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);
    public Deck deck;

    public Game(){
        // initialize a new game such that each column can store card
        deck = new Deck();

        for(int i=0; i<4; i++){
            cols.add(new ArrayList<Card>());
        }
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns

        int beforeSize = 52;
        System.out.println("Size of deck before deal is" + beforeSize);     //find the initial size of the deck

        for(int i = 0; i < 4; i++)
        {
            //get topmost card from deck
            Card topCard = deck.cards.get(0);        //remove the card from the deck

            addCardToCol(i, topCard);       //add topmost card from deck into a column

            deck.cards.remove(0);

        }

        int afterSize = deck.cards.size();
        System.out.println("Size of deck after deal is" + afterSize);       //the new size of the deck should be 4 less
    }

    public void remove(int columnNumber) {
        // Implemented by Bharath P.
        // remove the top card from the indicated columns

            if(columnHasCards(columnNumber)) {
                if(isCardRemovable(getTopCard(columnNumber)) == true){
                    removeCardFromCol(columnNumber);
                }
                else{
                    System.out.println("---Sorry you can't remove this card---");
                }
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
            if (moveCard.getValue() == 14) { // checks to see if the card is an Ace
                addCardToCol(columnTo, moveCard); // adds moveCard to "to" col
                removeCardFromCol(columnFrom); //removes the top card from the "from" col
            }
            else{
                System.out.println("You can only move Aces.");
            }
        }
        else {
            System.out.println("Cannot move card to unempty column.");
        }
    }

    public boolean isCardRemovable(Card tempCard)
    {
        for(int i = 0; i < 4; i++)
        {

            if(getTopCard(i).getSuit() == tempCard.getSuit() && getTopCard(i).getValue() > tempCard.getValue())
            {
                return true;
            }
        }
        return false;
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }

    }

