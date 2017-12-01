package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SpanishDeck extends Deck{

    public java.util.List<SpanishCard> cards = new ArrayList<>();

    public SpanishDeck() {
        for(int i = 2; i < 14; i++){
            cards.add(new SpanishCard(i,SpanishSuit.Bastos));
            cards.add(new SpanishCard(i,SpanishSuit.Oros));
            cards.add(new SpanishCard(i,SpanishSuit.Copas));
            cards.add(new SpanishCard(i,SpanishSuit.Espadas));
        }

        for(int j = 14; j < 16; j++) {
            cards.add(new SpanishCard(j,SpanishSuit.Comodines));
            cards.add(new SpanishCard(j,SpanishSuit.Comodines));
        }

    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }


    public ArrayList<SpanishCard> dealQuattro() {
        System.out.println("Deal Quattro!");
        ArrayList<SpanishCard> four = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (cards.size() > 0) {
                four.add(cards.get(i));
                cards.remove(i);
            }
        }
        return four;
    }

}