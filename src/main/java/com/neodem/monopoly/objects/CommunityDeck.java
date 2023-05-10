package com.neodem.monopoly.objects;

/**
 * Created by : Vincent Fumo (vincent_fumo@cable.comcast.com)
 * Created on : 5/10/23
 */
public class CommunityDeck extends BaseDeck {
    public CommunityDeck() {
        addCard(new Card(CardType.ADV_GO, "Advance to Go (Collect $200)"));
        addCard(new Card(CardType.BASIC, "Bank error in your favor. Collect $200"));
        addCard(new Card(CardType.BASIC, "Doctor’s fee. Pay $50"));
        addCard(new Card(CardType.BASIC, "From sale of stock you get $50"));
        addCard(new Card(CardType.BASIC, "Get Out of Jail Free"));
        addCard(new Card(CardType.ADV_JAIL, "Go to Jail. Go directly to jail, do not pass Go, do not collect $200"));
        addCard(new Card(CardType.BASIC, "Holiday fund matures. Receive $100"));
        addCard(new Card(CardType.BASIC, "Income tax refund. Collect $20"));
        addCard(new Card(CardType.BASIC, "It is your birthday. Collect $10 from every player"));
        addCard(new Card(CardType.BASIC, "Life insurance matures. Collect $100"));
        addCard(new Card(CardType.BASIC, "Pay hospital fees of $100"));
        addCard(new Card(CardType.BASIC, "Pay school fees of $50"));
        addCard(new Card(CardType.BASIC, "Receive for services $25"));
        addCard(new Card(CardType.BASIC, "You are assessed for street repair. $40 per house. $115 per hotel"));
        addCard(new Card(CardType.BASIC, "You have won second prize in a beauty contest. Collect $10"));
        addCard(new Card(CardType.BASIC, "You inherit $100"));
        shuffle();
    }
}
