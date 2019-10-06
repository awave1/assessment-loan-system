package com.keirnellyer.glencaldy.menu.option.stock;

import com.keirnellyer.glencaldy.item.Item;
import com.keirnellyer.glencaldy.manipulation.Manipulator;
import com.keirnellyer.glencaldy.manipulation.property.InputResult;
import com.keirnellyer.glencaldy.manipulation.property.PropertyManager;
import com.keirnellyer.glencaldy.menu.Option;

import java.util.Scanner;

public class SelectItem<T extends Item> extends Option {
    private final T item;
    private final PropertyManager propertyManager;
    private final Manipulator<T> manipulator;

    SelectItem(T item, PropertyManager propertyManager, Manipulator<T> manipulator) {
        super(item.getName());
        this.item = item;
        this.propertyManager = propertyManager;
        this.manipulator = manipulator;
    }

    @Override
    public void start(Scanner scanner) {
        InputResult result = propertyManager.fetchResult(scanner, true);

        if (result != null) {
            manipulator.update(item, result);
            System.out.println("Item updated.");
        }
    }
}
