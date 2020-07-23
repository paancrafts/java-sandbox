package com.company.character;

import com.company.WorldObject;
import com.company.World;

// @Lombok getter and setter
public class Character implements WorldObject {
    private int xCoord;
    private int yCoord;
    private String name;
    private String symbol;
    private boolean isVisible;

    public Character(String name, String symbol) {
        randomiseCoordinates();
        this.name = name;
        this.symbol = symbol;
        this.isVisible = true;
    }

    public void randomiseCoordinates() {
        this.xCoord = (int) ((Math.random() * (World.getWidth() - 1)) + 1);
        this.yCoord = (int) ((Math.random() * (World.getHeight() - 1)) + 1);
    }

    @Override
    public String toString() {
        return "Olen " + name + " ja asun kordinaatidel:" +
                "x=" + xCoord +
                ", y=" + yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
