package ru.handh;

import ru.handh.chars.Creature;
import ru.handh.chars.Player;

public class Main {
    public static void main(String[] args) {
        // logic here
        Player player = new Player("John", 5, 2, 10, 3, 5);
        player.makeDamage(9);
        while (player.isHealingAvailable()) player.heal();
        System.out.println("No healings left");
    }
}