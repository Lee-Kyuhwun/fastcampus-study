package dev.be.toytodoprogram.event;

import java.time.ZonedDateTime;

public class OutofOffice extends AbstactEvent{
    public OutofOffice(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    @Override
    public void print() {

    }
}
