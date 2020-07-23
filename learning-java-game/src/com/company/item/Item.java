package com.company.item;

import com.company.World;
import com.company.WorldObject;

public class Item implements WorldObject {
    private int xCoord;
    private int yCoord;

    private String name;
    private double strength;
    private int endurance;
    private int level;
    private ItemType itemType;

    public Item(String name, double strength, int endurance) {
        randomiseCoordinates();
        this.name = name;
        this.itemType = ItemType.STANDARD;
        this.endurance = endurance;
        this.level = 1;
        calculateStrength(strength);
    }

    public void randomiseCoordinates() {
        this.xCoord = (int) ((Math.random() * (World.getWidth() -1 )) + 1);
        this.yCoord = (int) ((Math.random() * (World.getHeight() -1 )) + 1);
    }

    private void calculateStrength(double strength) {
        switch (this.itemType) {
            case STANDARD: this.strength = strength*1;
            break;
            case GOLD: this.strength = strength*2;
            break;
            case SILVER: this.strength = strength*1.5;
            break;
            case PLATINUM: this.strength = strength*3;
            break;
        }
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public String getName() {
        return name;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }
    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
        if (this.level < 3) {
            this.itemType = ItemType.STANDARD;
        } else if (this.level < 5) {
            this.itemType = ItemType.SILVER;
        } else if (this.level < 7) {
            this.itemType = ItemType.GOLD;
        } else if (this.level < 9) {
            this.itemType = ItemType.PLATINUM;
        }
        calculateStrength(this.strength);
    }

    @Override
    public String toString() {
        return this.name + " tugevusega " + this.strength*1 + ". Kasutuskordi: " + this.endurance;
    }

}
