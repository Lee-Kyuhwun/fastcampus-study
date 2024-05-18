package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest
{
    @DisplayName("패스워드 초기화 여부를 판단한다. ")
    @Test
    void passwordTest() {
        // Given
        User user = new User();
        // When
        user.initPassword(new CorrectFixedPasswordGenerator());
        // funtional interface 이용
        //user.initPassword(()->"serverwizard");

        // Then
        assertThat(user.getPassword()).isNotNull();

    }
    @DisplayName("패스워드가 요구사항에 부합하지않음. ")
    @Test
    void passwordFailTest() {
        // Given
        User user = new User();
        // When
        user.initPassword(new WrongFixedPasswordGenerator());
        // funtional interface 이용
        //user.initPassword(()->"123");
        // Then
        assertThat(user.getPassword()).isNull();

    }
}