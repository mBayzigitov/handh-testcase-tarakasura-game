package ru.handh.chars;

import ru.handh.objects.Item;

public class Player extends Creature {
    protected int healLeft = 4;
    protected Item item;

    public Player() {}

    public Player(String name, int attack, int block, int maxHealth, int damageMin, int damageMax) {
        super(name, attack, block, maxHealth, damageMin, damageMax);
    }

    public Player(String name, int attack, int block, int maxHealth, int damageMin, int damageMax, Item item) {
        super(name, attack, block, maxHealth, damageMin, damageMax);
        this.item = item;
    }

    public void heal() {
        if (!this.isDead()) {
            if (health + maxHealth * 0.3 >= maxHealth) {
                health = maxHealth;
            } else {
                health += maxHealth * 0.3;
            }

            healLeft--;
        }
    }

    public boolean isHealingAvailable() {
        return (healLeft > 0);
    }
}
