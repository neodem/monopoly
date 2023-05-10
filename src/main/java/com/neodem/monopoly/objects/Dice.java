package com.neodem.monopoly.objects;

import java.util.Random;

/**
 * Created by : Vincent Fumo (vincent_fumo@cable.comcast.com)
 * Created on : 5/10/23
 */
public class Dice {

    int die1 = 0;
    int die2 = 0;

    private final Random rand = new Random();

    public void roll() {
        die1 = rnd();
        die2 = rnd();
    }

    private int rnd() {
        return rand.nextInt(6) + 1;
    }

    public int spaces() {
        return die1 + die2;
    }

    public boolean isDoubles() {
        return die1 == die2;
    }
}
