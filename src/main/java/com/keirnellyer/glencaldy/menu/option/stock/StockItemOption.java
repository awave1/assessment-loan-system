package com.keirnellyer.glencaldy.menu.option.stock;

import com.keirnellyer.glencaldy.item.Item;
import com.keirnellyer.glencaldy.manipulation.Manipulator;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.StockRepository;

import java.util.Scanner;

public class StockItemOption extends Option {
    private final PropertyManager propertyManager;
    private final Manipulator<? extends Item> manipulator;
    private StockRepository repository;

    public StockItemOption(StockItemType type, PropertyManager propertyManager,
                           Manipulator<? extends Item> manipulator, StockRepository repository) {
        super(type.toString());
        this.propertyManager = propertyManager;
        this.manipulator = manipulator;
        this.repository = repository;
    }

    @Override
    public void start(Scanner scanner) {
        InputResult result = propertyManager.fetchResult(scanner, false);

        if (result != null) {
            Item item = manipulator.create(result);

            if (item != null) {
                repository.add(item);
                System.out.println("Stock created.");
            } else {
                System.out.println("Something went wrong whilst creating item.");
            }
        }
    }
}

