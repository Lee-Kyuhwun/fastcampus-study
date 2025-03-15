package com.fastcampus.crash.model.user;

import com.fastcampus.crash.model.entity.UserEntity;

public record User(Long userId, String username, String password, String email) {
    public static User from(UserEntity userEntity) {
        return new User(
                userEntity.getUserId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail()
        );
    }
}