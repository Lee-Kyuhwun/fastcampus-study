package com.fastcampus.crash.service;


import com.fastcampus.crash.error.registration.RegistrationAlreadyExistsException;
import com.fastcampus.crash.error.registration.RegistrationNotFoundException;
import com.fastcampus.crash.model.crashsession.CrashSession;
import com.fastcampus.crash.model.entity.CrashSessionEntity;
import com.fastcampus.crash.model.entity.RegistrationEntity;
import com.fastcampus.crash.model.entity.RegistrationPostRequestBody;
import com.fastcampus.crash.model.entity.UserEntity;
import com.fastcampus.crash.model.registration.Registration;
import com.fastcampus.crash.repository.RegistrationEntityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationEntityRepository registrationEntityRepository;

    @Autowired
    private CrashSessionService crashSessionService;

    public List<Registration> getRegistrationsByCurrentUser(UserEntity currentUser) {

        List<RegistrationEntity> registrationEntities = registrationEntityRepository.findByUser(currentUser);
        return registrationEntities.stream().map(Registration::from).toList();
    }

    public Registration getRegistrationsByIdBuCurrentUser(Long registrationId, UserEntity currentUser) {
        RegistrationEntity registrationEntity = getRegistrationEntityByIdAndUserEntity(registrationId, currentUser);
        return Registration.from(registrationEntity);
    }


    public RegistrationEntity getRegistrationEntityByIdAndUserEntity(Long registrationId, UserEntity currentUser) {
        return registrationEntityRepository.findByRegistrationIdAndUser(registrationId, currentUser)
                .orElseThrow(() -> new RegistrationNotFoundException(registrationId, currentUser));
    }

    public Registration createReigstrationByCurrentUser(@Valid RegistrationPostRequestBody registrationPostRequestBody, UserEntity currentUser) {

        CrashSessionEntity crashSessionBySessionId = crashSessionService.getCrashSessionEntityBySessionId(registrationPostRequestBody.sessionId());

        registrationEntityRepository.findByUserAndSession(currentUser, crashSessionBySessionId)
                .ifPresent(s -> {
                    throw new RegistrationAlreadyExistsException(registrationPostRequestBody.sessionId(), currentUser);
                });
        RegistrationEntity registrationEntity = RegistrationEntity.of(currentUser, crashSessionBySessionId);
        return Registration.from(registrationEntityRepository.save(registrationEntity));
    }

    public void deleteRegistrationByRegistrationIdAndCurrentUser(Long registrationId, UserEntity principal) {
        RegistrationEntity registrationEntity = getRegistrationEntityByIdAndUserEntity(registrationId, principal);
        registrationEntityRepository.delete(registrationEntity);
    }
}
