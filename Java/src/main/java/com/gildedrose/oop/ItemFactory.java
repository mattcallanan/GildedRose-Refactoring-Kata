package com.gildedrose.oop;

import static com.gildedrose.oop.ItemConstants.AGED_BRIE;
import static com.gildedrose.oop.ItemConstants.BACKSTAGE;
import static com.gildedrose.oop.ItemConstants.SULFURAS;

public class ItemFactory {

    public static ItemOOP createItem(String name, int sellIn, int quality) {
        switch (name) {
            case AGED_BRIE:
                return new AgedBrie( sellIn, quality );
            case BACKSTAGE:
                return new Backstage( sellIn, quality );
            case SULFURAS:
                return new Sulfuras( sellIn, quality );
            default:
                return new DefaultItem( name, sellIn, quality );
        }
    }
}
