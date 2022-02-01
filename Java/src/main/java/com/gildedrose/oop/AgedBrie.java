package com.gildedrose.oop;

public class AgedBrie extends ItemOOP {
    public AgedBrie(int sellIn, int quality) {
        super( ItemConstants.AGED_BRIE, sellIn, quality );
    }

    @Override
    public void update() {
        updateAgedBrieItem();
    }

    private void updateAgedBrieItem() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0) {
            if (this.quality < 50) {
                this.quality = this.quality + 1;
            }
        }
    }

}
