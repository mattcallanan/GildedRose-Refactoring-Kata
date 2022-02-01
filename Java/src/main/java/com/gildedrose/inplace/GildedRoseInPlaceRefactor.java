package com.gildedrose.inplace;

import com.gildedrose.Item;

class GildedRoseInPlaceRefactor {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRoseInPlaceRefactor(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem( item );
        }
    }

    private void updateItem(Item item) {
        if (isSulfuras( item )) {
            return;
        }

        updateQualityBeforeUpdatingSellIn( item );

        updateSellIn( item );

        updateQualityAfterUpdatingSellIn( item );

        applyLimits( item );
    }

    private void updateQualityBeforeUpdatingSellIn(Item item) {
        if (isIncreasingQualityItem( item )) {
            if (isBackstage( item )) {
                increaseBackstageQuality( item );
            } else {
                increaseQuality( item );
            }
        } else {
            decreaseQuality( item );
        }
    }

    private void increaseBackstageQuality(Item item) {
        increaseQuality( item );
        if (item.sellIn < 11) {
            increaseQuality( item );
            if (item.sellIn < 6) {
                increaseQuality( item );
            }
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateQualityAfterUpdatingSellIn(Item item) {
        if (item.sellIn < 0) {
            if (isAgedBrie( item )) {
                increaseQuality( item );
            } else {
                if (isBackstage( item )) {
                    item.quality = 0;
                } else {
                    decreaseQuality( item );
                }
            }
        }
    }

    private void applyLimits(Item item) {
        item.quality = Math.min( item.quality, 50 );
        item.quality = Math.max( item.quality, 0 );
    }

    private boolean isIncreasingQualityItem(Item item) {
        return isAgedBrie( item ) || isBackstage( item );
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals( AGED_BRIE );
    }

    private boolean isBackstage(Item item) {
        return item.name.equals( BACKSTAGE );
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals( SULFURAS );
    }
}
