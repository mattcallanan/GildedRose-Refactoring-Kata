package com.gildedrose.gildedrose2;

import com.gildedrose.Item;

class GildedRose2 {
    Item[] items;

    public GildedRose2(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem( item );
        }
    }

    private void updateItem(Item item) {
        updateQuality( item );

        updateSellIn( item );

        updateAfterExpiry( item );
    }

    private void updateQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                increaseQualityWithLimit( item );
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                increaseQualityWithLimit( item );

                if (item.sellIn < 11) {
                    increaseQualityWithLimit( item );
                }

                if (item.sellIn < 6) {
                    increaseQualityWithLimit( item );
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                return;
            default:
                decreaseQualityWithLimit( item );
                break;
        }
    }

    private void updateSellIn(Item item) {
        if (item.name.equals( "Sulfuras, Hand of Ragnaros" )) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    private void updateAfterExpiry(Item item) {
        if (item.sellIn < 0) {
            switch (item.name) {
                case "Aged Brie":
                    increaseQualityWithLimit( item );
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality = 0;
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    return;
                default:
                    decreaseQualityWithLimit( item );
                    break;
            }
        }
    }

    private void increaseQualityWithLimit(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityWithLimit(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
