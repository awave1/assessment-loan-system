package com.keirnellyer.glencaldy.menu.option.stock;

import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.StockRepository;

import java.util.Scanner;

import static com.keirnellyer.glencaldy.manipulation.Manipulators.*;
import static com.keirnellyer.glencaldy.menu.option.stock.StockItemType.*;

public class CreateStockOption extends Option {
    private final StockRepository repository;

    public CreateStockOption(StockRepository repository) {
        super("Create Stock");
        this.repository = repository;
    }

    @Override
    public void start(Scanner scanner) {
        Menu menu = new Menu("Stock Type");

        menu.addItem(new StockItemOption(BOOK, BOOK_MANAGER, BOOK_MANIPULATOR, repository));
        menu.addItem(new StockItemOption(JOURNAL, JOURNAL_MANAGER, JOURNAL_MANIPULATOR, repository));
        menu.addItem(new StockItemOption(DISC, DISC_MANAGER, DISC_MANIPULATOR, repository));
        menu.addItem(new StockItemOption(VIDEO, VIDEO_MANAGER, VIDEO_MANIPULATOR, repository));

        menu.startMenu(scanner);
    }
}
