package ru.handh.chars;

public class Monster extends Creature {
    protected String meetingDescription;

    public Monster() {}

    public String getMeetingDescription() {
        return meetingDescription;
    }

    public void setMeetingDescription(String meetingDescription) {
        this.meetingDescription = meetingDescription;
    }
}
