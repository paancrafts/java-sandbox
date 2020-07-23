package com.company.character;

import com.company.Direction;
import com.company.item.Inventory;

public class Player extends Character {
    private static double health;
    private Direction direction = Direction.UP;
    private Inventory inventory;

    public Player(String name) {
        super(name, "X");
        health = 20;
        this.inventory = new Inventory();
    }

    public static double getHealth() {
        return health;
    }

    public Inventory getPlayerInventory() { return inventory; }

    private static void setHealth(double health) {
        Player.health = health;
    }

    public static void setFullHealth() {
        Player.setHealth(20);
    }

    public static void takeHealth() {
        Player.setHealth(Player.getHealth() - 1);
    }

    public void changeDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        switch (this.direction) {
            case UP:
                setyCoord(getyCoord() - 1);
                break;
            case DOWN:
                setyCoord(getyCoord() + 1);
                break;
            case LEFT:
                setxCoord(getxCoord() - 1);
                break;
            case RIGHT:
                setxCoord(getxCoord() + 1);
                break;
        }
    }
}
