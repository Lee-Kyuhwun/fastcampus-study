package dev.be.demo5.cal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("numberProvider")
    void sum2(int a, int b, int expected) {
        // given
        Calculator calculator = new Calculator();

        // when
        int actual = calculator.sum(a, b);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(3, 4, 7),
                Arguments.of(5, 6, 11)
        );
    }

    @ParameterizedTest
    @MethodSource("numberProviderForException")
    void sumException(int a, int b) {
        // given
        Calculator calculator = new Calculator();

        // when
        // then
        assertThrows(RuntimeException.class, () -> calculator.sum(a, b));
    }

    static Stream<Arguments> numberProviderForException() {
        return Stream.of(
                Arguments.of(-1, 2),
                Arguments.of(3, -4),
                Arguments.of(-5, -6)
        );
    }


    @Test
    void sum() {
        // given
        Calculator calculator = new Calculator();
        int a= 10;
        int b =5;
        int expected = 15;
        // when
        int actual = calculator.sum(a, b);

        // then
        assertEquals(expected, actual);
    }
}