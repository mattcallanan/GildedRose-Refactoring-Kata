package com.gildedrose.strategy;

import com.gildedrose.Item;

public class GildedRose {
    Item[] items;
    private GildedRoseStrategyUpdater gildedRoseStrategyUpdater = new GildedRoseStrategyUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            gildedRoseStrategyUpdater.updateItem( item );
        }
    }

}
