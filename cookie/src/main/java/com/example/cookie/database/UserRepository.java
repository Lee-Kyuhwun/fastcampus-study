package com.example.cookie.database;


import com.example.cookie.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRepository {

    private List<UserDto> userList = new ArrayList<>();


    public Optional<UserDto> findById(String id) {
        return userList.stream().filter(it ->{
            return it.getId().equals(id);
        }).findFirst();
    }

    public Optional<UserDto> findByUserName(String name) {
        return userList.stream().filter(it ->{
                return it.getName().equals(name);
        }).findFirst();
    }


    @PostConstruct // 빈이 호출되면 메서드 호출
    public void init() {
        userList.add(new UserDto(UUID.randomUUID().toString(),"user1", "1234"));
        userList.add(new UserDto(UUID.randomUUID().toString(),"user2", "1234"));
        userList.add(new UserDto(UUID.randomUUID().toString(),"user3", "1234"));
    }


}
