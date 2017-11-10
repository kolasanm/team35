package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public Column[] columns = new Column[4];
    public Deck deck;

    public Game(){
        // initialize a new game such that each column can store card
        deck = new Deck();
        //public ArrayList<Column> columns = new ArrayList<Column>(4);
        for(int i=0; i<4; i++){
            columns[i] = new Column();
        }
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns

        int beforeSize = 52;
        System.out.println("Size of deck before deal is" + beforeSize);     //find the initial size of the deck

        for(int i = 0; i < 4; i++)
        {
                //get topmost card from deck
            System.out.println("in deal 4 loop");
            Card topCard = deck.cards.get(0);        //remove the card from the deck

            columns[i].addCard(topCard);       //add topmost card from deck into a column

            deck.cards.remove(0);

        }

        int afterSize = deck.cards.size();
        System.out.println("Size of deck after deal is" + afterSize);       //the new size of the deck should be 4 less
    }

    public void remove(int columnNumber) {
        // Implemented by Bharath P.
        // remove the top card from the indicated columns

        boolean cardRem = false;

        if(columnNumber > 4 || columnNumber < 0){
            System.out.println("--Invalid Column Number--");
        }
        else {
            Card tempCard = columns[columnNumber].getTopCard();
            cardRem = isCardRemovable(tempCard);
        }

        if(columnHasCards(columnNumber) == false || cardRem == false){
            System.out.println("Sorry Can't Remove that Card");
        }
        else{
            columns[columnNumber].removeCard();
        }

    }

    private boolean columnHasCards(int columnNumber) {
        // Implemented by Bharath P.
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if (columns[columnNumber].colHasCards() == false){
            return false;
        } else {
            return true;
        }
    }

    private Card getTopCard(int columnNumber) {
        if(columnNumber > 4 || columnNumber < 0){
            System.out.println("--Invalid Column Number--");
            return null;
        }
        else{
            return columns[columnNumber].col.get(columns[columnNumber].col.size()-1);
        }
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (columnHasCards(columnTo) == false)
        {
            Card moveCard = getTopCard(columnFrom); //gets top card
            if (moveCard.getValue() == 14) { // checks to see if the card is an Ace
                //addCardToCol(columnTo, moveCard); // adds moveCard to "to" col
                //removeCardFromCol(columnFrom); //removes the top card from the "from" col
                columns[columnTo].addCard(moveCard);
                columns[columnFrom].removeCard();
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

            if(tempCard.suit == columns[i].getTopCard().suit && tempCard.value < columns[i].getTopCard().value)
            {
                return true;
            }
        }
        return false;
    }

    }

