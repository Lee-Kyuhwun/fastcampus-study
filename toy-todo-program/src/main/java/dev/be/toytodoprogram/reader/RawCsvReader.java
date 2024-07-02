package dev.be.toytodoprogram.reader;

import com.opencsv.CSVReader;
import dev.be.toytodoprogram.event.Meeting;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RawCsvReader {


    public List<Meeting> readMeetings(String path) throws IOException {
        List<Meeting> result = new ArrayList<>();


        // csv 파일을 읽어서 meetings에 추가
        // csv 파일의 각 라인은 회의의 정보를 담고 있음

        List<String[]> read = readAll(path);


        for(int i =0; i<read.size(); i++) {
            if(skipHeader(i)) continue;

            result.add(
                    new Meeting(
                            Integer.parseInt(read.get(i)[0]),
                            read.get(i)[1],
                            ZonedDateTime.of(LocalDateTime.parse(read.get(i)[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), ZoneId.of("Asia/Seoul")),
                            ZonedDateTime.of(LocalDateTime.parse(read.get(i)[6], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), ZoneId.of("Asia/Seoul")),
                            new HashSet<>(Arrays.asList(read.get(i)[2].split(","))),
                            read.get(i)[3],
                            read.get(i)[4]
                    )
            );

        }



        return result;
    }

    private static boolean skipHeader(int i) {
        return i == 0;
    }

    private List<String[]> readAll(String path) throws IOException {

        InputStream in = getClass().getResourceAsStream(path);
        InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);

        CSVReader csvReader = new CSVReader(reader);
        return csvReader.readAll();
    }
}
