package com.gildedrose.strategy;

import com.gildedrose.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String OTHER = "Any other item";

    private static Stream<Arguments> provideDataForTests() {
        return Stream.of(
            Arguments.of( new Item( AGED_BRIE, 7, 10 ), new Item( AGED_BRIE, 6, 11) ),
            Arguments.of( new Item( AGED_BRIE, 0, 10 ), new Item( AGED_BRIE, -1, 12) ),
            Arguments.of( new Item( AGED_BRIE, 1, 50 ), new Item( AGED_BRIE, 0, 50) ),
            Arguments.of( new Item( AGED_BRIE, -1, 10 ), new Item( AGED_BRIE, -2, 12) ),
            Arguments.of( new Item( SULFURAS, 7, 10 ), new Item( SULFURAS, 7, 10) ),
            Arguments.of( new Item( SULFURAS, 7, 50 ), new Item( SULFURAS, 7, 50) ),
            Arguments.of( new Item( SULFURAS, 0, 50 ), new Item( SULFURAS, 0, 50) ),
            Arguments.of( new Item( BACKSTAGE, 20, 11 ), new Item( BACKSTAGE, 19, 12) ),
            Arguments.of( new Item( BACKSTAGE, 11, 11 ), new Item( BACKSTAGE, 10, 12) ),
            Arguments.of( new Item( BACKSTAGE, 10, 11 ), new Item( BACKSTAGE, 9, 13) ),
            Arguments.of( new Item( BACKSTAGE, 6, 11 ), new Item( BACKSTAGE, 5, 13) ),
            Arguments.of( new Item( BACKSTAGE, 5, 11 ), new Item( BACKSTAGE, 4, 14) ),
            Arguments.of( new Item( BACKSTAGE, 1, 11 ), new Item( BACKSTAGE, 0, 14) ),
            Arguments.of( new Item( BACKSTAGE, 0, 11 ), new Item( BACKSTAGE, -1, 0) ),
            Arguments.of( new Item( BACKSTAGE, -1, 11 ), new Item( BACKSTAGE, -2, 0) ),
            Arguments.of( new Item( OTHER, 10, 10 ), new Item( OTHER, 9, 9) ),
            Arguments.of( new Item( OTHER, 10, 0 ), new Item( OTHER, 9, 0) ),
            Arguments.of( new Item( OTHER, 0, 0 ), new Item( OTHER, -1, 0) ),
            Arguments.of( new Item( OTHER, -1, 10 ), new Item( OTHER, -2, 8) ),
            Arguments.of( new Item( OTHER, -1, 0 ), new Item( OTHER, -2, 0) )
        );
    }

    @ParameterizedTest
    @MethodSource("provideDataForTests")
    void testUpdateQuality(Item input, Item expectedOutput) {
        // 1. Setup
        GildedRose app = new GildedRose( new Item[]{input});
        // 2. Execution
        app.updateQuality();
        // 3. Assertions
        final Item outputItem = app.items[0];
        assertEquals( expectedOutput.name, outputItem.name);
        assertEquals( expectedOutput.sellIn, outputItem.sellIn);
        assertEquals( expectedOutput.quality, outputItem.quality);
    }

}
