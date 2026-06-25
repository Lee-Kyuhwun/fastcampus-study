package com.fastcampus.community_feed.domain;

import java.util.Objects;

public class User {

    private final Long id;
    private final String name;
    private final String profileImageUrl;

    public User(Long id, String name, String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }
    // equals와 hashCOde를 오버라이딩하지않으면 메모리 주소값으로 비교하게 되어서 오버라이딩해야함


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
