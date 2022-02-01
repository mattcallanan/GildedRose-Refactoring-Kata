package com.gildedrose.functional;

import com.gildedrose.Item;

public class ItemUpdater {
    public Item updateItem(Item item) {
        return calculateExpiredQuality( calculateNewSellIn( calculateNewQuality( item) ) );
    }

    private Item calculateNewQuality(Item item) {
        int newQuality;
        switch (item.name) {
            case "Aged Brie":
                newQuality = increaseQualityWithLimit( item.quality );
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                newQuality = getBackstageQuality( item );
                break;
            case "Sulfuras, Hand of Ragnaros":
                newQuality = item.quality;
                break;
            default:
                newQuality = decreaseQualityWithLimit( item.quality );
                break;
        }
        return new Item( item.name, item.sellIn, newQuality );
    }

    private int getBackstageQuality(Item item) {
        int newQuality = increaseQualityWithLimit( item.quality);
        if (item.sellIn < 11) {
            newQuality = increaseQualityWithLimit( newQuality);
        }
        if (item.sellIn < 6) {
            newQuality = increaseQualityWithLimit( newQuality);
        }
        return newQuality;
    }

    private Item calculateNewSellIn(Item item) {
        int newSellIn;
        if (!item.name.equals( "Sulfuras, Hand of Ragnaros" )) {
            newSellIn = item.sellIn - 1;
        } else {
            newSellIn = item.sellIn;
        }
        return new Item( item.name, newSellIn, item.quality);
    }

    private Item calculateExpiredQuality(Item item) {
        int newQuality = item.quality;
        if (item.sellIn < 0) {
            switch (item.name) {
                case "Aged Brie":
                    newQuality = increaseQualityWithLimit( item.quality );
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    newQuality = 0;
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    newQuality = decreaseQualityWithLimit( item.quality );
                    break;
            }
        }
        return new Item(item.name, item.sellIn, newQuality);
    }

    private int increaseQualityWithLimit(int quality) {
        return quality < 50 ? quality + 1 : quality;
    }

    private int decreaseQualityWithLimit(int quality) {
        return quality > 0 ? quality - 1 : quality;
    }
}
