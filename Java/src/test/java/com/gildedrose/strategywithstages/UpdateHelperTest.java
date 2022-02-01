package com.gildedrose.strategywithstages;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateHelperTest {
    private static Stream<Arguments> provideDataForIncreaseTests() {
        return Stream.of(
                Arguments.of( 10, 11 ),
                Arguments.of( 0, 1 ),
                Arguments.of( 50, 50 ),
                Arguments.of( 51, 51 )
        );
    }

    private static Stream<Arguments> provideDataForDecreaseTests() {
        return Stream.of(
                Arguments.of( 10, 9 ),
                Arguments.of( 0, 0 ),
                Arguments.of( 50, 49 ),
                Arguments.of( 51, 50 )
        );
    }

    @ParameterizedTest
    @MethodSource("provideDataForIncreaseTests")
    public void testIncreaseQualityWithLimit(int input, int expectedOutput) {
        final int actual = UpdateHelper.increaseQualityWithLimit( input );
        assertEquals( expectedOutput, actual );
    }

    @ParameterizedTest
    @MethodSource("provideDataForDecreaseTests")
    public void testDecreaseQualityWithLimit(int input, int expectedOutput) {
        final int actual = UpdateHelper.decreaseQualityWithLimit( input );
        assertEquals( expectedOutput, actual );
    }
}
