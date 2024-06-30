package dev.be.toytodoprogram.event;

import java.time.Duration;
import java.time.ZonedDateTime;

public abstract class AbstactEvent implements Event{

    private final int id;

    private String title;

    private ZonedDateTime startAt;
    private ZonedDateTime endAt;

    private Duration duration; // Duration.between(startAt, endAt)

    private boolean deletedYn;

    private final ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;

    protected AbstactEvent(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        this.id = id;
        this.title = title;
        this.startAt = startAt;
        this.endAt = endAt;
        this.duration = Duration.between(startAt, endAt);

        ZonedDateTime now = ZonedDateTime.now();
        this.createdAt = now;
        this.modifiedAt = now;
        this.deletedYn = false;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public ZonedDateTime getStartAt() {
        return startAt;
    }

    public ZonedDateTime getEndAt() {
        return endAt;
    }

    public Duration getDuration() {
        return duration;
    }

    public boolean isDeletedYn() {
        return deletedYn;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }
}
