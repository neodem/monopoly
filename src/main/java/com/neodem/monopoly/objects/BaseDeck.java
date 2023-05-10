package com.neodem.monopoly.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : Vincent Fumo (vincent_fumo@cable.comcast.com)
 * Created on : 5/10/23
 */
public abstract class BaseDeck {

    private List<Card> deck = new ArrayList<>();

    protected void addCard(Card card) {
        deck.add(card);
    }

    protected void shuffle() {

    }

    /*
    will return a copy of the card and put the actual card on the bottom of the deck
     */
    protected Card getNextCard() {
        return null;
    }
}
