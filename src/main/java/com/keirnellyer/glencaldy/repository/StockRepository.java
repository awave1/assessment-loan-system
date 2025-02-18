package com.keirnellyer.glencaldy.repository;

import com.keirnellyer.glencaldy.item.Item;

public class StockRepository extends Repository<Integer, Item> {
    @Override
    public Item get(Integer id) {
        return this.repoContents
            .stream()
            .filter(item -> item.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
