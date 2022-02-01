package com.gildedrose.strategywithstages;

import com.gildedrose.Item;

import static com.gildedrose.strategywithstages.UpdateHelper.decreaseQualityWithLimit;

public class ConjuredItemUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void updateQuality(Item item) {
        item.quality = decreaseQualityWithLimit( item.quality );
        item.quality = decreaseQualityWithLimit( item.quality );
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void updateExpiredQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = decreaseQualityWithLimit( item.quality );
            item.quality = decreaseQualityWithLimit( item.quality );
        }
    }
}
