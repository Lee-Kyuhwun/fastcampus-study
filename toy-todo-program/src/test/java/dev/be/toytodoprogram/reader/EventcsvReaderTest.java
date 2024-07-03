package dev.be.toytodoprogram.reader;

import dev.be.toytodoprogram.event.Meeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class EventcsvReaderTest {

    @InjectMocks
    EventcsvReader eventcsvReader;



    @Test
    public void reader() throws IOException {
        // Given
        String path="";
        EventcsvReader reader = new EventcsvReader();

        List<Meeting> meetings = reader.readMeetings(path);








        reader.read("src/test/resources/event.csv");
        assertEquals(2, reader.getEvents().size());
    }
}