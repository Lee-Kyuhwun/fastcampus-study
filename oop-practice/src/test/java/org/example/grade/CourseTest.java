package org.example.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {



    @DisplayName("과목 코스를 생성한다.")
    @Test
    void creatTest() {

        assertThatCode(()->new Course("oop",3,"A+"))
                .doesNotThrowAnyException();
    }
}
