package com.gildedrose.inplaceswitch;

import com.gildedrose.Item;

class GildedRoseSwitchWithStages {
    Item[] items;

    public GildedRoseSwitchWithStages(Item[] items) {
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

        updateExpired( item );
    }

    private void updateQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                incrementQuality( item );
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                incrementQuality( item );

                if (item.sellIn < 11) {
                    incrementQuality( item );
                }

                if (item.sellIn < 6) {
                    incrementQuality( item );
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                decrementQuality( item );
                break;
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals( "Sulfuras, Hand of Ragnaros" )) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateExpired(Item item) {
        if (item.sellIn < 0) {
            switch (item.name) {
                case "Aged Brie":
                    incrementQuality( item );
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality = 0;
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    decrementQuality( item );
                    break;
            }
        }
    }


    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
