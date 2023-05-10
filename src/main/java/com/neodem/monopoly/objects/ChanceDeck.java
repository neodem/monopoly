package com.neodem.monopoly.objects;

/**
 * Created by : Vincent Fumo (vincent_fumo@cable.comcast.com)
 * Created on : 5/10/23
 */
public class ChanceDeck extends BaseDeck {
    public ChanceDeck() {
        addCard(new Card( CardType.ADV_GO, "Advance to Go (Collect $200)"));
        addCard(new Card( CardType.ADV_ILLINOIS, "Advance to Illinois Avenue. If you pass Go, collect $200"));
        addCard(new Card( CardType.ADV_STCHARLES, "Advance to St. Charles Place. If you pass Go, collect $200"));
        addCard(new Card( CardType.ADV_UTILITY, "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown."));
        addCard(new Card( CardType.ADV_RAILROAD, "Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled"));
        addCard(new Card( CardType.BASIC, "Bank pays you dividend of $50"));
        addCard(new Card( CardType.BASIC, "Get Out of Jail Free"));
        addCard(new Card( CardType.ADV_3, "Go Back 3 Spaces"));
        addCard(new Card( CardType.ADV_JAIL, "Go to Jail. Go directly to Jail, do not pass Go, do not collect $200"));
        addCard(new Card( CardType.BASIC, "Make general repairs on all your property. For each house pay $25. For each hotel pay $100"));
        addCard(new Card( CardType.BASIC, "Poor Tax $15"));
        addCard(new Card( CardType.ADV_READING, "Take a trip to Reading Railroad. If you pass Go, collect $200"));
        addCard(new Card( CardType.ADV_BOARDWALK, "Advance to Boardwalk"));
        addCard(new Card( CardType.BASIC, "You have been elected Chairman of the Board. Pay each player $50"));
        addCard(new Card( CardType.BASIC, "Your building loan matures.Collect $150"));
        shuffle();
    }

}