package com.fastcampus.crash.repository;


import com.fastcampus.crash.model.entity.CrashSessionEntity;
import com.fastcampus.crash.model.entity.RegistrationEntity;
import com.fastcampus.crash.model.entity.SessionSpeakerEntity;
import com.fastcampus.crash.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationEntityRepository extends JpaRepository<RegistrationEntity, Long> {

    List<RegistrationEntity> findBySessionSpeakerId(Long sessionSpeakerId);

    List<RegistrationEntity> findByUser(UserEntity user);

    Optional<RegistrationEntity> findByRegistrationIdAndUser(Long registrationId, UserEntity user);


    // User와 SessionSpeaker로 RegistrationEntity 찾기
    Optional<RegistrationEntity> findByUserAndSession(UserEntity user, CrashSessionEntity session);


}
