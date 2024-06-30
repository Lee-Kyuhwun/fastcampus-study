package dev.be.toytodoprogram.event;

import java.time.ZonedDateTime;

public class NoDisturbance extends AbstactEvent{
    public NoDisturbance(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    @Override
    public void print() {

    }
}
