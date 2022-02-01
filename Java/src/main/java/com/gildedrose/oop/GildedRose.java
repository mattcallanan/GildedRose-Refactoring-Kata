package com.gildedrose.oop;

class GildedRose {
    ItemOOP[] items;

    public GildedRose(ItemOOP[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (ItemOOP item : items) {
            item.update();
        }
    }

}
