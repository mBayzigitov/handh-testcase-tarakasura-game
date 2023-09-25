package ru.handh.chars;

public class Monster extends Creature {
    protected String meetingPhrase;

    public Monster() {}

    public String getMeetingPhrase() {
        return meetingPhrase;
    }

    public void setMeetingPhrase(String meetingPhrase) {
        this.meetingPhrase = meetingPhrase;
    }
}
