package ru.handh.chars;

import ru.handh.objects.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Creature {
    protected int healLeft = 4;
    protected List<Item> items = new ArrayList<>();

    public Player() {}

    public Player(String name, int attack, int block, int maxHealth, int damageMin, int damageMax) {
        super(name, attack, block, maxHealth, damageMin, damageMax);
    }

    public Player(String name, int attack, int block, int maxHealth, int damageMin, int damageMax, List<Item> itemList) {
        super(name, attack, block, maxHealth, damageMin, damageMax);

        for (Item item: itemList) {
            switch (item.getParameterAffected()) {
                case ATTACK -> {
                    setAttack(Math.max(attack + item.getBuffValue(), 1));
                }
                case BLOCK -> {
                    setBlock(Math.max(block + item.getBuffValue(), 1));
                }
                case MAX_HEALTH -> {
                    setMaxHealth(Math.max(maxHealth + item.getBuffValue(), 1));
                }
                case DAMAGE -> {
                    setDamageMax(Math.max(damageMax + item.getBuffValue(), 2));
                    setDamageMin(Math.max(damageMin + item.getBuffValue(), 1));
                }
            }
        }
    }

    public int heal() {
        int heal = 0;
        if (!this.isDead()) {
            heal = (int) (maxHealth * 0.3);
            if (health + heal >= maxHealth) {
                health = maxHealth;
            } else {
                health += heal;
            }
            healLeft--;
        }
        return heal;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;

        for (Item item: items) {
            switch (item.getParameterAffected()) {
                case ATTACK -> {
                    setAttack(Math.max(attack + item.getBuffValue(), 1));
                }
                case BLOCK -> {
                    setBlock(Math.max(block + item.getBuffValue(), 1));
                }
                case MAX_HEALTH -> {
                    setMaxHealth(Math.max(maxHealth + item.getBuffValue(), 1));
                }
                case DAMAGE -> {
                    setDamageMax(Math.max(damageMax + item.getBuffValue(), 2));
                    setDamageMin(Math.max(damageMin + item.getBuffValue(), 1));
                }
            }
        }
    }

    public void addItem(Item item) {
        items.add(item);

        switch (item.getParameterAffected()) {
            case ATTACK -> {
                setAttack(Math.max(attack + item.getBuffValue(), 1));
            }
            case BLOCK -> {
                setBlock(Math.max(block + item.getBuffValue(), 1));
            }
            case MAX_HEALTH -> {
                setMaxHealth(Math.max(maxHealth + item.getBuffValue(), 1));
            }
            case DAMAGE -> {
                setDamageMax(Math.max(damageMax + item.getBuffValue(), 2));
                setDamageMin(Math.max(damageMin + item.getBuffValue(), 1));
            }
        }
    }

    public boolean isHealingAvailable() {
        return (healLeft > 0);
    }

    @Override
    public String toString() {
        return "Player{" +
                "item=" + items +
                ", name='" + name + '\'' +
                ", attack=" + attack +
                ", block=" + block +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", damageMin=" + damageMin +
                ", damageMax=" + damageMax +
                '}';
    }
}
