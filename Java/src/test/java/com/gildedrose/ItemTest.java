package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    public static final String FILLER_NAME = "FILLER_NAME";
    public static final int FILLER_SELL_IN = 10;
    public static final int FILLER_QUALITY = 20;

    @Test
    public void testToString() {
        final Item subject = new Item( FILLER_NAME, FILLER_SELL_IN, FILLER_QUALITY );
        final String actual = subject.toString();
        assertEquals( FILLER_NAME + ", " + FILLER_SELL_IN + ", " + FILLER_QUALITY, actual);

    }
}
