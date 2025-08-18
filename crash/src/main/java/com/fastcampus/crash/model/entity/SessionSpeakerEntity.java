package com.fastcampus.crash.model.entity;

import com.fastcampus.crash.model.user.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.ZonedDateTime;
import java.util.Collection;

@Entity
// user라는 테이블이 이미 존재하기 때문에 쌍따옴표를 추가하여 생성할 수 있도록 함
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "sessionspeaker") // 테이블 이름을 지정
public class SessionSpeakerEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speakerId;

    @Column(nullable = false)
    private String company ;


    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    // columnDefinition = "TEXT"는 긴 문자열을 저장하기 위해 사용
    // columnDefinition = "TEXT"는 데이터베이스에서 이 컬럼이 TEXT 타입임을 명시
    private String description;

    @Column(nullable = false)
    private String profile;

    public static SessionSpeakerEntity of(String company, String name, String description) {
        SessionSpeakerEntity sessionSpeakerEntity = new SessionSpeakerEntity();
        sessionSpeakerEntity.setCompany(company);
        sessionSpeakerEntity.setName(name);
        sessionSpeakerEntity.setDescription(description);
        sessionSpeakerEntity.setProfile(
                "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png" // 기본 프로필 이미지 URL
        );
        return sessionSpeakerEntity;
    }

}
