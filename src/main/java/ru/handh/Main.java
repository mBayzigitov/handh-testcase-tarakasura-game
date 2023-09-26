package ru.handh;

import ru.handh.chars.Player;

import java.util.List;
import java.util.Scanner;

import static ru.handh.util.GameDesignOperations.*;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static Player current_hero;
    public static void main(String[] args) throws InterruptedException {

        ////////////////// MAIN LOGIC OF THE GAME ///////////////////
        printLogo();

        printRules();

        System.out.println("[!] Выберите персонажа");
        List<Player> heroes = getInitialHeroes();
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + heroes.get(i));
        }

        String input = "";
        while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            System.out.print("-> ");
            input = scanner.nextLine();
        }

        switch (input) {
            case "1" -> { current_hero = heroes.get(0); }
            case "2" -> { current_hero = heroes.get(1); }
            case "3" -> { current_hero = heroes.get(2); }
        }

        System.out.println("");
        printStartMonolog();

        System.out.print("[!] Нажмите \"ENTER\", чтобы продолжить...");
        scanner.nextLine();
        System.out.println("");

        // --> boss #1 fight
        boolean fightResult = fightBoss(
                getFirstLevelMonsters()
        );

        if (fightResult) {
            printHeroPhraseAfterFirstWin();
        } else {
            printDyingPhrase();
            return;
        }

        findTreasure(
                getFirstLevelTreasures()
        );
        System.out.println(current_hero);
        System.out.print("[!] Нажмите \"ENTER\", чтобы продолжить...");
        scanner.nextLine();
        // <-------------->

        // --> boss #2 fight
        fightResult = fightBoss(
                getSecondLevelMonsters()
        );

        if (fightResult) {
            printHeroPhraseAfterSecondWin();
        } else {
            printDyingPhrase();
            return;
        }

        findTreasure(
                getSecondLevelTreasures()
        );
        System.out.println(current_hero);

        System.out.print("[!] Нажмите \"ENTER\", чтобы продолжить...");
        scanner.nextLine();
        // <-------------->

        // --> boss #3 fight
        fightResult = fightBoss(
                getThirdLevelMonsters()
        );

        if (fightResult) {
            printHeroPhraseAfterThirdWin();
        } else {
            printDyingPhrase();
            return;
        }

        findTreasure(
                getThirdLevelTreasures()
        );
        System.out.println(current_hero);

        System.out.print("[!] Нажмите \"ENTER\", чтобы продолжить...");
        scanner.nextLine();
        // <-------------->

        fightResult = mainBossFight();

        if (fightResult) {
            gameEnding();
        } else {
            printDyingOfTarakasuraPhrase();
        }
    }
}