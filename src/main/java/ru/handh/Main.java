package ru.handh;

import ru.handh.chars.Monster;
import ru.handh.chars.Player;
import ru.handh.objects.Item;
import ru.handh.util.GameplayOperations;
import ru.handh.util.ParameterAffected;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static Player current_hero;
    public static int bossFightCounter = 0;
    public static void main(String[] args) throws InterruptedException {
        // <--- Creation of gameplay objects --->
        Item club = new Item("Дубина", "Её тяжелый, дубовый ствол напоминает могучее древо, сжимающее корни в земле, готовое расколоть неверного врага вдребезги.",
                ParameterAffected.DAMAGE, 2);
        Item cape = new Item("Тканевый плащ", "Легкий и ветреный, он словно мягкая объятия ночи. Его ткань колышется в ритме твоих шагов, придавая загадочности и уверенности в этом опасном мире.",
                ParameterAffected.BLOCK, 1);
        Item dagger = new Item("Кинжал", "Этот железный кинжал словно молния, мгновенно рвущая врагов, исчезающая так же быстро, как появилась.",
                ParameterAffected.ATTACK, 1);

        Item sword = new Item("Меч Фазара", "Горячая сталь этого меча сверкает в руках, как пламя дракона. Его клинок способен разрушить любое зло, которое посмеет встать на твоем пути.",
                ParameterAffected.DAMAGE, 3);
        Item fire_shield = new Item("Пламенный щит", "Его пламя горит ярче, чем тысячи звезд. Этот щит будет твоей надежной защитой, в которую ни один ужас не проникнет.",
                ParameterAffected.BLOCK, 2);
        Item thorns_heart = new Item("Сердце Торна", "Когда-то этот артефакт бился в груди великого война. " +
                "Когда он был побежден, силы тьмы колдовством использовали его энергию для восполнения жизненных сил. " +
                "Теперь же это сердце наполняет твою душу силой и мудростью, необходимой для победы над злом.",
                ParameterAffected.MAX_HEALTH, 2);
        Item cinades_medallion = new Item("Медальон Цинада", "Его изящная цепочка касается твоей груди, словно прикасаясь к самой сути твоей души. " +
                "Этот медальон обещает тебе верность и помощь в самый тяжелый час.",
                ParameterAffected.ATTACK, 3);
        Item seal_of_chaos = new Item("Печать Хаоса", "Она сияет мрачными силами, готовыми развязать апокалипсис. " +
                "Её сила – твоя власть, но будь осторожен, она может стать и твоим проклятием.",
                ParameterAffected.MAX_HEALTH, 5);
        Item ferogs_staff = new Item("Посох Ферога", "Древний посох, который словно изгибается под твоей волей. Его конец сверкает магическими символами, готовыми исполнить любую твою команду.",
                ParameterAffected.DAMAGE, 4);
        Item cyirs_sphere = new Item("Сфера неуязвимости Киира", "Она окружает тебя мистической силой, создавая непроницаемый барьер между тобой и опасностью. " +
                "В ней сосредоточена сила богов, и она будет твоим щитом в самые темные моменты твоего приключения.",
                ParameterAffected.BLOCK, 8);
        Item masters_shoulders = new Item("Наплечники древнего мастера", "Эти наплечники несут в себе мудрость и мастерство вековых героев. " +
                "Их кожа словно переплетена временем, а узоры на них напоминают таинственные руны старинных эльфов.",
                ParameterAffected.ATTACK, 13);
        Item fragments = new Item("Осколки души Саргатанаса", "Это осколки темной и разрушительной души одного из самых могущественных злодеев, когда-либо проклинающего этот мир. " +
                "Они сверкают зловещим сиянием, словно сама абсолютная злая сущность. Посмотри в их отражение и обрети мощь, доселе невиданную.",
                ParameterAffected.MAX_HEALTH, 12);

        ArrayList<Item> level_1_items = new ArrayList<>();
        level_1_items.add(sword);
        level_1_items.add(fire_shield);
        level_1_items.add(thorns_heart);

        ArrayList<Item> level_2_items = new ArrayList<>();
        level_2_items.add(cinades_medallion);
        level_2_items.add(seal_of_chaos);
        level_2_items.add(ferogs_staff);

        ArrayList<Item> level_3_items = new ArrayList<>();
        level_3_items.add(cyirs_sphere);
        level_3_items.add(masters_shoulders);
        level_3_items.add(fragments);
        // <------------------------------------>

        // <--- Creation of gameplay characters --->
        Player hero_1 = new Player("Картикея", 10, 15, 30, 6, 8);
        hero_1.addItem(club);

        Player hero_2 = new Player("Ганеша", 14, 10, 24, 10, 12);
        hero_2.addItem(cape);

        Player hero_3 = new Player("Сканда", 11, 11, 26, 8, 12);
        hero_3.addItem(dagger);
        List<Player> heroes = new ArrayList<>(List.of(hero_1, hero_2, hero_3));

        Monster molo = new Monster("Моло", 12, 4, 17, 5, 7,
                "Ты пришел, как баран на кладбище, не зная, что здесь – твой последний покой.");
        String art = "             \\                  /\n" +
                "           _________))                ((__________\n" +
                "          /.-------./\\\\    \\    /    //\\.--------.\\\n" +
                "         //#######//##\\\\   ))  ((   //##\\\\########\\\\\n" +
                "        //#######//###((  ((    ))  ))###\\\\########\\\\\n" +
                "       ((#######((#####\\\\  \\\\  //  //#####))########))\n" +
                "        \\##' `###\\######\\\\  \\)(/  //######/####' `##/\n" +
                "         )'    ``#)'  `##\\`->oo<-'/##'  `(#''     `(\n" +
                "                 (       ``\\`..'/''       )\n" +
                "                            \\\"\"(\n" +
                "                             `- )\n" +
                "                             / /\n" +
                "                            ( /\\\n" +
                "                            /\\| \\\n" +
                "                           (  \\\n" +
                "                               )\n" +
                "                              /\n" +
                "                             (\n";
        molo.setAsciiArt(art);

        Monster alastor = new Monster("Аластор", 13, 3, 16, 4, 6,
                "Скоро твоя душа будет моей, а ты станешь частью тьмы, которую не пережить.");
        art =   "             ,/         \\.\n" +
                "            ((           ))\n" +
                "             \\`.       ,'/\n" +
                "              )')     (`(\n" +
                "            ,'`/       \\,`.\n" +
                "           (`-(         )-')\n" +
                "            \\-'\\,-'\"`-./`-/\n" +
                "             \\-')     (`-/\n" +
                "             /`'       `'\\\n" +
                "            (  _       _  )\n" +
                "            | ( \\     / ) |\n" +
                "            |  `.\\   /,'  |\n" +
                "            |    `\\ /'    |\n" +
                "            (             )\n" +
                "             \\           /\n" +
                "              \\         /\n" +
                "               `.     ,'\n" +
                "                 `-.-'\n";
        alastor.setAsciiArt(art);

        Monster xafan = new Monster("Ксафан", 10, 3, 15, 6, 8,
                "Ты думал, что можешь сопротивляться нам? Ты лишь капля в океане боли, которую мы принесем.");
        art =   "                   ,-----.\n" +
                "                  ( <> <> )\n" +
                "                   )_ W _(\n" +
                "                    |||||    A A A\n" +
                "                     |||     | | |\n" +
                "                  __/)'(\\__  `-+-'\n" +
                "                 /\\\\     //\\   |\n" +
                "                | |\\\\___//\\ \\  |\n" +
                "                | |/\\\\_//\\ \\ \\ |\n" +
                "                | ||\\\\_//|  \\ \\|\n" +
                "                | ||/\\_/\\|   \\ |\n" +
                "                | |/ /|\\ \\    \\_)\n" +
                "                (_/  \\_/  \\    K\n" +
                "                  |  | |  |    R\n" +
                "                  |  | |  |    O\n" +
                "                  |()| |()|    G\n" +
                "                  |  | |  |    G\n" +
                "                  |  | |  |    9\n" +
                "                  |__| |__|    8\n" +
                "                  \\__/ \\__/    V\n";
        xafan.setAsciiArt(art);

        List<Monster> level_1_monsters = new ArrayList<>(List.of(molo, alastor, xafan));

        Monster sabnac = new Monster("Сабнак", 15, 9, 21, 8, 9,
                "Твой страх – наш праздник, твоя мука – наша песня. Подготовься к пиршеству.");
        art = "             =*===\n" +
                "           $$- - $$$\n" +
                "           $ <    D$$\n" +
                "           $ -   $$$\n" +
                "     ,     $$$$  |\n" +
                "    ///; ,---' _ |----.\n" +
                "     \\ )(           /  )\n" +
                "     | \\/ \\.   '  _.|  \\              $\n" +
                "     |  \\ /(   /    /\\_ \\          $$$$$\n" +
                "      \\ /  (       / /  )         $$$ $$$\n" +
                "           (  ,   /_/ ,`_,-----.,$$  $$$\n" +
                "           |   <----|  \\---##     \\   $$\n" +
                "           /         \\\\\\           |    $\n" +
                "          '   '                    |\n" +
                "          |                 \\      /\n" +
                "          /  \\_|    /______,/     /\n" +
                "         /   / |   /    |   |    /\n" +
                "        (   /--|  /.     \\  (\\  (_\n" +
                "         `----,( ( _\\     \\ / / ,/\n" +
                "               | /        /,_/,/\n" +
                "              _|/        / / (\n" +
                "             / (        ^-/, |\n" +
                "            /, |          ^-    b'ger\n" +
                "            ^-\n";
        sabnac.setAsciiArt(art);

        Monster serra = new Monster("Серра", 17, 12, 24, 8, 12,
                "Твои надежды призрачны, а горесть - ничтожна. Насладись своим последним моментом.");
        art =   "                              /       /\n" +
                "                           .'<_.-._.'<\n" +
                "                          /           \\      .^.\n" +
                "        ._               |  -+- -+-    |    (_|_)\n" +
                "     r- |\\                \\   /       /      //\n" +
                "   /\\ \\\\  :                \\  -=-    /       \\\\\n" +
                "    `. \\\\.'           ___.__`..;._.-'---...  //\n" +
                "      ``\\\\      __.--\"        `;'     __   `-.\n" +
                "        /\\\\.--\"\"      __.,              \"\"-.  \".\n" +
                "        ;=r    __.---\"   | `__    __'   / .'  .'\n" +
                "        '=/\\\\\"\"           \\             .'  .'\n" +
                "            \\\\             |  __ __    /   |\n" +
                "             \\\\            |  -- --   //`'`'\n" +
                "              \\\\           |  -- --  ' | //\n" +
                "               \\\\          |    .      |//  \n";
        serra.setAsciiArt(art);

        Monster habaril = new Monster("Хабарил", 13, 15, 22, 9, 13,
                "Мы не боимся света, потому что в нем тоже есть тьма. И ты - наш следующий шедевр.");
        art =   "                *                       *\n" +
                "                   *                 *\n" +
                "                  )       (\\___/)     (\n" +
                "               * /(       \\ (. .)     )\\ *\n" +
                "                 # )      c\\   >'    ( #\n" +
                "                  '         )-_/      '\n" +
                "                \\\\|,    ____| |__    ,|//\n" +
                "                  \\ )  (  `  ~   )  ( /\n" +
                "                   #\\ / /| . ' .) \\ /#\n" +
                "                   | \\ / )   , / \\ / |\n" +
                "                    \\,/ ;;,,;,;   \\,/\n" +
                "                     _,#;,;;,;,\n" +
                "                    /,i;;;,,;#,;\n" +
                "                   //  %;;,;,;;,;\n" +
                "                  ((    ;#;,;%;;,,\n" +
                "                 _//     ;,;; ,#;,\n" +
                "                /_)      #,;    ))\n" +
                "                        //      \\|_\n" +
                "                        \\|_      |#\\\n" +
                "                         |#\\      -\"  b'ger\n" +
                "                          -\"\n";
        habaril.setAsciiArt(art);

        List<Monster> level_2_monsters = new ArrayList<>(List.of(sabnac, serra, habaril));


        Monster leviafan = new Monster("Левиафан", 18, 17, 23, 8, 14,
                "Твоя жизнь – всего лишь мгновение вечности. Ты угаснешь, но это ничего не изменит.");
        art = "                                                 __----~~~~~~~~~~~------___\n" +
                "                                      .  .   ~~//====......          __--~ ~~\n" +
                "                      -.            \\_|//     |||\\\\  ~~~~~~::::... /~\n" +
                "                   ___-==_       _-~o~  \\/    |||  \\\\            _/~~-\n" +
                "           __---~~~.==~||\\=_    -_--~/_-~|-   |\\\\   \\\\        _/~\n" +
                "       _-~~     .=~    |  \\\\-_    '-~7  /-   /  ||    \\      /\n" +
                "     .~       .~       |   \\\\ -_    /  /-   /   ||      \\   /\n" +
                "    /  ____  /         |     \\\\ ~-_/  /|- _/   .||       \\ /\n" +
                "    |~~    ~~|--~~~~--_ \\     ~==-/   | \\~--===~~        .\\\n" +
                "             '         ~-|      /|    |-~\\~~       __--~~\n" +
                "                         |-~~-_/ |    |   ~\\_   _-~            /\\\n" +
                "                              /  \\     \\__   \\/~                \\__\n" +
                "                          _--~ _/ | .-~~____--~-/                  ~~==.\n" +
                "                         ((->/~   '.|||' -_|    ~~-/ ,              . _||\n" +
                "                                    -_     ~\\      ~~---l__i__i__i--~~_/\n" +
                "                                    _-~-__   ~)  \\--______________--~~\n" +
                "                                  //.-~~~-~_--~- |-------~~~~~~~~\n" +
                "                                         //.-~~~--\\\n";
        leviafan.setAsciiArt(art);

        Monster citry = new Monster("Ситри", 16, 18, 26, 3, 12,
                "Твоя судьба уже была записана в наших книгах. Сегодня мы просто закроем эту главу.");
        art = "                   (    )\n" +
                "                  ((((()))\n" +
                "                  |o\\ /o)|\n" +
                "                  ( (  _')\n" +
                "                   (._.  /\\__\n" +
                "                  ,\\___,/ '  ')\n" +
                "    '.,_,,       (  .- .   .    )\n" +
                "     \\   \\\\     ( '        )(    )\n" +
                "      \\   \\\\    \\.  _.__ ____( .  |\n" +
                "       \\  /\\\\   .(   .'  /\\  '.  )\n" +
                "        \\(  \\\\.-' ( /    \\/    \\)\n" +
                "         '  ()) _'.-|/\\/\\/\\/\\/\\|\n" +
                "             '\\\\ .( |\\/\\/\\/\\/\\/|\n" +
                "               '((  \\    /\\    /\n" +
                "               ((((  '.__\\/__.')\n" +
                "                ((,) /   ((()   )\n" +
                "                 \"..-,  (()(\"   /\n" +
                "                  _//.   ((() .\"\n" +
                "          _____ //,/\" ___ ((( ', ___\n" +
                "                           ((  )\n" +
                "                            / /\n" +
                "                          _/,/'\n" +
                "                        /,/,\"\n";
        citry.setAsciiArt(art);

        Monster sartaganas = new Monster("Сартаганас", 14, 21, 22, 6, 13,
                "Ты глупец, если решил, что действительно способен меня одолеть.");
        art = "   .:'                                  `:.\n" +
                "  ::'                                    `::\n" +
                " :: :.                                  .: ::\n" +
                "  `:. `:.             .             .:'  .:'\n" +
                "   `::. `::           !           ::' .::'\n" +
                "       `::.`::.    .' ! `.    .::'.::'\n" +
                "         `:.  `::::'':!:``::::'   ::'\n" +
                "         :'*:::.  .:' ! `:.  .:::*`:\n" +
                "        :: HHH::.   ` ! '   .::HHH ::\n" +
                "       ::: `H TH::.  `!'  .::HT H' :::\n" +
                "       ::..  `THHH:`:   :':HHHT'  ..::\n" +
                "       `::      `T: `. .' :T'      ::'\n" +
                "         `:. .   :         :   . .:'\n" +
                "           `::'               `::'\n" +
                "             :'  .`.  .  .'.  `:\n" +
                "             :' ::.       .:: `:\n" +
                "             :' `:::     :::' `:\n" +
                "              `.  ``     ''  .'\n" +
                "               :`...........':\n" +
                "               ` :`.     .': '\n" +
                "                `:  `\"\"\"'  :";
        sartaganas.setAsciiArt(art);

        List<Monster> level_3_monsters = new ArrayList<>(List.of(leviafan, citry, sartaganas));
        // <--------------------------------------->

        printLogo();

        System.out.println("[!] Выберите персонажа");
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + heroes.get(i));
        }

        String input = "";
        while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            System.out.print("-> ");
            input = scanner.nextLine();
        }

        switch (input) {
            case "1" -> { current_hero = hero_1; }
            case "2" -> { current_hero = hero_2; }
            case "3" -> { current_hero = hero_3; }
        }

        System.out.println("");
