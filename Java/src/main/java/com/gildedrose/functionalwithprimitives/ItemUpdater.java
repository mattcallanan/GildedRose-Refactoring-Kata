package com.gildedrose.functionalwithprimitives;

import com.gildedrose.Item;

public class ItemUpdater {
    public Item updateItem(Item item) {

        String name = item.name;
        int newQuality = calculateNewQuality(item.name, item.quality, item.sellIn);
        int newSellIn = calculateNewSellIn(item.name, item.sellIn);
        newQuality = calculateExpiredQuality(item.name, newQuality, newSellIn);

        return new Item( name, newSellIn, newQuality);
    }

    private int calculateNewQuality(String name, int quality, int sellIn) {
        switch (name) {
            case "Aged Brie":
                return increaseQualityWithLimit( quality );
            case "Backstage passes to a TAFKAL80ETC concert":
                quality = increaseQualityWithLimit(quality);

                if (sellIn < 11) {
                    quality = increaseQualityWithLimit(quality);
                }

                if (sellIn < 6) {
                    quality = increaseQualityWithLimit(quality);
                }
                return quality;
            case "Sulfuras, Hand of Ragnaros":
                return quality;
            default:
                return decreaseQualityWithLimit( quality );
        }
    }

    private int increaseQualityWithLimit(int quality) {
        return quality < 50 ? quality + 1 : quality;
    }

    private int decreaseQualityWithLimit(int quality) {
        return quality > 0 ? quality - 1 : quality;
    }

    private int calculateNewSellIn(String name, int sellIn) {
        if (!name.equals( "Sulfuras, Hand of Ragnaros" )) {
            return sellIn - 1;
        }
        return sellIn;
    }

    private int calculateExpiredQuality(String name, int quality, int sellIn) {
        if (sellIn >= 0) {
            return quality;
        }
        switch (name) {
            case "Aged Brie":
                return increaseQualityWithLimit( quality );
            case "Backstage passes to a TAFKAL80ETC concert":
                return 0;
            case "Sulfuras, Hand of Ragnaros":
                return quality;
            default:
                return decreaseQualityWithLimit( quality );
        }
    }
}
