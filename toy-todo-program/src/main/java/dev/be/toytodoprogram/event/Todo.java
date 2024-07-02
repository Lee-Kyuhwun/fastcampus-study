package dev.be.toytodoprogram.event;

import dev.be.toytodoprogram.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

public class Todo extends AbstactEvent{
    private String description;

    public Todo(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt, String description) {
        super(id, title, startAt, endAt);
        this.description = description;
    }

    @Override
    public void print() {
        System.out.printf("할일 : %s :%s\n", getTitle(),this.description);
    }

    @Override
    public boolean supports(EventType eventType) {
        return eventType == EventType.TO_DO;
    }

    @Override
    protected void update1(AbstractAuditableEvent event) {

    }
}
