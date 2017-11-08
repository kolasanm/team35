package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Column {

    private ArrayList<Card> col = new ArrayList<Card>();

    public Card getTopCard(){
        Card topCard = col.get(col.size()-1);
        return topCard;
    }

    public void addCard(Card tempCard){
        col.add(tempCard);
    }

    public void removeCard(){
        col.remove(col.size()-1);
    }

    public boolean colHasCards(){
        if(col.size() == 0)
        {
            return false;
        }
        else{
            return true;
        }
    }

}
