package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class PasswordValidatorTest {
    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.") // 테스트코드의 의도를 나타낸다.
    @Test
    void validatePasswordTest(){
        assertThatCode(()->PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException(); // 예외가 발생하지 않는다.
    }


    @DisplayName("비밀번호가 8자 미만 12자 초과하는 경우 IllegalArgumentException 에러가 발생한다.")
    @ParameterizedTest // 여러개의 인자를 받아서 테스트를 수행한다.
    @ValueSource(strings = {"aabbcce","aabbccddeeffg"}) // 경계값에 대한 테스트가 있어야한다.
    void validatePasswordTest2(String password){
        assertThatCode(()->PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class) // IllegalArgumentException이 발생한다.
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
