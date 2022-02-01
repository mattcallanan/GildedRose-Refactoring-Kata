package com.gildedrose.strategy;

import com.gildedrose.Item;

public class GildedRoseStrategyUpdater {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private GildedRoseAgedBrieUpdateStrategy gildedRoseAgedBrieUpdateStrategy = new GildedRoseAgedBrieUpdateStrategy();
    private GildedRoseBackstageUpdateStrategy gildedRoseBackstageUpdateStrategy = new GildedRoseBackstageUpdateStrategy();
    private GildedRoseSulfurasUpdateStrategy gildedRoseSulfurasUpdateStrategy = new GildedRoseSulfurasUpdateStrategy();
    private GildedRoseDefaultUpdateStrategy gildedRoseDefaultUpdateStrategy = new GildedRoseDefaultUpdateStrategy();

    public void updateItem(Item item) {
        switch (item.name) {
            case (AGED_BRIE):
                gildedRoseAgedBrieUpdateStrategy.update( item );
                break;
            case (BACKSTAGE):
                gildedRoseBackstageUpdateStrategy.update( item );
                break;
            case (SULFURAS):
                gildedRoseSulfurasUpdateStrategy.update( item );
                break;
            default:
                gildedRoseDefaultUpdateStrategy.update( item );
                break;
        }
    }
}
