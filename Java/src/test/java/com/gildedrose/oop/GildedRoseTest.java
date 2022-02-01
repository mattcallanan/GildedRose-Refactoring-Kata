package com.gildedrose.oop;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.gildedrose.oop.ItemFactory.createItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String OTHER = "Any other item";

    private static Stream<Arguments> provideDataForTests() {
        return Stream.of(
            Arguments.of( createItem( AGED_BRIE, 7, 10 ), createItem( AGED_BRIE, 6, 11) ),
            Arguments.of( createItem( AGED_BRIE, 0, 10 ), createItem( AGED_BRIE, -1, 12) ),
            Arguments.of( createItem( AGED_BRIE, 1, 50 ), createItem( AGED_BRIE, 0, 50) ),
            Arguments.of( createItem( AGED_BRIE, -1, 10 ), createItem( AGED_BRIE, -2, 12) ),
            Arguments.of( createItem( SULFURAS, 7, 80 ), createItem( SULFURAS, 7, 80) ),
            Arguments.of( createItem( SULFURAS, 7, 80 ), createItem( SULFURAS, 7, 80) ),
            Arguments.of( createItem( SULFURAS, -1, 80 ), createItem( SULFURAS, -1, 80) ),
            Arguments.of( createItem( BACKSTAGE, 20, 11 ), createItem( BACKSTAGE, 19, 12) ),
            Arguments.of( createItem( BACKSTAGE, 10, 11 ), createItem( BACKSTAGE, 9, 13) ),
            Arguments.of( createItem( BACKSTAGE, 5, 11 ), createItem( BACKSTAGE, 4, 14) ),
            Arguments.of( createItem( BACKSTAGE, -1, 11 ), createItem( BACKSTAGE, -2, 0) ),
            Arguments.of( createItem( OTHER, 10, 10 ), createItem( OTHER, 9, 9) ),
            Arguments.of( createItem( OTHER, 10, 0 ), createItem( OTHER, 9, 0) ),
            Arguments.of( createItem( OTHER, 0, 0 ), createItem( OTHER, -1, 0) ),
            Arguments.of( createItem( OTHER, -1, 10 ), createItem( OTHER, -2, 8) ),
            Arguments.of( createItem( OTHER, -1, 0 ), createItem( OTHER, -2, 0) )
        );
    }

    @ParameterizedTest
    @MethodSource("provideDataForTests")
    void testUpdateQuality(ItemOOP input, ItemOOP expectedOutput) {
        // 1. Setup
        GildedRose app = new GildedRose( new ItemOOP[]{input});
        // 2. Execution
        app.updateQuality();
        // 3. Assertions
        final ItemOOP outputItem = app.items[0];
        assertEquals( expectedOutput.name, outputItem.name);
        assertEquals( expectedOutput.sellIn, outputItem.sellIn);
        assertEquals( expectedOutput.quality, outputItem.quality);
    }

}
