package com.company.item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    List<Item> inventory = new ArrayList<>();

    public void addItem(Item item) {
        int inventoryMaxSize = 4;
        if (inventory.size() <= inventoryMaxSize) {
            if (!inventory.contains(item)) {
                inventory.add(item);
                item.setLevel(1);
                System.out.println("Lisatud uus relv: " + item);
            } else {
                System.out.printf("Lisatud eseme %s kasutuskord %d -> ", item.getName(), item.getEndurance());
                inventory.stream()
                        .filter(e -> e == item)
                        .findFirst()
                        .ifPresent(e -> e.setEndurance(e.getEndurance() + 1));
                System.out.println(item.getEndurance());
            }
        } else {
            System.out.println(item.getEndurance());
        }
    }

    public void showInventory() {
        for (int i = 0; i < getInventory().size(); i++) {
            System.out.println(i+1 + ": " + getInventory().get(i));
        }
    }

    public List<Item> getInventory() {
        return inventory.stream().filter(e -> e.getEndurance() > 0).collect(Collectors.toList());
    }


}
