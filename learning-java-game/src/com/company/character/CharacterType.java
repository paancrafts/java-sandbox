package com.company.character;

public enum CharacterType {
    WARRIOR, KNIGHT, WIZARD, HERO, GOBLIN, ORC, THIEF, DRAGON;

    public static CharacterType getRandom() {
        return values()[(int)(Math.random() * values().length)];
    }
}
