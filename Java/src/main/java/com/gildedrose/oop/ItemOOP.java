package com.gildedrose.oop;

public abstract class ItemOOP {

    public String name;

    public int sellIn;

    public int quality;

    ItemOOP(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public abstract void update();

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
