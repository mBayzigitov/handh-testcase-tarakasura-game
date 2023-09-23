package ru.handh.chars;

import ru.handh.util.GameplayOperations;

public class Creature {
    protected String name;
    protected int attack;
    protected int block;
    protected int health;
    protected int damageMin, damageMax;

    public Creature() {}

    public Creature(String name, int attack, int block, int health, int damageMin, int damageMax) {
        this.name = name;

        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("The attack parameter must be in the [1,30] range");
        } else {
            this.attack = attack;
        }

        if (block < 1 || block > 30) {
            throw new IllegalArgumentException("The attack parameter must be in the [1,30] range");
        } else {
            this.block = block;
        }

        if (health < 1) {
            throw new IllegalArgumentException("The creature must have initial health more than 0");
        } else {
            this.health = health;
        }

        if (damageMax < damageMin || damageMin < 0) {
            throw new IllegalArgumentException("Damage boundaries must be within the range " +
                    "(minimal damage must be less or equal than maximum damage) " +
                    "and positive");
        } else {
            this.damageMin = damageMin;
            this.damageMax = damageMax;
        }
    }

    public int attack(Creature target) {
        int attackModifier = calculateAttackModifier(this, target);

        // if one of the several dice rolls gave 5/6 -> make damage to target of attack ; else -> consider an attack a failure
        if (GameplayOperations.severalDiceRolls(attackModifier)) {
            int damageDone = GameplayOperations.pickNumberInRange(damageMin, damageMax);
            target.makeDamage(damageDone);
            return damageDone;
        }

        return 0;
    }

    protected int calculateAttackModifier(Creature attacker, Creature target) {
        int modifier = attacker.getAttack() - target.getBlock() + 1;
        return Math.max(modifier, 1); // return 1 dice roll if calculated modifier is less than 0, modifier otherwise
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("The attack parameter must be in the [1,30] range");
        } else {
            this.attack = attack;
        }
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        if (block < 1 || block > 30) {
            throw new IllegalArgumentException("The attack parameter must be in the [1,30] range");
        } else {
            this.block = block;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) { // set 0 -> death of creature
            throw new IllegalArgumentException("The creature must have initial health more than 0");
        } else {
            this.health = health;
        }
    }

    public void makeDamage(int damageRecieved) {
        health = (damageRecieved >= health) ? 0 : health - damageRecieved;
    }

    public boolean isDead() {
        return (health == 0);
    }

    public int getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(int damageMin) {
        if (damageMax < damageMin || damageMin < 0) {
            throw new IllegalArgumentException("Damage boundaries must be within the range " +
                    "(minimal damage must be less or equal than maximum damage) " +
                    "and positive");
        } else {
            this.damageMin = damageMin;
        }
    }

    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        if (damageMax < damageMin || damageMax < 0) {
            throw new IllegalArgumentException("Damage boundaries must be within the range " +
                    "(minimal damage must be less or equal than maximum damage) " +
                    "and positive");
        } else {
            this.damageMax = damageMax;
        }
    }
}
