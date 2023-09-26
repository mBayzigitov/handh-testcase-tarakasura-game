package ru.handh.util;

import java.util.concurrent.ThreadLocalRandom;

public class GameplayOperations {
    // method for dice rolling & damage value selection
    public static int pickNumberInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static boolean severalDiceRolls(int numberOfRolls) throws InterruptedException {
        System.out.println("\tКубик будет брошен " + numberOfRolls + " раз.");
        for (int i = 0; i < numberOfRolls; i++) {
            int gotValue = pickNumberInRange(1, 6); // dice roll - pick a number between 1 and 6
            System.out.print("[Бросок кубика №" + (i+1) + "] Выпало значение " + gotValue + ". ");

            if (gotValue >= 5) {
                System.out.println("Атака удалась!");
                return true;
            } else {
                System.out.println("Атака не удалась!");
            }
            Thread.sleep(1000);
        }

        return false;
    }
}
