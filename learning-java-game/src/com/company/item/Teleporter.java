package com.company.item;

import com.company.character.Enemy;

public class Teleporter extends Item {
    private static double strength = 0.5;

    public Teleporter() {
        super("Teleporter", strength, 1);
    }

    public void teleport() {
        System.out.println("You used the teleporter to escape a possible fight.");
    }
}
