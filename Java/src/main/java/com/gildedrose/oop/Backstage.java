package com.gildedrose.oop;

public class Backstage extends ItemOOP {
    Backstage(int sellIn, int quality) {
        super( ItemConstants.BACKSTAGE, sellIn, quality );
    }

    @Override
    public void update() {
        updateBackstageItem();
    }

    private void updateBackstageItem() {
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }


}
