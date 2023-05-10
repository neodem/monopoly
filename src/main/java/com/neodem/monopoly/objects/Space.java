package com.neodem.monopoly.objects;

/**
 * Represents a Space (like Boardwalk or Chance, or Go)
 *
 * Created by : Vincent Fumo (vincent_fumo@cable.comcast.com)
 * Created on : 5/10/23
 */
public record Space(String name, SpaceName spaceName) {
    public Space(String name, SpaceName spaceName) {
        this.name = name;
        this.spaceName = spaceName;
    }

    public Space(String name) {
        this(name, SpaceName.of(name));
    }
}
