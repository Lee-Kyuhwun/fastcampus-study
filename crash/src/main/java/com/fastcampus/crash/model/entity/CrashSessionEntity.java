package com.fastcampus.crash.model.entity;

import com.fastcampus.crash.model.crashsession.CrashSessionCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Entity
// user라는 테이블이 이미 존재하기 때문에 쌍따옴표를 추가하여 생성할 수 있도록 함
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "crashsession") // 테이블 이름을 지정
public class CrashSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    // columnDefinition = "TEXT"는 긴 문자열을 저장하기 위해 사용
    // columnDefinition = "TEXT"는 데이터베이스에서 이 컬럼이 TEXT 타입임을 명시
    private String body;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CrashSessionCategory category;


    @Column(nullable = false)
    private ZonedDateTime dateTime;


    @ManyToOne
    @JoinColumn(name = "speakerid", nullable = false)
    private SessionSpeakerEntity speaker;


    public static CrashSessionEntity of(String title, String body, CrashSessionCategory category, ZonedDateTime dateTime, SessionSpeakerEntity speaker) {
        CrashSessionEntity crashSessionEntity = new CrashSessionEntity();
        crashSessionEntity.setTitle(title);
        crashSessionEntity.setBody(body);
        crashSessionEntity.setCategory(category);
        crashSessionEntity.setDateTime(dateTime);
        crashSessionEntity.setSpeaker(speaker);
        return crashSessionEntity;
    }
}