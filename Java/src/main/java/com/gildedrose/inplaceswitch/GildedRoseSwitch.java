package com.gildedrose.inplaceswitch;

import com.gildedrose.Item;

class GildedRoseSwitch {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRoseSwitch(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    updateAgedBrieItem( item );
                    break;
                case BACKSTAGE:
                    updateBackstageItem( item );
                    break;
                case SULFURAS:
                    updateSulfurasItem( item );
                    break;
                default:
                    updateOtherItem( item );
            }
        }
    }


    private void updateAgedBrieItem(Item item) {
        item.quality = item.quality + 1;

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality + 1;
        }
        applyLimits( item );
    }

    private void updateBackstageItem(Item item) {
        item.quality = item.quality + 1;

        if (item.sellIn < 11) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 6) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
        applyLimits( item );
    }

    private void updateSulfurasItem(Item item) {

    }

    private void updateOtherItem(Item item) {
        item.quality = item.quality - 1;

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality - 1;
        }
        applyLimits( item );
    }

    private void applyLimits(Item item) {
        item.quality = Math.min( item.quality, 50 );
        item.quality = Math.max( item.quality, 0 );
    }
}
