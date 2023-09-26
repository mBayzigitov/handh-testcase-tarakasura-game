package ru.handh.util;

import ru.handh.Main;
import ru.handh.chars.Monster;
import ru.handh.chars.Player;
import ru.handh.objects.Item;

import java.util.ArrayList;
import java.util.List;

public class GameDesignOperations {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////// <---------------- Game announcements & phrases ----------------> ////////////////////////////

    // Output with reading speed imitation
    public static void printSlowPhrase(String curString, int millis) throws InterruptedException {
        for (int i = 0; i < curString.length(); i++) {
            System.out.print(curString.charAt(i));
            Thread.sleep(millis);
        }
        System.out.println("");
    }

    public static void printLogo() throws InterruptedException {
        String logo = "          ▀▀█▀▀ ░█▀▀█ ▒█▀▀█ ░█▀▀█ ▒█░▄▀ ░█▀▀█ ▒█▀▀▀█ ▒█░▒█ ▒█▀▀█ ░█▀▀█\n" +
                      "          ░▒█░░ ▒█▄▄█ ▒█▄▄▀ ▒█▄▄█ ▒█▀▄░ ▒█▄▄█ ░▀▀▀▄▄ ▒█░▒█ ▒█▄▄▀ ▒█▄▄█\n" +
                      "          ░▒█░░ ▒█░▒█ ▒█░▒█ ▒█░▒█ ▒█░▒█ ▒█░▒█ ▒█▄▄▄█ ░▀▄▄▀ ▒█░▒█ ▒█░▒█\n";
        printSlowPhrase(logo, 5);
    }

    public static void printStartMonolog() throws InterruptedException {
        String monolog = "[" + Main.current_hero.getName() + "] Он сделал это. Там не осталось ничего. Ни травинки,\n" +
                "\tни дома, ни животных. И людей, их тоже не осталось. Одно лишь пепелище. В тот день он затмил и небо над деревней,\n" +
                "\tи мой разум. С тех пор вспоминая те лица я думаю лишь об одном - о мести. Я, " + Main.current_hero.getName() + ", найду\n" +
                "\tего и заставлю заплатить.";
        printSlowPhrase(monolog, 20);
    }

    public static void printHeroPhraseAfterFirstWin() throws InterruptedException {
        String message = "[" + Main.current_hero.getName() + "] Таракасура, твои приспешники слабы. Пламя ни одного из них не\n" +
                "\tпылает так жарко, как пламя моего гнева.\n";
        printSlowPhrase(message, 20);
    }

    public static void printHeroPhraseAfterThirdWin() throws InterruptedException {
        String message = "[" + Main.current_hero.getName() + "] Покажись. ПО-КА-ЖИСЬ!!! Я выну из тебя твою жалкую душу за все, что ты сделал!\n";
        printSlowPhrase(message, 20);
    }

    public static void printHeroPhraseAfterSecondWin() throws InterruptedException {
        String message = "[" + Main.current_hero.getName() + "] Я чувствую, что Он рядом. Он не боится меня, а зря.\n" +
                "Его высокомерие убьёт его!";
        printSlowPhrase(message, 20);
    }

    public static void printDyingOfTarakasuraPhrase() throws InterruptedException {
        String message = "[" + Main.current_hero.getName() + "] Я... Я пыт... Я пыталась, но все тщетно.\n" +
                "Простите... меня.";
        printSlowPhrase(message, 30);
    }

