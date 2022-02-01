package com.gildedrose.functional;

import com.gildedrose.Item;

class GildedRoseFunctional {
    Item[] items;
    ItemUpdater itemUpdater = new ItemUpdater();

    public GildedRoseFunctional(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i] = itemUpdater.updateItem( items[i] );
        }
    }

}
