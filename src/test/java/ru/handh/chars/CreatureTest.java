package ru.handh.chars;

import org.junit.jupiter.api.Test;
import ru.handh.objects.Item;
import ru.handh.util.ParameterAffected;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    @Test
    void nameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Creature creature = new Creature(null, 10, 9, 8, 7, 10);
                });
    }

    @Test
    void attackNotInRange() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Creature creature = new Creature("SomeName", -10, 9, 8, 7, 10);
                });
    }

    @Test
    void blockNotInRange() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Creature creature = new Creature("SomeName", 10, 32, 8, 7, 10);
                });
    }

    @Test
    void maxHealthIsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Creature creature = new Creature("SomeName", 10, 32, 0, 7, 10);
                });
    }

    @Test
    void damageMinGreaterThanDamageMax() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Creature creature = new Creature("SomeName", 10, 32, 0, 10, 7);
                });
    }

    @Test
    void damageBiggerThanHP() {
        Monster monster = new Monster("Leviafan", 10, 4, 20, 3, 14, "Leviafan - elder dragon of deep waters");
        monster.makeDamage(45);
        assertEquals(0, monster.getHealth());
    }

    @Test
    void givenItemGivesMoreAttackThan30() {
        Player player = new Player("Jack", 20, 10, 18, 4, 5);
        Item item = new Item("Divine Sword", "Elder sword of hero with no name", ParameterAffected.ATTACK, 20);

        player.addItem(item);
        assertEquals(30, player.getAttack());
    }

}