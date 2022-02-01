package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.strategy.UpdateHelper.increaseQualityWithLimit;

public class GildedRoseAgedBrieUpdateStrategy implements GildedRoseUpdateStrategy {
    @Override
    public void update(Item item) {
        item.quality = increaseQualityWithLimit( item.quality );

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = increaseQualityWithLimit( item.quality );
        }
    }
}
