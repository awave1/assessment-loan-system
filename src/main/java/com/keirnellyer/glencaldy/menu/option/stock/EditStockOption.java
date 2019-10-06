package com.keirnellyer.glencaldy.menu.option.stock;

import com.keirnellyer.glencaldy.item.*;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.repository.StockRepository;

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
        System.out.printf(STOCK_FORMAT, STOCK_HEADER);

        Menu menu = new Menu("Select Stock (by id)");

        for (Item item : stockRepository.getAll()) {
            System.out.printf(STOCK_FORMAT, item.getId(), item.getStockType(), item.getName());

            String selector = String.valueOf(item.getId());

            if (item instanceof Book) {
                Book book = (Book) item;
                menu.addItem(selector, new SelectItem<>(book, BOOK_MANAGER, BOOK_MANIPULATOR));
            } else if (item instanceof Disc) {
                Disc disc = (Disc) item;
                menu.addItem(selector, new SelectItem<>(disc, DISC_MANAGER, DISC_MANIPULATOR));
            } else if (item instanceof Journal) {
                Journal journal = (Journal) item;
                menu.addItem(selector, new SelectItem<>(journal, JOURNAL_MANAGER, JOURNAL_MANIPULATOR));
            } else if (item instanceof Video) {
                Video video = (Video) item;
                menu.addItem(selector, new SelectItem<>(video, VIDEO_MANAGER, VIDEO_MANIPULATOR));
            }
        }

        System.out.println();
        menu.startMenu(scanner);
    }
}
