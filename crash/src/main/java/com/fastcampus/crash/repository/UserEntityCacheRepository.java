package com.fastcampus.crash.repository;


import com.fastcampus.crash.model.entity.UserEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserEntityCacheRepository {

    private RedisTemplate<String, UserEntity> userEntityRedisTemplate;

    public void setUserEntityCache(UserEntity userEntity){
        String redisKey = getRedisKey(userEntity.getUsername());

        userEntityRedisTemplate.opsForValue().set(redisKey, userEntity);
    }
    
    public Optional<UserEntity> getUserEntityCache(String userName){
        String redisKey = getRedisKey(userName);
        return Optional.ofNullable(userEntityRedisTemplate.opsForValue().get(redisKey));
    }

    private String getRedisKey(String username){
        return "user :"+ username;
    }
    
}
