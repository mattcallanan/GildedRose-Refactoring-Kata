package com.gildedrose.strategywithstages;

import com.gildedrose.Item;

public class ItemUpdater {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured";

    public void updateItem(Item item) {
        final ItemUpdateStrategy strategy = selectStrategy( item );
        strategy.updateQuality( item );
        strategy.updateSellIn( item );
        strategy.updateExpiredQuality( item );
    }

    private ItemUpdateStrategy selectStrategy(Item item) {
        switch (item.name) {
            case (AGED_BRIE):
                return new AgedBrieItemUpdateStrategy();
            case (BACKSTAGE):
                return new BackstageItemUpdateStrategy();
            case (SULFURAS):
                return new SulfurasItemUpdateStrategy();
            case (CONJURED):
                return new ConjuredItemUpdateStrategy();
            default:
                return new DefaultItemUpdateStrategy();
        }
    }
}
