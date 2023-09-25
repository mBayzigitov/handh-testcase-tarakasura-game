package ru.handh.objects;

import org.junit.jupiter.api.Test;
import ru.handh.chars.Creature;
import ru.handh.util.ParameterAffected;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void itemBuffLessThanZero() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Item item = new Item("SomeItem", "Description", ParameterAffected.DAMAGE, -10);
                });
    }

    @Test
    void nameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Item item = new Item(null, "Description", ParameterAffected.DAMAGE, 15);
                });
    }

    @Test
    void descriptionIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Item item = new Item("SomeName", null, ParameterAffected.DAMAGE, 15);
                });
    }

}