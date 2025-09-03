package com.fastcampus.crash.config;


import com.fastcampus.crash.model.crashsession.CrashSession;
import com.fastcampus.crash.model.entity.UserEntity;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

@Configuration
public class CacheConfiguration {
    private static final ObjectMapper objectMapper =
            new ObjectMapper().registerModule(new JavaTimeModule());

    @Bean
    RedisConnectionFactory redisConnectionFactory(
            @Value("${redis.host}") String redisHost, @Value("${redis.port}") int redisPort) {
        var config = new RedisStandaloneConfiguration();
        // 레디스 호스트와 포트 설정
        config.setHostName(redisHost);
        config.setPort(redisPort);
        // LettuceConnectionFactory를 사용하여 RedisConnectionFactory 생성
        return new LettuceConnectionFactory(config);
    }

    // UserEntity를 위한 RedisTemplate 설정
    @Bean
    public RedisTemplate<String, UserEntity> userEntityRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        // UserEntity를 위한 RedisTemplate 설정
        var template = new RedisTemplate<String, UserEntity>();
        // RedisConnectionFactory 설정
        template.setConnectionFactory(redisConnectionFactory);
        // 키와 값의 직렬화 설정 (직렬화 하는 이유 : Redis는 바이트 배열로 데이터를 저장하기 때문)
        template.setKeySerializer(new StringRedisSerializer());
        // UserEntity 객체를 JSON 형태로 직렬화/역직렬화 하기 위해 Jackson2JsonRedisSerializer 사용
        template.setValueSerializer(
                new Jackson2JsonRedisSerializer<UserEntity>(objectMapper, UserEntity.class));
        // redis에서 Json 형태로 데이터를 읽고 쓸 수 있도록 설정
        return template;
    }

    // CrashSession을 위한 RedisTemplate 설정
    @Bean
    public RedisTemplate<String, CrashSession> crashSessionRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        var template = new RedisTemplate<String, CrashSession>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(
                new Jackson2JsonRedisSerializer<CrashSession>(objectMapper, CrashSession.class));
        return template;
    }

    @Bean
    public RedisTemplate<String, List<CrashSession>> crashSessionsListRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        var template = new RedisTemplate<String, List<CrashSession>>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());

        JavaType type =
                objectMapper.getTypeFactory().constructCollectionType(List.class, CrashSession.class);
        template.setValueSerializer(
                new Jackson2JsonRedisSerializer<List<CrashSession>>(objectMapper, type));
        return template;
    }


}
