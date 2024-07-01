package dev.be.toytodoprogram.event;

import java.time.ZonedDateTime;
import java.util.Set;

public class Meeting extends AbstactEvent {

    private Set<String> participants; // 참석자
    private String meetingRoom;
    private String agenda;

    public Meeting(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt,
                   Set<String> participants, String meetingRoom, String agenda) {
        super(id, title, startAt, endAt);
        this.participants = participants;
        this.meetingRoom = meetingRoom;
        this.agenda = agenda;
    }

    public Set<String> getParticipants() {
        return participants;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public String getAgenda() {
        return agenda;
    }

    @Override
    public void print() {
        System.out.printf("회의 : %s :%s\n", getTitle(),this.agenda);
    }

    @Override
    public boolean supports(EventType eventType) {
        return eventType == EventType.MEETING;
    }

    public void meetingMethod() {
        System.out.println("Meeting.meetingMethod");
    }
}
