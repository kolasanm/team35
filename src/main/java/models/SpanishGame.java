package models;

import java.util.ArrayList;

public class SpanishGame extends Game {

    public SpanishDeck deck = new SpanishDeck();
    public java.util.List<Column> columns = new ArrayList<>();

    public SpanishGame(){
        columns.add(new Column(1));
        columns.add(new Column(2));
        columns.add(new Column(3));
        columns.add(new Column(4));
    }

    public void dealFour() {
        ArrayList<SpanishCard> deal = deck.dealQuattro();
        for (int i = 0; i < deal.size(); i++) {
            SpanishCard s = deal.get(i);
            columns.get(i).spanishCards.add(s);
        }
    }

    //customDeal to setup game for testing purposes (i.e. shuffled cards are random and hard to test)
    public void customDeal(int c1, int c2, int c3, int c4) {
        columns.get(0).spanishCards.add(deck.cards.get(c1));
        deck.cards.remove(c1);
        columns.get(1).spanishCards.add(deck.cards.get(c2));
        deck.cards.remove(c2);
        columns.get(2).spanishCards.add(deck.cards.get(c3));
        deck.cards.remove(c3);
        columns.get(3).spanishCards.add(deck.cards.get(c4));
        deck.cards.remove(c4);
    }


    public void remove(int columnNumber) {
        if(columnHasCards(columnNumber)) {
            SpanishCard s = getTopCard(columnNumber);
            boolean removeCard = false;
            boolean hasJoker = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        SpanishCard compare = getTopCard(i);
                        if(compare.value == 13) {
                            hasJoker = true;
                            this.columns.get(i).spanishCards.remove(this.columns.get(i).spanishCards.size() - 1);
                        }
                        if(!hasJoker) {
                            if (compare.getSuit() == s.getSuit()) {
                                if (compare.getValue() > s.getValue()) {
                                    removeCard = true;
                                }
                            }
                        }
                        else{
                            removeCard = true;
                        }
                    }
                }
            }
            if (removeCard) {
                this.columns.get(columnNumber).spanishCards.remove(this.columns.get(columnNumber).spanishCards.size() - 1);
            }
        }
    }


    private boolean columnHasCards(int columnNumber) {
        if (this.columns.get(columnNumber).spanishCards.size()>0) {
            return true;
        }
        return false;
    }


    private SpanishCard getTopCard(int columnNumber) {
        return this.columns.get(columnNumber).spanishCards.get(this.columns.get(columnNumber).spanishCards.size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        SpanishCard cardToMove = getTopCard(columnFrom);
        this.removeCardFromCol(columnFrom);
        this.addCardToCol(columnTo,cardToMove);
    }

    private void addCardToCol(int columnTo, SpanishCard cardToMove) {
        columns.get(columnTo).spanishCards.add(cardToMove);
    }


    private void removeCardFromCol(int colFrom) {
        this.columns.get(colFrom).spanishCards.remove(this.columns.get(colFrom).spanishCards.size()-1);
    }

}