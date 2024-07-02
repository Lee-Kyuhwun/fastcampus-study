package dev.be.toytodoprogram.event;

import dev.be.toytodoprogram.InValidEventException;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<AbstactEvent> events = new ArrayList<>();

    public void add(AbstactEvent event) {
        if (hasScheduleConflictWith(event)) {
            throw new InValidEventException("시간이 겹칩니다.");
        }
        events.add(event);
    }

    public void printAll() {
        events.stream().forEach(Event::print);
    }

    public void print(EventType eventType) {
        events.stream().filter(each -> each.supports(eventType))
                .forEach(Event::print);
    }


    private boolean hasScheduleConflictWith(AbstactEvent event) {
        // 이벤트 리스트에 있는 이벤트들과 시간이 겹치는지 확인
        return events.stream().anyMatch(each -> (each.getStartAt().isBefore(event.getEndAt()) && each.getEndAt().isAfter(event.getStartAt())) ||
                (event.getEndAt().isAfter(each.getStartAt()) && event.getStartAt().isBefore(each.getEndAt()))
        );
    }
}
