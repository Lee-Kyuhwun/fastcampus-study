package dev.be.toytodoprogram.event;

public interface Event {

    void print();

    boolean supports(EventType eventType);
}
