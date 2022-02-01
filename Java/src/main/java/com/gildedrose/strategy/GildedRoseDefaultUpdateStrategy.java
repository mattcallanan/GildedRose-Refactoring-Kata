package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.strategy.UpdateHelper.decreaseQualityWithLimit;

public class GildedRoseDefaultUpdateStrategy implements GildedRoseUpdateStrategy {
    @Override
    public void update(Item item) {
        item.quality = decreaseQualityWithLimit( item.quality );

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = decreaseQualityWithLimit( item.quality );
        }
    }
}
