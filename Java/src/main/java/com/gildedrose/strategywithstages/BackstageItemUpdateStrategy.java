package com.gildedrose.strategywithstages;

import com.gildedrose.Item;

import static com.gildedrose.strategywithstages.UpdateHelper.increaseQualityWithLimit;

public class BackstageItemUpdateStrategy implements ItemUpdateStrategy {
    @Override
    public void updateQuality(Item item) {
        item.quality = increaseQualityWithLimit( item.quality );

        if (item.sellIn < 11) {
            item.quality = increaseQualityWithLimit( item.quality );
        }

        if (item.sellIn < 6) {
            item.quality = increaseQualityWithLimit( item.quality );
        }
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void updateExpiredQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
