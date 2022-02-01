package com.gildedrose.strategy;

import com.gildedrose.Item;

import static com.gildedrose.strategy.UpdateHelper.increaseQualityWithLimit;

public class GildedRoseBackstageUpdateStrategy implements GildedRoseUpdateStrategy {
    @Override
    public void update(Item item) {
        updateQuality( item );

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateQuality(Item item) {
        item.quality = increaseQualityWithLimit( item.quality );

        if (item.sellIn < 11) {
            item.quality = increaseQualityWithLimit( item.quality );
        }

        if (item.sellIn < 6) {
            item.quality = increaseQualityWithLimit( item.quality );
        }
    }

}
