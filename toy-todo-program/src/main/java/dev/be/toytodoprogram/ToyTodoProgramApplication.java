package dev.be.toytodoprogram;

import dev.be.toytodoprogram.event.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;

@SpringBootApplication
public class ToyTodoProgramApplication {

    public static void main(String[] args) {
        Schedule schedule = new Schedule();


        List<AbstactEvent> list= new ArrayList<>();
        HashSet<String> participants = new HashSet<String>();
        participants.add("홍길동");`
        Meeting meeting1 = new Meeting(1, "회의", ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                participants, "회의실", "회의안건");

        schedule.add(meeting1);


        Todo todo1 = new Todo(2, "할일", ZonedDateTime.now(), ZonedDateTime.now().plusHours(2), "할일내용");

        schedule.add(todo1);

        list.stream().forEach(Event::print);


        schedule.print(EventType.MEETING);
        //SpringApplication.run(ToyTodoProgramApplication.class, args);
    }

}
