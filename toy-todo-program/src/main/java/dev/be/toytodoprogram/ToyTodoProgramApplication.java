package dev.be.toytodoprogram;

import dev.be.toytodoprogram.event.*;
import dev.be.toytodoprogram.reader.EventcsvReader;
import dev.be.toytodoprogram.update.UpdateMeeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;

@SpringBootApplication
public class ToyTodoProgramApplication {

    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();
        String meetingCsvPath = "/data/Event.csv";
        EventcsvReader eventcsvReader = new EventcsvReader();

        List<Meeting> meetings = eventcsvReader.readMeetings(meetingCsvPath);

        meetings.forEach(schedule::add);

        meetings.get(0).validateAndUpdate(
                new UpdateMeeting(
                        "회의실 변경",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        new HashSet<>(),
                        "회의실 1",
                        "회의실 변경"
                )
        );

        meetings.get(0).delete(true);

        System.out.println("삭제후");


        meetings.get(0).validateAndUpdate(
                new UpdateMeeting(
                        "회의실 변경",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        new HashSet<>(),
                        "회의실 1",
                        "회의실 변경"
                )
        );

        schedule.printAll();
        //SpringApplication.run(ToyTodoProgramApplication.class, args);
    }

}
