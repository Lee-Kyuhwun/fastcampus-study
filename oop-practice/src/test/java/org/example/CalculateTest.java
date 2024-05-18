package org.example;

import org.example.caculate.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 테스트 인스턴스 라이프 사이클을 지정한다.
public class CalculateTest {


    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult") // 메서드 이름을 생략하면, 테스트 메서드 이름이 기본값으로 사용된다.
    void additionTest(int operand1,String operator, int operand2,int result) {

        // Given
        Calculator calculator = new Calculator();
        // When
        int caculateResult = calculator.calculate(operand1,operator, operand2);
        // Then
        assertThat(caculateResult).isEqualTo(result);
    }

    // Stream<Arguments>를 반환하는 정적 메서드를 선언한다.
    //Stream<Arguments란 여러개의 인자를 받아서 테스트를 수행한다.
    // arguments 메서드는 인자를 생성하는 정적 메서드이다.
    public static Stream<Arguments> formulaAndResult(){ //
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(1,"-",2,-1),
                arguments(1,"*",2,2),
                arguments(4,"/",2,2)
        ) ;
    }

}
