package com.neodem.monopoly.engine;

import com.neodem.monopoly.objects.Board;
import com.neodem.monopoly.objects.Dice;
import com.neodem.monopoly.objects.Player;

/**
 * Created by : Vincent Fumo (vincent_fumo@cable.comcast.com)
 * Created on : 5/10/23
 */
public class BasicEngine implements Engine {

    private final Board board;

    private final Dice dice;

    public BasicEngine(Board board) {
        this.board = board;
        dice = new Dice();
    }

    private final int TURNS = 10000;

    @Override
    public void start() {
        Player player = new Player("player");
        board.addPlayer(player);

        for(int i=0; i<TURNS; i++)
            movePlayer(player);

        board.report();
    }

    private void movePlayer(Player player) {
        dice.roll();
        int spaces = dice.spaces();

        board.playerMove(player, spaces);

        if(dice.isDoubles()) {
            // roll again?
        }
    }
}
