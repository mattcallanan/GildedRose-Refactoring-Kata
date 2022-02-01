package com.gildedrose.strategywithstages;

import com.gildedrose.Item;

public interface ItemUpdateStrategy {
    void updateQuality(Item item);

    void updateSellIn(Item item);

    void updateExpiredQuality(Item item);
}
