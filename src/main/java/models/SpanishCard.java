package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by michaelhilton on 1/25/16.
 */

public class SpanishCard implements Serializable {
    public final int value;
    public final SpanishSuit suit;

    @JsonCreator
    public SpanishCard(@JsonProperty("value") int value, @JsonProperty("suit") SpanishSuit suit) {
        this.value = value;
        this.suit = suit;

    }

    public SpanishSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return this.value + this.suit.toString();
    }
}