package com.promineotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TestDemoJUnitTest {

    private TestDemo testDemo;

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() ->
                testDemo.addPositive(a, b)
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            arguments(2, 3, 5, false),    // 2 + 3 = 5, no exception expected
            arguments(0, 4, 0, true),    // Zero, exception expected
            arguments(4, -4, 0, true),   // Negative, exception expected
            arguments(7, 0, 0, true)     // Zero, exception expected
            // Add more test cases as needed
        );
    }

    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        // Add more test cases as needed
    }

    // Step 3: Custom method test added below
    @Test
    void assertThatNumbersAreMultipliedCorrectly() {
        assertThat(testDemo.multiply(4, 5)).isEqualTo(20);
        assertThat(testDemo.multiply(0, 50)).isEqualTo(0);
        // Add more test cases as needed
    }

    @Test
    void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();
        int fiveSquared = mockDemo.randomNumberSquared();
        assertThat(fiveSquared).isEqualTo(25);
    }

    // Step 4-2: Test for randomNumberSquared added above
}
