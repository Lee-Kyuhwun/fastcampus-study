package com.fastcampus.crash.service;


import com.fastcampus.crash.exception.crashsession.CrashSessionNotFoundException;
import com.fastcampus.crash.model.crashsession.CrashSession;
import com.fastcampus.crash.model.crashsession.CrashSessionPatchRequestBody;
import com.fastcampus.crash.model.crashsession.CrashSessionPostRequestBody;
import com.fastcampus.crash.model.entity.CrashSessionEntity;
import com.fastcampus.crash.model.entity.SessionSpeakerEntity;
import com.fastcampus.crash.repository.CrashSessionEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrashSessionService {

    private final CrashSessionEntityRepository crashSessionEntityRepository;
    private final SessionSpeakerService sessionSpeakerService;

    public List<CrashSession> getCrashSessions() {
        var crashSessionEntities = crashSessionEntityRepository.findAll();
        return crashSessionEntities.stream().map(CrashSession::from).toList();
    }


    public CrashSession getCrashSessionBySessionId(Long sessionId) {
        var crashSessionEntity = getCrashSessionEntityBySessionId(sessionId);
        return CrashSession.from(crashSessionEntity);
    }

    public CrashSession createCrashSession(CrashSessionPostRequestBody crashSessionPostRequestBody) {

        var sessionSpeakerEntity = sessionSpeakerService.getSessionSpeakerEntityBySpeakerId(crashSessionPostRequestBody.speakerId());


        CrashSessionEntity crashSessionEntity = CrashSessionEntity.of(
                crashSessionPostRequestBody.title(),
                crashSessionPostRequestBody.body(),
                crashSessionPostRequestBody.category(),
                crashSessionPostRequestBody.dateTime(),
                sessionSpeakerEntity
        );


        return CrashSession.from(crashSessionEntityRepository.save(crashSessionEntity));
    }


    public CrashSession updateCrashSession(
            Long sessionId,
            CrashSessionPatchRequestBody crashSessionPostRequestBody) {


        CrashSessionEntity crashSessionEntityBySessionId = getCrashSessionEntityBySessionId(sessionId);

        if(!ObjectUtils.isEmpty(crashSessionPostRequestBody.title())){
            crashSessionEntityBySessionId.setTitle(crashSessionPostRequestBody.title());
        }
        if(!ObjectUtils.isEmpty(crashSessionPostRequestBody.body())){
            crashSessionEntityBySessionId.setBody(crashSessionPostRequestBody.body());
        }
        if(!ObjectUtils.isEmpty(crashSessionPostRequestBody.category())){
            crashSessionEntityBySessionId.setCategory(crashSessionPostRequestBody.category());
        }
        if(!ObjectUtils.isEmpty(crashSessionPostRequestBody.dateTime())){
            crashSessionEntityBySessionId.setDateTime(crashSessionPostRequestBody.dateTime());
        }
        if(!ObjectUtils.isEmpty(crashSessionPostRequestBody.speakerId())){
            SessionSpeakerEntity sessionSpeakerEntity = sessionSpeakerService.getSessionSpeakerEntityBySpeakerId(crashSessionPostRequestBody.speakerId());
            crashSessionEntityBySessionId.setSpeaker(sessionSpeakerEntity);
        }

        return CrashSession.from(crashSessionEntityRepository.save(crashSessionEntityBySessionId));

    }


    public void deleteSession(
            Long sessionId) {

        var crashSessionEntity = getCrashSessionEntityBySessionId(sessionId);
        crashSessionEntityRepository.delete(crashSessionEntity);
    }

    private CrashSessionEntity getCrashSessionEntityBySessionId(Long sessionId) {
        return crashSessionEntityRepository.findById(sessionId)
                .orElseThrow(
                        () -> new CrashSessionNotFoundException(sessionId)
                );
    }

}
