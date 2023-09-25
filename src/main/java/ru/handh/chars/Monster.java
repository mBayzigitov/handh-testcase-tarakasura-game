package ru.handh.chars;

public class Monster extends Creature {
    protected String meetingPhrase;
    protected String asciiArt;

    public Monster() {}

    public Monster(String name, int attack, int block, int maxHealth, int damageMin, int damageMax, String meetingPhrase) {
        super(name, attack, block, maxHealth, damageMin, damageMax);
        this.meetingPhrase = meetingPhrase;
    }

    public String getMeetingPhrase() {
        return meetingPhrase;
    }

    public void setMeetingPhrase(String meetingPhrase) {
        this.meetingPhrase = meetingPhrase;
    }

    public String getAsciiArt() {
        return asciiArt;
    }

    public void setAsciiArt(String asciiArt) {
        this.asciiArt = asciiArt;
    }

    @Override
    public String toString() {
        return "[!] Приспешник тьмы - " + name + "\n" +
                "\tАтака: " + attack + ", защита: " + block + ", здоровье: " + maxHealth + ", урон: " + damageMin + "-" + damageMax + ".\n";
    }
}
