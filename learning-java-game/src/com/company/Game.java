package com.company;

import com.company.character.*;
import com.company.item.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static int counter = 0;
    static List<Item> playerWeapons;
    static int interval = 0;
    static Timer timer = new Timer();
    static int timeSpent;
    static Map<CharacterType, Integer> defeatedEnemies = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        World world = new World(20, 10);

        Enemy enemy = new Enemy("Vaenlane");
        Friend friend = new Friend("Sõber");
        Player player = new Player("Mängija");
        Healer healer = new Healer();
        Hammer hammer = new Hammer();
        Sword sword = new Sword();
        Boot boot = new Boot();
        Teleporter teleporter = new Teleporter();

        startTimer(timer, enemy);

        player.getPlayerInventory().addItem(hammer);
        player.getPlayerInventory().addItem(sword);
        player.getPlayerInventory().addItem(teleporter);

        // Player always last as it overwrites on the map
        world.setCharacters(Arrays.asList(enemy, friend, healer, player));
        world.setItems(Arrays.asList(hammer, sword, boot, teleporter));
        interactWithWorld(world, enemy, friend, player, healer, hammer, sword, boot, teleporter);
    }

    private static void startTimer(Timer timer, Enemy enemy) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                setInterval(enemy);
            }
        }, 1000, 1000);
    }

    private static int setInterval(Enemy enemy) {
        if (!enemy.isVisible()) {
            interval = 0;
        }
        return interval++;
    }

    private static void interactWithWorld(
            World world,
            Enemy enemy,
            Friend friend,
            Player player,
            Healer healer,
            Hammer hammer,
            Sword sword,
            Boot boot,
            Teleporter teleporter) throws InterruptedException {
        String input = "";
        world.render();
        while(!input.equals("end")){
            input = scanner.nextLine();
            switch (input) {
                case "w":
                    Direction playerDirection = Direction.UP;
                    player.changeDirection(playerDirection);
                    player.move();
                    break;
                case "s":
                    player.changeDirection(Direction.DOWN);
                    player.move();
                    break;
                case "a":
                    player.changeDirection(Direction.LEFT);
                    player.move();
                    break;
                case "d":
                    player.changeDirection(Direction.RIGHT);
                    player.move();
                    break;
                case "":
                    player.move();
                    break;
            }
            findItem(player, hammer, sword, boot, teleporter);
            meetCharacter(world, enemy, friend, player, healer);
        }
    }

    private static void findItem(Player player, Hammer hammer, Sword sword, Boot boot, Teleporter teleporter) {
        if (player.getxCoord() == hammer.getxCoord() && player.getyCoord() == hammer.getyCoord()) {
            player.getPlayerInventory().addItem(hammer);
        }
        if (player.getxCoord() == sword.getxCoord() && player.getyCoord() == sword.getyCoord()) {
            player.getPlayerInventory().addItem(sword);
        }
        if (player.getxCoord() == boot.getxCoord() && player.getyCoord() == boot.getyCoord()) {
            player.getPlayerInventory().addItem(boot);
        }
        if (player.getxCoord() == teleporter.getxCoord() && player.getyCoord() == teleporter.getyCoord()) {
            player.getPlayerInventory().addItem(teleporter);
        }
    }


    private static void meetCharacter(World world, Enemy enemy, Friend friend, Player player, Healer healer) throws InterruptedException {
        boolean enemyCatched = false;
        if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord()) {
            timeSpent = interval;
            enemy.setVisible(false);
            enemyCatched = true;
        }
        if (player.getxCoord() == friend.getxCoord() && player.getyCoord() == friend.getyCoord()) {
            enemy.setVisible(true);
            enemy.randomiseCoordinates();
        }
        if (player.getxCoord() == healer.getxCoord() && player.getyCoord() == healer.getyCoord()) {
            System.out.println("Ravitseja ravis sind! Su elud on nüüd täis!");
            Player.setFullHealth();
            healer.randomiseCoordinates();
        }
        world.render();
        if(enemyCatched){
            enemySeen(player, enemy);
        }
    }

    private static void enemySeen(Player player, Enemy enemy) throws InterruptedException {
        playerWeapons = player.getPlayerInventory().getInventory();
        if(Player.getHealth() > 0 && playerWeapons.size() > 0) {
            System.out.println("Kohtusid vaenlasega! Kas soovid temaga võidelda? Y/N: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                startBattle(player, enemy);
            } else {
                System.out.println("Põgenesid vaenlase eest!");
                System.out.println("Liigu edasi: ");
            }
        } else if (Player.getHealth() <= 0) {
            System.out.println("Sul on elud otsas! Otsi üles ravitseja et end ravida");
        } else if (playerWeapons.size() <= 0) {
            System.out.println("Sul on relvad otsas! Püüa neid mänguväljakult");
        }

    }

    private static void startBattle(Player player, Enemy enemy) throws InterruptedException {
        System.out.println("Algas lahing");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Sul on järgmine valik relvi: ");
        TimeUnit.MILLISECONDS.sleep(100);
        player.getPlayerInventory().showInventory();
        System.out.println("Vali number millist relva kasutad: ");
        Item chosenWeapon = getFightWeapon();
        TimeUnit.MILLISECONDS.sleep(100);


        if (chosenWeapon.getClass().getName().equals("com.company.item.Teleporter")) {
            useTeleporter(player, enemy, chosenWeapon);
            return;
        } else {
            System.out.println("Hakkasid võitlema!!");
            while (Player.getHealth()>0 || Enemy.getHealth()>0) {
                if (Player.getHealth() <= 0) {
                    System.out.println("Said surma!");
                    break;
                }
                if (Enemy.getHealth() <= 0) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    counter++;
                    System.out.println("Vaenlane käes!! Oled püüdnud vaenlasi: " + counter);
                    defeatedEnemies.put(enemy.getCharacterType(), timeSpent);
                    defeatedEnemies.forEach((key, value)-> System.out.println(key + "--" + value));
                    timeSpent = 0;
                    break;
                }
                fightEnemy(chosenWeapon);
            }
        }
        enemy.reboost();
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Liigu edasi: ");
    }

    private static void useTeleporter(Player player, Enemy enemy, Item chosenWeapon) {
        ((Teleporter) (chosenWeapon)).teleport();
        player.randomiseCoordinates();
        Player.takeHealth();
        enemy.setVisible(true);
    }

    private static Item getFightWeapon() {
        String input;
        input = scanner.nextLine();
        Item chosenWeapon = null;
        while(chosenWeapon == null){
            try {
                chosenWeapon = playerWeapons.get(Integer.parseInt(input)-1);
                Item finalChosenWeapon = chosenWeapon;
                playerWeapons.stream()
                        .filter(e -> e == finalChosenWeapon)
                        .findFirst()
                        .ifPresent(e -> {
                            e.setEndurance(e.getEndurance()-1);
                            e.setLevel(e.getLevel()+1);
                        });
            } catch (NumberFormatException e) {
                System.out.println("Sisestasid numbri asemel tähe! Sisesta uuesti!");
                input = scanner.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sellise numbriga relva ei ole! Sisesta uuesti!");
                input = scanner.nextLine();
            }
        }
        System.out.println("Valisid relva: " + chosenWeapon.getName());
        return chosenWeapon;
    }

    private static void fightEnemy(Item chosenWeapon) {
        System.out.println(Player.getHealth());
        System.out.println(Enemy.getHealth());
        String input;
        System.out.println("Ütle number millega võitled vahemikus 1-3");
        input = scanner.nextLine();
        if(input.equals(String.valueOf(enemyFightRandomNumber()))){
            switch (chosenWeapon.getClass().getName()) {
                case "com.company.item.Sword":
                    ((Sword) (chosenWeapon)).hit();
                    break;
                case "com.company.item.Hammer":
                    ((Hammer) (chosenWeapon)).hit();
                    break;
                case "com.company.item.Boot":
                    ((Boot) (chosenWeapon)).hit();
                    break;
            }
        } else {
            System.out.println("Ei saanud pihta! Vaenlane võttis sult elu");
            Player.takeHealth();
        }
    }

    private static int enemyFightRandomNumber() {
        return (int) ((Math.random() * ((3 - 1) + 1)) + 1);
    }
}
