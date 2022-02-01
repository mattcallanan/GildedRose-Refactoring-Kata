package com.gildedrose.strategywithstages;

import com.gildedrose.Item;

public class GildedRose {
    Item[] items;
    private ItemUpdater gildedRoseStrategyUpdater = new ItemUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            gildedRoseStrategyUpdater.updateItem( item );
        }
    }

}
