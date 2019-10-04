package com.keirnellyer.glencaldy.repository;

import com.keirnellyer.glencaldy.item.Book;
import com.keirnellyer.glencaldy.item.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StockRepositoryTest {
    private static ArrayList<Item> books = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        for (int i = 0; i < 5; i++) {
            Book book = new Book(
                i,
                "title " + i,
                "publisher " + i,
                1.0f * i,
                "subject " + i,
                i * 10,
                "isbn " + i,
                "author " + i
            );

            books.add(book);
        }
    }

    @Test
    void shouldContainNoItems() {
        StockRepository stock = new StockRepository();
        assertNotNull(stock.getAll());
        assertEquals(0, stock.getAll().size());
    }

    @Test
    void shouldAddSingleItem() {
        StockRepository stock = new StockRepository();

        // Add book with id 0
        stock.add(books.get(0));

        assertNotNull(stock.getAll());
        assertEquals(1, stock.getAll().size());

        Book actualBook = (Book) stock.get(0);

        assertNotNull(actualBook);
        assertEquals(0, actualBook.getId());
    }

    @Test
    void shouldAddManyItems() {
        StockRepository stock = new StockRepository();

        // Add all books
        books.forEach(stock::add);

        assertNotNull(stock.getAll());
        assertEquals(books.size(), stock.getAll().size());

        books.forEach(b -> {
            Book actualBook = (Book) stock.get(b.getId());

            assertNotNull(actualBook);
            assertEquals(b.getId(), actualBook.getId());
        });
    }
}