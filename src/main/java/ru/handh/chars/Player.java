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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        if (this.item != null) {
            switch (this.item.getParameterAffected()) {
                case ATTACK -> {
                    attack -= this.item.getBuffValue();
                }
                case BLOCK -> {
                    block -= this.item.getBuffValue();
                }
                case MAX_HEALTH -> {
                    maxHealth -= this.item.getBuffValue();
                }
                case MAX_DAMAGE -> {
                    damageMax -= this.item.getBuffValue();
                }
            }
        }

        this.item = item;

        switch (item.getParameterAffected()) {
            case ATTACK -> {
                attack += item.getBuffValue();
            }
            case BLOCK -> {
                block += item.getBuffValue();
            }
            case MAX_HEALTH -> {
                maxHealth += item.getBuffValue();
            }
            case MAX_DAMAGE -> {
                damageMax += item.getBuffValue();
            }
        }
    }

    public boolean isHealingAvailable() {
        return (healLeft > 0);
    }
}
