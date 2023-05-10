package com.neodem.monopoly.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * a monopoly board represntation
 * Created by : Vincent Fumo (vincent_fumo@cable.comcast.com)
 * Created on : 5/10/23
 */
public class Board {

    private final BaseDeck chanceDeck = new ChanceDeck();
    private final BaseDeck communityDeck = new CommunityDeck();

    /**
     * the spaces
     */
    private final Map<SpaceName, Space> spaces = new HashMap<>();

    /**
     * the spaces (in order)
     */
    private final Map<Space, Integer> orderedSpaces = new HashMap<>();
    private final Map<Integer, Space> spacesInLocations = new HashMap<>();
    private final Map<Space, Integer> spaceHitCount = new HashMap<>();

    private final Map<Player, Space> playerLocation = new HashMap<>();

    private void addNextSpace(String name, int index) {
        Space space = new Space(name);
        spaces.put(space.spaceName(), space);
        orderedSpaces.put(space, index);
        spacesInLocations.put(index, space);

        // we do not count the starting spot (Go) when the players enter the board
        spaceHitCount.put(space, 0);
    }

    public Board() {
        addNextSpace("Go", 0);
        addNextSpace("Mediterranean", 1);
        addNextSpace("Community Chest 1", 2);
        addNextSpace("Baltic", 3);
        addNextSpace("Income Tax", 4);
        addNextSpace("Reading RR", 5);
        addNextSpace("Oriental", 6);
        addNextSpace("Chance 1", 7);
        addNextSpace("Vermont", 8);
        addNextSpace("Connecticut", 9);
        addNextSpace("Jail", 10);
        addNextSpace("St. Charles", 11);
        addNextSpace("Electric Company", 12);
        addNextSpace("States", 13);
        addNextSpace("Virginia", 14);
        addNextSpace("Pennsylvania RR", 15);
        addNextSpace("St. James", 16);
        addNextSpace("Community Chest 2", 17);
        addNextSpace("Tennessee", 18);
        addNextSpace("New York", 19);
        addNextSpace("Free Parking", 20);
        addNextSpace("Kentucky", 21);
        addNextSpace("Chance 2", 22);
        addNextSpace("Indiana", 23);
        addNextSpace("Illinois", 24);
        addNextSpace("BO RR", 25);
        addNextSpace("Atlantic", 26);
        addNextSpace("Ventnor", 27);
        addNextSpace("Water Works", 28);
        addNextSpace("Marvin Gardens", 29);
        addNextSpace("Go to Jail", 30);
        addNextSpace("Pacific", 31);
        addNextSpace("N. Carolina", 32);
        addNextSpace("Community Chest 2", 33);
        addNextSpace("Pennsylvania", 34);
        addNextSpace("Short Line RR", 35);
        addNextSpace("Chance 3", 36);
        addNextSpace("Park Place", 37);
        addNextSpace("Luxury Tax", 38);
        addNextSpace("Boardwalk", 39);
    }

    public void addPlayer(Player player) {
        playerLocation.put(player, spaces.get(SpaceName.Go));
    }


    /**
     * this does not consider chance/community chest/go to jail/etc (yet)
     *
     * @param player
     * @param spacesToMove
     * @return
     */
    public Space playerMove(Player player, int spacesToMove) {
        Space currentSpace = playerLocation.get(player);

        // is player in jail?

        int index = orderedSpaces.get(currentSpace);
        int newLocation = index + spacesToMove;
        if (newLocation > 39) newLocation = newLocation - 40;
        Space newSpace = spacesInLocations.get(newLocation);

        // check if newSpace is chance/community chest
        if (
                newSpace.spaceName() == SpaceName.Chance1 || newSpace.spaceName() == SpaceName.Chance2 || newSpace.spaceName() == SpaceName.Chance3
        ) {
            Card nextCard = chanceDeck.getNextCard();
            newSpace = handleCard(newSpace, nextCard);
        } else if (
                newSpace.spaceName() == SpaceName.CommunityChest1 || newSpace.spaceName() == SpaceName.CommunityChest2 || newSpace.spaceName() == SpaceName.CommunityChest3
        ) {
            Card nextCard = communityDeck.getNextCard();
            newSpace = handleCard(newSpace, nextCard);
        }
        // check if newSpace is goToJail

        movePlayerTo(player, newSpace);
        return newSpace;
    }

    private Space handleCard(Space newSpace, Card nextCard) {
        if (nextCard.type() != CardType.BASIC) {
            switch (nextCard.type()) {
                case ADV_GO:
                    newSpace = spaces.get(SpaceName.Go);
                    break;
                case ADV_ILLINOIS:
                    newSpace = spaces.get(SpaceName.Illinois);
                    break;
                case ADV_STCHARLES:
                    newSpace = spaces.get(SpaceName.StCharles);
                    break;
                case ADV_RAILROAD:
                    break;
                case ADV_UTILITY:
                    break;
                case ADV_3:
                    break;
                case ADV_JAIL:
                    newSpace = spaces.get(SpaceName.Jail);
                    break;
                case ADV_READING:
                    newSpace = spaces.get(SpaceName.ReadingRR);
                    break;
                case ADV_BOARDWALK:
                    newSpace = spaces.get(SpaceName.Boardwalk);
                    break;
            }
        }
        return newSpace;
    }

    private void movePlayerTo(Player player, Space newSpace) {
        playerLocation.put(player, newSpace);
        Integer index = spaceHitCount.get(newSpace);
        spaceHitCount.put(newSpace, index + 1);
    }

    public void report() {
        List<Map.Entry<Space, Integer>> list = new ArrayList<>(spaceHitCount.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Space, Integer> e : list) {
            System.out.printf("%s : %d%n", e.getKey().spaceName(), e.getValue());
        }
    }
}
