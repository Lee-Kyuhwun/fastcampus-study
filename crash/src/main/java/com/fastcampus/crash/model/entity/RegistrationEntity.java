package com.fastcampus.crash.model.entity;

import com.fastcampus.crash.model.crashsession.CrashSessionCategory;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
// user라는 테이블이 이미 존재하기 때문에 쌍따옴표를 추가하여 생성할 수 있도록 함
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "registration",
    indexes = {
        @Index(
                name = "registration_user_session_idx",
                columnList = "user_id, session_id",
                unique = true // user_id와 session_id의 조합이 유일해야 함을 명시
        )
    }
) // 테이블 이름을 지정
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private CrashSessionEntity session;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private ZonedDateTime createdDateTime;


    public static RegistrationEntity of(UserEntity user, CrashSessionEntity sessionEntity) {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setUser(user);
        registrationEntity.setSession(sessionEntity);
        return registrationEntity;
    }

    @PrePersist// DB에 insert 되기 직전에 실행
    public void prePersist() {
        this.createdDateTime = ZonedDateTime.now();
    }
}