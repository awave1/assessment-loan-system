package com.keirnellyer.glencaldy.util;

import com.keirnellyer.glencaldy.item.Book;
import com.keirnellyer.glencaldy.item.Disc;
import com.keirnellyer.glencaldy.item.Journal;
import com.keirnellyer.glencaldy.item.Video;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.Option;
import com.keirnellyer.glencaldy.menu.option.stock.SelectItem;
import com.keirnellyer.glencaldy.repository.StockRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testutils.Util;

import static org.junit.jupiter.api.Assertions.*;

class MenuVisitorTest {
    private static StockRepository stockRepository;
    private MenuVisitor menuVisitor = new MenuVisitor();

    @BeforeAll
    static void setUp() {
        stockRepository = Util.getTestStock();
    }

    @BeforeEach
    void beforeEach() {
        menuVisitor = new MenuVisitor();
    }

    @Test
    void buildMenu() {
        Menu menu = new Menu("Test Menu");
        menuVisitor.build(menu, stockRepository.getAll());

        assertFalse(menu.getItems().isEmpty());

        for (int i = 0; i < stockRepository.getAll().size(); i++) {
            assertNotNull(menu.getItems().get(Integer.toString(i)));
        }
    }

    @Test
    void addBook() {
        SelectItem<Book> selectItem = menuVisitor.addBook(Util.book);
        assertNotNull(selectItem);
    }

    @Test
    void addDisc() {
        SelectItem<Disc> selectItem = menuVisitor.addDisc(Util.disc);
        assertNotNull(selectItem);
    }

    @Test
    void addJournal() {
        SelectItem<Journal> selectItem = menuVisitor.addJournal(Util.journal);
        assertNotNull(selectItem);
    }

    @Test
    void addVideo() {
        SelectItem<Video> selectItem = menuVisitor.addVideo(Util.video);
        assertNotNull(selectItem);
    }
}