//        printStartMonolog();
        String monolog = "[" + current_hero.getName() + "] Он сделал это. Там не осталось ничего. Ни травинки,\n" +
                "\tни дома, ни животных. И людей, их тоже не осталось. Одно лишь пепелище. В тот день он затмил и небо над деревней,\n" +
                "\tи мой разум. С тех пор вспоминая те лица я думаю лишь об одном - о мести. Я, " + current_hero.getName() + ", найду\n" +
                "\tего и заставлю заплатить.";
        printSlowPhrase(monolog, 20);

        System.out.print("[!] Нажмите \"ENTER\", чтобы продолжить...");
        scanner.nextLine();
        System.out.println("");

        // --> boss #1 fight
        boolean fightResult = fightBoss(level_1_monsters);

        if (fightResult) {
            printHeroPhraseAfterFirstWin();
        } else {
            printDyingPhrase();
            return;
        }

        findTreasure(level_1_items);
        System.out.println(current_hero);
        System.out.print("[!] Нажмите \"ENTER\", чтобы продолжить...");
        scanner.nextLine();
        // <-------------->

        // --> boss #2 fight
        fightResult = fightBoss(level_2_monsters);

        if (fightResult) {
            printHeroPhraseAfterSecondWin();
        } else {
            printDyingPhrase();
            return;
        }

        findTreasure(level_2_items);
        System.out.println(current_hero);

        System.out.print("[!] Нажмите \"ENTER\", чтобы продолжить...");
        scanner.nextLine();
        // <-------------->

        // --> boss #3 fight
        fightResult = fightBoss(level_3_monsters);

        if (fightResult) {
            printHeroPhraseAfterSecondWin();
        } else {
            printDyingPhrase();
            return;
        }

        findTreasure(level_3_items);
        System.out.println(current_hero);

        System.out.print("[!] Нажмите \"ENTER\", чтобы продолжить...");
        scanner.nextLine();
        // <-------------->

        fightResult = mainBossFight();

        if (fightResult) {
            System.out.println("ПОБЕДА!!!!");
//            gameEnding();
        } else {
            printDyingOfTarakasuraPhrase();
            return;
        }

    }

    public static void printLogo() throws InterruptedException {
        String logo = "          ▀▀█▀▀ ░█▀▀█ ▒█▀▀█ ░█▀▀█ ▒█░▄▀ ░█▀▀█ ▒█▀▀▀█ ▒█░▒█ ▒█▀▀█ ░█▀▀█\n" +
                      "          ░▒█░░ ▒█▄▄█ ▒█▄▄▀ ▒█▄▄█ ▒█▀▄░ ▒█▄▄█ ░▀▀▀▄▄ ▒█░▒█ ▒█▄▄▀ ▒█▄▄█\n" +
                      "          ░▒█░░ ▒█░▒█ ▒█░▒█ ▒█░▒█ ▒█░▒█ ▒█░▒█ ▒█▄▄▄█ ░▀▄▄▀ ▒█░▒█ ▒█░▒█\n";
        printSlowPhrase(logo, 5);
    }

    public static void printStartMonolog() {
        System.out.println("[" + current_hero.getName() + "] Он сделал это. Там не осталось ничего. Ни травинки,\n" +
                "\tни дома, ни животных. И людей, их тоже не осталось. Одно лишь пепелище. В тот день он затмил и небо над деревней,\n" +
                "\tи мой разум. С тех пор вспоминая те лица я думаю лишь об одном - о мести. Я, " + current_hero.getName() + ", найду\n" +
                "\tего и заставлю заплатить.");
    }

    public static boolean fightBoss(List<Monster> monstersList) throws InterruptedException {
        String message = "[!] Туман надвигается. Идя по следу Таракасуры вы наткнулись на одного из его приспешников!\n";
        printSlowPhrase(message, 35);

        Monster current_monster = monstersList.get(
                GameplayOperations.pickNumberInRange(0, 2) // pick random boss from current list
        );

        message = "[" + current_monster.getName() + "] " + current_monster.getMeetingPhrase();
        printSlowPhrase(message, 20);

        printSlowPhrase(current_monster.getAsciiArt(), 5);
        printSlowPhrase(current_monster.toString(), 20);

        while (!current_monster.isDead() && !current_hero.isDead()) {
            System.out.println("[!] Вы атакуете, нажмите \"ENTER\" для нанесения удара");
            scanner.nextLine();

            int damageDone = current_hero.attack(current_monster);
            System.out.println("[!] Атака нанесла " + damageDone + " урона! У монстра осталось " + current_monster.getHealth() + " здоровья.");

            if (current_monster.isDead()) {
                System.out.println("[!] Игрок " + current_hero.getName() + " побеждает монстра " + current_monster.getName() + "!\n");
                return true;
            }

            System.out.println("[!] Монстр атакует в ответ, нажмите \"ENTER\", чтобы продолжить");
            scanner.nextLine();

            damageDone = current_monster.attack(current_hero);
            System.out.println("[!] Атака нанесла " + damageDone + " урона! У вас осталось " + current_hero.getHealth() + " здоровья!");

            if (current_hero.isDead()) {
                System.out.println("[!] Монстр " + current_monster.getName() + " рызрывает игрока в клочья! Конец игры...\n");
                return false;
            }

            if (current_hero.isHealingAvailable()) {
                String input = "heal";
                while (input.equalsIgnoreCase("heal") && current_hero.isHealingAvailable()) {
                    System.out.println("[!] Здоровье игрока: [" + current_hero.getHealth() + "/" + current_hero.getMaxHealth() + "].\n" +
                            "\tВведите \"heal\", чтобы применить лечебное зелье или нажмите \"ENTER\", чтобы продолжить. Осталось зелий: " + current_hero.getHealLeft());
                    System.out.print("-> ");
                    input = scanner.nextLine();
                    if (input.equalsIgnoreCase("heal")) {
                        current_hero.heal();
                    }
                }
            }
        }

        return true;
    }

    public static void printHeroPhraseAfterFirstWin() throws InterruptedException {
        String message = "[" + current_hero.getName() + "] Таракасура, твои приспешники слабы. Пламя ни одного из них не\n" +
                "\tпылает так жарко, как пламя моего гнева.\n";
        printSlowPhrase(message, 20);
    }

    public static void printHeroPhraseAfterThirdWin() throws InterruptedException {
        String message = "[" + current_hero.getName() + "] Покажись. ПО-КА-ЖИСЬ!!! Я выну из тебя твою жалкую душу за все, что ты сделал!\n";
        printSlowPhrase(message, 20);
    }

    public static void printHeroPhraseAfterSecondWin() throws InterruptedException {
        String message = "[" + current_hero.getName() + "] Я чувствую, что Он рядом. Он не боится меня, а зря.\n" +
                "Его высокомерие убьёт его!";
        printSlowPhrase(message, 20);
    }

    public static void printDyingPhrase() throws InterruptedException {
        String message = "[" + current_hero.getName() + "] Этого не может... Этого просто не может быть...\n" +
                "[КОНЕЦ ИГРЫ]";
        printSlowPhrase(message, 20);
    }

    public static void printSlowPhrase(String curString, int millis) throws InterruptedException {
        for (int i = 0; i < curString.length(); i++) {
            System.out.print(curString.charAt(i));
            Thread.sleep(millis);
        }
        System.out.println("");
    }

    public static void findTreasure(List<Item> treasures) throws InterruptedException {
        String message = "[!] Туман боя рассеивается. Вы обнаружили странный густок света.\n" +
                "\t\"Выбирай\", - прошептал он.";
        printSlowPhrase(message, 20);

        for (int i = 0; i < treasures.size(); i++) {
            System.out.println((i + 1) + ". " + treasures.get(i));
        }
        System.out.println("");

        String input = "";

        while (!input.equalsIgnoreCase("1") && !input.equalsIgnoreCase("2") && !input.equalsIgnoreCase("3")) {
            System.out.print("-> ");
            input = scanner.nextLine();
        }

        Item selectedItem = new Item();
        switch (input) {
            case "1" -> {
                selectedItem = treasures.get(0);
            }
            case "2" -> {
                selectedItem = treasures.get(1);
            }
            case "3" -> {
                selectedItem = treasures.get(2);
            }
        }

        current_hero.addItem(selectedItem);
        System.out.println("[!] Вы выбрали предмет " + selectedItem + ".\n");
    }

    public static boolean mainBossFight() throws InterruptedException {
        Monster tarakasura = new Monster("Таракасура", 25, 20, 30, 9, 20,
                "С нашей последней встречи прошло много времени, " + current_hero.getName() + ".\n" +
                        "\tЯ думаю, ты недооцениваешь свою ничтожность по сравнению со мной. Я - смерть,\n" +
                        "разрушитель миров. Подходи, я превращу в руины и твой!");
        String art = "                               _\n" +
                "                            ==(W{==========-      /===-\n" +
                "                              ||  (.--.)         /===-_---~~~~~~~~~------____\n" +
                "                              | \\_,|**|,__      |===-~___                _,-'\n" +
                "                 -==\\\\        `\\ ' `--'   ),    `//~\\\\   ~~~~`---.___.-~~\n" +
                "             ______-==|        /`\\_. .__/\\ \\    | |  \\\\           _-~`\n" +
                "       __--~~~  ,-/-==\\\\      (   | .  |~~~~|   | |   `\\        ,'\n" +
                "    _-~       /'    |  \\\\     )__/==0==-\\<>/   / /      \\      /\n" +
                "  .'        /       |   \\\\      /~\\___/~~\\/  /' /        \\   /'\n" +
                " /  ____  /         |    \\`\\.__/-~~   \\  |_/'  /          \\/'\n" +
                "/-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`\n" +
                "                  \\_|      /        _) | ;  ),   __--~~\n" +
                "                    '~~--_/      _-~/- |/ \\   '-~ \\\n" +
                "                   {\\__--_/}    / \\\\_>-|)<__\\      \\\n" +
                "                   /'   (_/  _-~  | |__>--<__|      |\n" +
                "                  |   _/) )-~     | |__>--<__|      |\n" +
                "                  / /~ ,_/       / /__>---<__/      |\n" +
                "                 o-o _//        /-~_>---<__-~      /\n" +
                "                 (^(~          /~_>---<__-      _-~\n" +
                "                ,/|           /__>--<__/     _-~\n" +
                "             ,//('(          |__>--<__|     /                  .----_\n" +
                "            ( ( '))          |__>--<__|    |                 /' _---_~\\\n" +
                "         `-)) )) (           |__>--<__|    |               /'  /     ~\\`\\\n" +
                "        ,/,'//( (             \\__>--<__\\    \\            /'  //        ||\n" +
                "      ,( ( ((, ))              ~-__>--<_~-_  ~--____---~' _/'/        /'\n" +
                "    `~/  )` ) ,/|                 ~-_~>--<_/-__       __-~ _/\n" +
                "  ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~~~__--~\n" +
                "   ;'( ')/ ,)(                              ~~~~~~~~~~\n" +
                "  ' ') '( (/\n" +
                "    '   '  `";
        tarakasura.setAsciiArt(art);

        String message = "[!] Туман надвигается... Вы искали мщения, так УЗРИТЕ!!\n";
        printSlowPhrase(message, 20);

        message = "[ТАРАКАСУРА] " + tarakasura.getMeetingPhrase();
        printSlowPhrase(message, 20);

        printSlowPhrase(tarakasura.getAsciiArt(), 3);
        message = "[!] Повелитель тьмы - " + tarakasura.getName() + "\n" +
                "\tАтака: " + tarakasura.getAttack() + ", защита: " + tarakasura.getBlock() + ", здоровье: " + tarakasura.getMaxHealth() + ", урон: " +
                tarakasura.getDamageMin() + "-" + tarakasura.getDamageMax() + ".\n";
        printSlowPhrase(tarakasura.toString(), 5);

        while (!tarakasura.isDead() && !current_hero.isDead()) {
            System.out.println("[!] Вы атакуете, нажмите \"ENTER\" для нанесения удара");
            scanner.nextLine();

            int damageDone = current_hero.attack(tarakasura);
            System.out.println("[!] Атака нанесла " + damageDone + " урона! У монстра осталось " + tarakasura.getHealth() + " здоровья.");

            if (tarakasura.isDead()) {
                System.out.println("[!] Игрок " + current_hero.getName() + " побеждает монстра " + tarakasura.getName() + "!\n");
                return true;
            }

            System.out.println("[!] Монстр атакует в ответ, нажмите \"ENTER\", чтобы продолжить");
            scanner.nextLine();

            damageDone = tarakasura.attack(current_hero);
            System.out.println("[!] Атака нанесла " + damageDone + " урона! У вас осталось " + current_hero.getHealth() + " здоровья!");

            if (current_hero.isDead()) {
                System.out.println("[!] Монстр " + tarakasura.getName() + " рызрывает игрока в клочья! Конец игры...\n");
                return false;
            }

            if (current_hero.isHealingAvailable()) {
                String input = "heal";
                while (input.equalsIgnoreCase("heal") && current_hero.isHealingAvailable()) {
                    System.out.println("[!] Здоровье игрока: [" + current_hero.getHealth() + "/" + current_hero.getMaxHealth() + "].\n" +
                            "\tВведите \"heal\", чтобы применить лечебное зелье или нажмите \"ENTER\", чтобы продолжить. Осталось зелий: " + current_hero.getHealLeft());
                    System.out.print("-> ");
                    input = scanner.nextLine();
                    if (input.equalsIgnoreCase("heal")) {
                        current_hero.heal();
                    }
                }
            }
        }

        return true;
    }

    public static void printDyingOfTarakasuraPhrase() throws InterruptedException {
        String message = "[" + current_hero.getName() + "] Я... Я пыт... Я пыталась, но все тщетно.\n" +
                "Простите... меня.";
        printSlowPhrase(message, 30);
    }
}