package org.example.grade;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GradeCalculatorTest {
    // 학점 계산기 도메인: 이수한 과목, 학점 계산기
    // 객체지향프로그래밍: -=---> 과목(코스) 클래스

    // 이수한 과목을 전달하려 평균학점 계산 ----> 학점 계산기에게 요청 ---> 학점수* 교과목 평점의 합계


    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP",3,"A+"),
                new Course("WEB",2,"A"));

        GradeCalculator gradeCalculator = new GradeCalculator();
        double grade = gradeCalculator.calculateGrade(courses);
    }
}
