package com.company;

import com.company.character.Character;
import com.company.item.Item;

import java.util.List;

public class World {
    private static int width;
    private static int height;
    List<Character> characters;
    List<Item> items;

    public World(int width, int height) {
        World.width = width;
        World.height = height;
    }

    public void render () {
        restrict();

        String symbol = "";

        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                if (y == 0 || y == height) {
                    symbol = "-";
                } else if (x == 0 || x == width) {
                    symbol = "|";
                } else {
                    symbol = " ";
                }

                for (Item i: items) {
                    if(i.getyCoord() == y && i.getxCoord() == x) {
                        symbol = "S";
                    }
                }

                for (Character c: characters) {
                    if (c.isVisible() && c.getxCoord() == x && c.getyCoord() == y) {
                        symbol = c.getSymbol();
                    }
                }

                System.out.print(symbol);
            }
            System.out.println("");
            symbol = "";
        }
    }

    private void restrict() {
//        Character c = characters.get(characters.size()-1);
//        System.out.println(c.getClass().getName());
        Character c = characters.stream()
                .filter(e -> e.getClass().getName().equals("com.company.character.Player"))
                .peek(System.out::println)
                .findFirst()
                .get();

        int xCoord = c.getxCoord();
        int yCoord = c.getyCoord();
        if (c.getxCoord() == 0) {
            c.setxCoord(xCoord+1);
        } else if (c.getyCoord() == 0) {
            c.setyCoord(yCoord+1);
        } else if (c.getxCoord() == width) {
            c.setxCoord(xCoord-1);
        } else if (c.getyCoord() == height) {
            c.setyCoord(yCoord-1);
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

}