    public static void printDyingPhrase() throws InterruptedException {
        String message = "[" + Main.current_hero.getName() + "] Этого не может... Этого просто не может быть...\n" +
                "[КОНЕЦ ИГРЫ]";
        printSlowPhrase(message, 20);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////// <---------------- Game characters and items ----------------> //////////////////////////////

    public static List<Monster> getFirstLevelMonsters() {
        Monster molo = new Monster("Моло", 13, 5, 14, 4, 6,
                "Ты пришел, как баран на кладбище, не зная, что здесь - твой последний покой.");
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

        Monster alastor = new Monster("Аластор", 13, 4, 13, 5, 7,
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

        Monster xafan = new Monster("Ксафан", 10, 3, 18, 3, 8,
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

        return new ArrayList<>(List.of(molo, alastor, xafan));
    }

    public static List<Monster> getSecondLevelMonsters() {
        Monster sabnac = new Monster("Сабнак", 14, 5, 22, 5, 8,
                "Твой страх - наш праздник, твоя мука - наша песня. Подготовься к пиршеству.");
        String art = "             =*===\n" +
                "                        $$- - $$$\n" +
                "                        $ <    D$$\n" +
                "                        $ -   $$$\n" +
                "                  ,     $$$$  |\n" +
                "                 ///; ,---' _ |----.\n" +
                "                  \\ )(           /  )\n" +
                "                  | \\/ \\.   '  _.|  \\              $\n" +
                "                  |  \\ /(   /    /\\_ \\          $$$$$\n" +
                "                   \\ /  (       / /  )         $$$ $$$\n" +
                "                        (  ,   /_/ ,`_,-----.,$$  $$$\n" +
                "                        |   <----|  \\---##     \\   $$\n" +
                "                        /         \\\\\\           |    $\n" +
                "                       '   '                    |\n" +
                "                       |                 \\      /\n" +
                "                       /  \\_|    /______,/     /\n" +
                "                      /   / |   /    |   |    /\n" +
                "                     (   /--|  /.     \\  (\\  (_\n" +
                "                      `----,( ( _\\     \\ / / ,/\n" +
                "                            | /        /,_/,/\n" +
                "                           _|/        / / (\n" +
                "                          / (        ^-/, |\n" +
                "                         /, |          ^-   \n" +
                "                         ^-\n";
        sabnac.setAsciiArt(art);

        Monster serra = new Monster("Серра", 13, 6, 21, 6, 8,
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

        Monster habaril = new Monster("Хабарил", 12, 7, 24, 4, 10,
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
                "                         |#\\      -\" \n" +
                "                          -\"\n";
        habaril.setAsciiArt(art);

        return new ArrayList<>(List.of(sabnac, serra, habaril));
    }

    public static List<Monster> getThirdLevelMonsters() {
        Monster leviafan = new Monster("Левиафан", 17, 9, 27, 8, 11,
                "Твоя жизнь - всего лишь мгновение вечности. Ты угаснешь, но это ничего не изменит.");
        String art = "                                                 __----~~~~~~~~~~~------___\n" +
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

        Monster citry = new Monster("Ситри", 16, 8, 26, 3, 14,
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

        Monster sartaganas = new Monster("Сартаганас", 14, 12, 28, 6, 12,
                "Ты глупец, если решил, что действительно способен меня одолеть.");
        art =   "              .:'                                  `:.\n" +
                "             ::'                                    `::\n" +
                "            :: :.                                  .: ::\n" +
                "             `:. `:.             .             .:'  .:'\n" +
                "              `::. `::           !           ::' .::'\n" +
                "                  `::.`::.    .' ! `.    .::'.::'\n" +
                "                    `:.  `::::'':!:``::::'   ::'\n" +
                "                    :'*:::.  .:' ! `:.  .:::*`:\n" +
                "                   :: HHH::.   ` ! '   .::HHH ::\n" +
                "                  ::: `H TH::.  `!'  .::HT H' :::\n" +
                "                  ::..  `THHH:`:   :':HHHT'  ..::\n" +
                "                  `::      `T: `. .' :T'      ::'\n" +
                "                    `:. .   :         :   . .:'\n" +
                "                      `::'               `::'\n" +
                "                        :'  .`.  .  .'.  `:\n" +
                "                        :' ::.       .:: `:\n" +
                "                        :' `:::     :::' `:\n" +
                "                         `.  ``     ''  .'\n" +
                "                          :`...........':\n" +
                "                          ` :`.     .': '\n" +
                "                           `:  `\"\"\"'  :";
        sartaganas.setAsciiArt(art);

        return new ArrayList<>(List.of(leviafan, citry, sartaganas));
    }

    public static List<Player> getInitialHeroes() {
        Item club = new Item("Дубина", "Её тяжелый, дубовый ствол напоминает могучее древо, сжимающее корни в земле, готовое расколоть неверного врага вдребезги.",
                ParameterAffected.DAMAGE, 2);
        Item cape = new Item("Тканевый плащ", "Легкий и ветреный, он словно мягкая объятия ночи. Его ткань колышется в ритме твоих шагов, придавая загадочности и уверенности в этом опасном мире.",
                ParameterAffected.BLOCK, 1);
        Item dagger = new Item("Кинжал", "Этот железный кинжал словно молния, мгновенно рвущая врагов, исчезающая так же быстро, как появилась.",
                ParameterAffected.ATTACK, 1);

        Player hero_1 = new Player("Картикея", 11, 15, 29, 4, 8);
        hero_1.addItem(club);

        Player hero_2 = new Player("Ганеша", 16, 11, 24, 8, 12);
        hero_2.addItem(cape);

        Player hero_3 = new Player("Сканда", 13, 13, 26, 7, 11);
        hero_3.addItem(dagger);
        List<Player> heroes = new ArrayList<>(List.of(hero_1, hero_2, hero_3));

        return heroes;
    }

    public static List<Item> getFirstLevelTreasures() {
        Item sword = new Item("Меч Фазара", "Горячая сталь этого меча сверкает в руках, как пламя дракона. Его клинок способен разрушить любое зло, которое посмеет встать на твоем пути.",
                ParameterAffected.DAMAGE, 3);
        Item fire_shield = new Item("Пламенный щит", "Его пламя горит ярче, чем тысячи звезд. Этот щит будет твоей надежной защитой, в которую ни один ужас не проникнет.",
                ParameterAffected.BLOCK, 2);
        Item thorns_heart = new Item("Сердце Торна", "Когда-то этот артефакт бился в груди великого война. " +
                "Когда он был побежден, силы тьмы колдовством использовали его энергию для восполнения жизненных сил. " +
                "Теперь же это сердце наполняет твою душу силой и мудростью, необходимой для победы над злом.",
                ParameterAffected.MAX_HEALTH, 2);
        return new ArrayList<>(List.of(sword, fire_shield, thorns_heart));
    }

    public static List<Item> getSecondLevelTreasures() {
        Item cinades_medallion = new Item("Медальон Цинада", "Его изящная цепочка касается твоей груди, словно прикасаясь к самой сути твоей души. " +
                "Этот медальон обещает тебе верность и помощь в самый тяжелый час.",
                ParameterAffected.ATTACK, 3);
        Item seal_of_chaos = new Item("Печать Хаоса", "Она сияет мрачными силами, готовыми развязать апокалипсис. " +
                "Её сила - твоя власть, но будь осторожен, она может стать и твоим проклятием.",
                ParameterAffected.MAX_HEALTH, 5);
        Item ferogs_staff = new Item("Посох Ферога", "Древний посох, который словно изгибается под твоей волей. Его конец сверкает магическими символами, готовыми исполнить любую твою команду.",
                ParameterAffected.DAMAGE, 4);
        return new ArrayList<>(List.of(cinades_medallion, seal_of_chaos, ferogs_staff));
    }

    public static List<Item> getThirdLevelTreasures() {
        Item cyirs_sphere = new Item("Сфера неуязвимости Киира", "Она окружает тебя мистической силой, создавая непроницаемый барьер между тобой и опасностью. " +
                "В ней сосредоточена сила богов, и она будет твоим щитом в самые темные моменты твоего приключения.",
                ParameterAffected.BLOCK, 8);
        Item masters_shoulders = new Item("Наплечники древнего мастера", "Эти наплечники несут в себе мудрость и мастерство вековых героев. " +
                "Их кожа словно переплетена временем, а узоры на них напоминают таинственные руны старинных эльфов.",
                ParameterAffected.ATTACK, 13);
        Item fragments = new Item("Осколки души Саргатанаса", "Это осколки темной и разрушительной души одного из самых могущественных злодеев, когда-либо проклинающего этот мир. " +
                "Они сверкают зловещим сиянием, словно сама абсолютная злая сущность. Посмотри в их отражение и обрети мощь, доселе невиданную.",
                ParameterAffected.MAX_HEALTH, 12);
        return new ArrayList<>(List.of(cyirs_sphere, masters_shoulders, fragments));
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
            input = Main.scanner.nextLine();
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

        Main.current_hero.addItem(selectedItem);
        System.out.println("[!] Вы выбрали предмет " + selectedItem + ".\n");
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

        while (!current_monster.isDead() && !Main.current_hero.isDead()) {
            System.out.println("[!] Вы атакуете, нажмите \"ENTER\" для нанесения удара");
            Main.scanner.nextLine();

            int damageDone = Main.current_hero.attack(current_monster);
            System.out.println("[!] Атака нанесла " + damageDone + " урона! У монстра осталось " + current_monster.getHealth() + " здоровья.");

            if (current_monster.isDead()) {
                System.out.println("[!] Игрок " + Main.current_hero.getName() + " побеждает монстра " + current_monster.getName() + "!\n");
                return true;
            }

            System.out.println("[!] Монстр атакует в ответ, нажмите \"ENTER\", чтобы продолжить");
            Main.scanner.nextLine();

            damageDone = current_monster.attack(Main.current_hero);
            System.out.println("[!] Атака нанесла " + damageDone + " урона! У вас осталось " + Main.current_hero.getHealth() + " здоровья!");

            if (Main.current_hero.isDead()) {
                System.out.println("[!] Монстр " + current_monster.getName() + " рызрывает игрока в клочья! Конец игры...\n");
                return false;
            }

            if (Main.current_hero.isHealingAvailable()) {
                String input = "heal";
                System.out.println("[!] Здоровье игрока: [" + Main.current_hero.getHealth() + "/" + Main.current_hero.getMaxHealth() + "].\n");
                while (!input.equalsIgnoreCase("") && Main.current_hero.isHealingAvailable()) {
                    System.out.println("\tВведите \"heal\", чтобы применить лечебное зелье или нажмите \"ENTER\", чтобы продолжить. Осталось зелий: " + Main.current_hero.getHealLeft());
                    System.out.print("-> ");
                    input = Main.scanner.nextLine();
                    if (input.equalsIgnoreCase("heal")) {
                        Main.current_hero.heal();
                        System.out.println("\t[!] Здоровье восстановлено, текущее здоровье: [" + Main.current_hero.getHealth() + "/" + Main.current_hero.getMaxHealth() + "].\n");
                    }
                }
            }
        }

        return true;
    }

    public static boolean mainBossFight() throws InterruptedException {
        Monster tarakasura = new Monster("Таракасура", 21, 16, 38, 8, 15,
                "С нашей последней встречи прошло много времени, " + Main.current_hero.getName() + ".\n" +
                        "\tЯ думаю, ты недооцениваешь свою ничтожность по сравнению со мной. Я - сама смерть,\n" +
                        "\tразрушитель миров. Подходи - и я превращу в руины и твой!");
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

        while (!tarakasura.isDead() && !Main.current_hero.isDead()) {
            System.out.println("[!] Вы атакуете, нажмите \"ENTER\" для нанесения удара");
            Main.scanner.nextLine();

            int damageDone = Main.current_hero.attack(tarakasura);
            System.out.println("[!] Атака нанесла " + damageDone + " урона! У монстра осталось " + tarakasura.getHealth() + " здоровья.");

            if (tarakasura.isDead()) {
                System.out.println("[!] Игрок " + Main.current_hero.getName() + " побеждает монстра " + tarakasura.getName() + "!\n");
                return true;
            }

            System.out.println("[!] Монстр атакует в ответ, нажмите \"ENTER\", чтобы продолжить");
            Main.scanner.nextLine();

            damageDone = tarakasura.attack(Main.current_hero);
            System.out.println("[!] Атака нанесла " + damageDone + " урона! У вас осталось " + Main.current_hero.getHealth() + " здоровья!");

            if (Main.current_hero.isDead()) {
                System.out.println("[!] Монстр " + tarakasura.getName() + " рызрывает игрока в клочья! Конец игры...\n");
                return false;
            }

            if (Main.current_hero.isHealingAvailable()) {
                String input = "heal";
                System.out.println("[!] Здоровье игрока: [" + Main.current_hero.getHealth() + "/" + Main.current_hero.getMaxHealth() + "].\n");
                while (input.equalsIgnoreCase("heal") && Main.current_hero.isHealingAvailable()) {
                    System.out.println("\t[!] Введите \"heal\", чтобы применить лечебное зелье или нажмите \"ENTER\", чтобы продолжить. Осталось зелий: " + Main.current_hero.getHealLeft());
                    System.out.print("-> ");
                    input = Main.scanner.nextLine();
                    if (input.equalsIgnoreCase("heal")) {
                        Main.current_hero.heal();
                        System.out.println("\t[!] Здоровье восстановлено, текущее здоровье: [" + Main.current_hero.getHealth() + "/" + Main.current_hero.getMaxHealth() + "].\n");
                    }
                }
            }
        }

        return true;
    }

    public static void printRules() throws InterruptedException {
        String rules = "[ПРАВИЛА] Вы играете за война, что ищет мщения. Чтобы победить Таракасуру, вы должны одолеть его приспешников.\n" +
                "\t* При встрече с монстром вы будете атаковать друг друга. Механика атаки работает с помощью бросков кубика. Каждый из участников\n" +
                "\tвыполняет N бросков кубика, где N = (атака атакующего) - (защита цели атаки) + 1. Выполняется минимум 1 бросок.\n" +
                "\tАтака считается успешной и наносит урон, если хотя бы на одном из кубиков выпало значение 5 или 6.\n" +
                "\t* В момент боя после атаки врага вы сможете воспользоваться зельем лечения. Оно излечит вам 30% от максимального здоровья.\n" +
                "\tВсего у вас имеется 4 зелья.\n" +
                "\t* После победы над монстром вам будет предложено выбрать один из нескольких предметов, что даст вам усиление в дальнейшем.\n";
        printSlowPhrase(rules, 35);
    }

    public static void gameEnding() throws InterruptedException {
        String finalMessage = "[" + Main.current_hero.getName() + "] Моя самая сильная вера родилась из самых темных испытаний.\n" +
                "\tМоя семья, я отомстила за вас. Я принесла им столько же страданий, сколько они мне тогда. Жаль, что\n" +
                "\tя никогда вас уже никогда не верну. По крайней мере моя цель достигнута, а я осталась человеком\n" +
                "\tв борьбе с монстрами.";
        printSlowPhrase(finalMessage, 25);

        finalMessage = "[============ THE END ============]";
        printSlowPhrase(finalMessage, 45);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
