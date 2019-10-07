package com.keirnellyer.glencaldy.menu.option.stock;

import com.keirnellyer.glencaldy.item.*;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.StockRepository;
import com.keirnellyer.glencaldy.util.MenuVisitor;

import java.util.Scanner;

import static com.keirnellyer.glencaldy.manipulation.Manipulators.*;

public class EditStockOption extends Option {
    private static final String STOCK_FORMAT = "| %-5s | %-10s | %-20s |%n";
    private static final String[] STOCK_HEADER = new String[]{"ID", "Type", "Name"};

    private final StockRepository stockRepository;

    public EditStockOption(StockRepository stockRepository) {
        super("Edit Stock");
        this.stockRepository = stockRepository;
    }

    @Override
    public void start(Scanner scanner) {
        Menu menu = new Menu("Select Stock (by id)");
        MenuVisitor menuVisitor = new MenuVisitor();

        menuVisitor.build(menu, stockRepository.getAll());

        System.out.println();
        menu.startMenu(scanner);
    }
}
