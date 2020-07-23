package com.company.item;

import com.company.character.Enemy;

public class Boot extends Item implements Weapon {
    private static double strength = 1.5;

    public Boot() {
        super("Saabas", strength, 10);
    }

    @Override
    public void hit() {
       double healthLeft = Enemy.getHealth() - strength * randomStrength();
       Enemy.setHealth(healthLeft);
        System.out.println("Lõid saapaga");
    }

    private double randomStrength() {
        return (Math.random() * ((2 - 0.5) + 1)) + 0.5;
    }
}
