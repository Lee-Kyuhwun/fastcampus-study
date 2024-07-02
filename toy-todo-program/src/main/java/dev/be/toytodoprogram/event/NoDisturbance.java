package dev.be.toytodoprogram.event;

import dev.be.toytodoprogram.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

public class NoDisturbance extends AbstactEvent{
    public NoDisturbance(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    @Override
    protected void update1(AbstractAuditableEvent event) {
        return;
    }

    @Override
    public void print() {

    }

    @Override
    public boolean supports(EventType eventType) {
        return eventType == EventType.NO_DISTURBANCE;
    }
}
