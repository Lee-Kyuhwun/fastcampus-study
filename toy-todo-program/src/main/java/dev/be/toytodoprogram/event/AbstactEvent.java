package dev.be.toytodoprogram.event;

import dev.be.toytodoprogram.InValidEventException;
import dev.be.toytodoprogram.update.AbstractAuditableEvent;

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


        if(startAt.isAfter(endAt)){
            throw new InValidEventException("시작 시간이 현재 시간보다 이전이어야 합니다.");
        }

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


    public void validateAndUpdate(AbstractAuditableEvent event){
        if(deletedYn== true){
            throw new InValidEventException("이미 삭제된 이벤트입니다.");
        }

        defaultUpdate(event);
        update1(event);
    }

    public void delete(boolean deletedYn){
        this.deletedYn = deletedYn;
    }

    private void defaultUpdate(AbstractAuditableEvent event){

        this.title = event.getTitle();
        this.startAt = event.getStartAt();
        this.endAt = event.getEndAt();
        this.duration = Duration.between(startAt, endAt);
    }

    protected abstract void update1(AbstractAuditableEvent event);

}
