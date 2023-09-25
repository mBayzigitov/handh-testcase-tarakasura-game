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
                    setAttack(Math.min(attack + item.getBuffValue(), 30)); // 30 - maximum value of attack param
                }
                case BLOCK -> {
                    setBlock(Math.min(block + item.getBuffValue(), 30)); // 30 - maximum value of block param
                }
                case MAX_HEALTH -> {
                    setMaxHealth(maxHealth + item.getBuffValue());
                }
                case DAMAGE -> {
                    setDamageMax(damageMax + item.getBuffValue());
                    setDamageMin(damageMin + item.getBuffValue());
                }
            }
        }
    }

    public int getHealLeft() {
        return healLeft;
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
                    setAttack(Math.min(attack + item.getBuffValue(), 30)); // 30 - maximum value of attack param
                }
                case BLOCK -> {
                    setBlock(Math.min(block + item.getBuffValue(), 30)); // 30 - maximum value of block param
                }
                case MAX_HEALTH -> {
                    setMaxHealth(maxHealth + item.getBuffValue());
                }
                case DAMAGE -> {
                    setDamageMax(damageMax + item.getBuffValue());
                    setDamageMin(damageMin + item.getBuffValue());
                }
            }
        }
    }

    public void addItem(Item item) {
        items.add(item);

        switch (item.getParameterAffected()) {
            case ATTACK -> {
                setAttack(Math.min(attack + item.getBuffValue(), 30)); // 30 - maximum value of attack param
            }
            case BLOCK -> {
                setBlock(Math.min(block + item.getBuffValue(), 30)); // 30 - maximum value of block param
            }
            case MAX_HEALTH -> {
                setMaxHealth(maxHealth + item.getBuffValue());
            }
            case DAMAGE -> {
                setDamageMax(damageMax + item.getBuffValue());
                setDamageMin(damageMin + item.getBuffValue());
            }
        }
    }

    public boolean isHealingAvailable() {
        return (healLeft > 0);
    }

    @Override
    public String toString() {
        return name +
                "\n\tАтака: " + attack + ". " +
                "Защита: " + block + ". " +
                "Здоровье: " + maxHealth + ". " +
                "Урон: " + damageMin + "-" + damageMax + ".\n" +
                "\tПредметы: " + items.toString();
    }
}
