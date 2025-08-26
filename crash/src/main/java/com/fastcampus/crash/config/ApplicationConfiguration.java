package com.fastcampus.crash.config;


import com.fastcampus.crash.model.crashsession.CrashSessionCategory;
import com.fastcampus.crash.model.crashsession.CrashSessionPostRequestBody;
import com.fastcampus.crash.model.sessionspeaker.SessionSpeaker;
import com.fastcampus.crash.model.sessionspeaker.SessionSpeakerPostRequestBody;
import com.fastcampus.crash.model.user.UserSignUpRequestBody;
import com.fastcampus.crash.service.CrashSessionService;
import com.fastcampus.crash.service.SessionSpeakerService;
import com.fastcampus.crash.service.UserService;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.stream.IntStream;

@Configuration
public class ApplicationConfiguration {

    private static final Faker faker = new Faker();

    @Autowired
    private UserService userService;

    @Autowired
    private SessionSpeakerService sessionSpeakerService;
    @Autowired
    private CrashSessionService crashSessionService;

    @Bean
    public ApplicationRunner applicationRunner(){
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                // TODO: 유저 및 세선 스피커 생성
                createTestUser();
                createTestSessionSpeakers(10);
                create
            }
        };
    }

    private void createTestUser(){
        for(int i = 0; i < 10; i++) {
            userService.signUp(new UserSignUpRequestBody(
                    faker.name().name(),
                    faker.internet().password(),
                    faker.name().fullName(),
                    faker.internet().emailAddress()
            ));
        }

    }


    private void createTestSessionSpeakers(int numberOfSpeakers) {
        var sessionSpeakers = IntStream.range(
                // 0부터 numberOfSpeakers까지의 범위
                // mapToObj는 각 인덱스에 대해 createSessionSpeaker()를 호출하여
                // SessionSpeaker 객체를 생성
                0,numberOfSpeakers).mapToObj(i-> createSessionSpeaker()).toList();// 세션 스피커 생성
        // toList()는 스트림을 리스트로 변환
        // toList없으면

    }
    private SessionSpeaker createSessionSpeaker() {
        var name = faker.name().fullName();
        var company = faker.company().name();
        var description = faker.lorem().paragraph();

        return sessionSpeakerService.createSessionSpeaker(
                new SessionSpeakerPostRequestBody(company,name,description)
        );
    }

    private void createTestCrashSessions(SessionSpeaker sessionSpeakers) {
        var title = faker.book().title();
        var body = faker.shakespeare().asYouLikeItQuote();
        crashSessionService.createCrashSession(new CrashSessionPostRequestBody(
                title,
                body,
                getRandomCategory(),
                ZonedDateTime.now().plusDays(new Random().nextInt(2)+1),
                sessionSpeakers.speakerId()
        ));
    }

    private CrashSessionCategory getRandomCategory() {
        var categories = CrashSessionCategory.values();
        return categories[new Random().nextInt(categories.length)];
    }
}
