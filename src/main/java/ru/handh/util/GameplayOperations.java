package ru.handh.util;

// is it necessary ?
public class GameplayOperations {
    // method for dice rolling & damage value selection
    public static int pickNumberInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    // todo console output for dice rolling
    public static boolean severalDiceRolls(int numberOfRolls) {
        for (int i = 0; i < numberOfRolls; i++) {
            int gotValue = pickNumberInRange(1, 6); // dice roll - pick a number between 1 and 6

            if (gotValue >= 5) return true;
        }

        return false;
    }
}
