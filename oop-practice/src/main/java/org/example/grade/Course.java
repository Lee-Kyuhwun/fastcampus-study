package org.example.grade;

public class Course {

    private final String grade;
    private final String subject; // 과목
    private final int credit; // 학점
    public Course(String subject, int credit, String grade) {

        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }
}
