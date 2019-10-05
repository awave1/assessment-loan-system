package com.keirnellyer.glencaldy.menu.option.stock;

public enum StockItemType {
    BOOK("Book"),
    JOURNAL("Journal"),
    DISC("Compact Disc"),
    VIDEO("Video");

    private String type;

    StockItemType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
