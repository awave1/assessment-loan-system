package com.keirnellyer.glencaldy.util;

import com.keirnellyer.glencaldy.item.*;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.option.stock.SelectItem;

import java.util.ArrayList;

import static com.keirnellyer.glencaldy.manipulation.Manipulators.*;
import static com.keirnellyer.glencaldy.manipulation.Manipulators.DISC_MANIPULATOR;

public class MenuVisitor implements Visitor {

    public void build(Menu menu, ArrayList<Item> items) {
        final String STOCK_FORMAT = "| %-5s | %-10s | %-20s |%n";
        final String[] STOCK_HEADER = new String[]{"ID", "Type", "Name"};

        System.out.printf(STOCK_FORMAT, STOCK_HEADER);
        for (Item item : items) {
            System.out.printf(STOCK_FORMAT, item.getId(), item.getStockType(), item.getName());

            String selector = String.valueOf(item.getId());
            menu.addItem(selector, item.accept(this));
        }
    }

    @Override
    public SelectItem<Book> addBook(Book book) {
        return new SelectItem<>(book, BOOK_MANAGER, BOOK_MANIPULATOR);
    }

    @Override
    public SelectItem<Disc> addDisc(Disc disc) {
        return new SelectItem<>(disc, DISC_MANAGER, DISC_MANIPULATOR);
    }

    @Override
    public SelectItem<Journal> addJournal(Journal journal) {
        return new SelectItem<>(journal, JOURNAL_MANAGER, JOURNAL_MANIPULATOR);
    }

    @Override
    public SelectItem<Video> addVideo(Video video) {
        return new SelectItem<>(video, VIDEO_MANAGER, VIDEO_MANIPULATOR);
    }
}
