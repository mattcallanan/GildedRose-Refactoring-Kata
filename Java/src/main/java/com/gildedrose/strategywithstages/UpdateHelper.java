package com.gildedrose.strategywithstages;

public class UpdateHelper {
    public static int increaseQualityWithLimit(int quality) {
        return quality < 50 ? quality + 1 : quality;
    }

    public static int decreaseQualityWithLimit(int quality) {
        return quality > 0 ? quality - 1 : quality;
    }
}
