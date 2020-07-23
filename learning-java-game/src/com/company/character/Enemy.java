package com.company.character;

public class Enemy extends Character {
    private static double health;
    private CharacterType characterType;

    public Enemy(String name) {
        super(name, "Z");
        reboost();
    }

    public static double getHealth() {
        return health;
    }

    public static void setHealth(double health) {
        Enemy.health = health;
    }

    public CharacterType getCharacterType() { return characterType; }

    public void reboost() {
        this.characterType = CharacterType.getRandom();
        switch (this.characterType) {
            case WIZARD:
                Enemy.health = 10;
                break;
            case WARRIOR:
                Enemy.health = 5;
                break;
            case ORC:
                Enemy.health = 4;
                break;
            case THIEF:
                Enemy.health = 3;
                break;
            case GOBLIN:
                Enemy.health = 8;
                break;
            case HERO:
                Enemy.health = 6;
                break;
            case DRAGON:
                Enemy.health = 13;
                break;
            case KNIGHT:
                Enemy.health = 9;
                break;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ". Tüüp: " + characterType;
    }

}
