package com.keirnellyer.glencaldy.util;

import com.keirnellyer.glencaldy.item.Book;
import com.keirnellyer.glencaldy.item.Disc;
import com.keirnellyer.glencaldy.item.Journal;
import com.keirnellyer.glencaldy.item.Video;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.menu.option.stock.SelectItem;

public interface Visitor {
    SelectItem<Book> addBook(Book book);

    SelectItem<Disc> addDisc(Disc disc);

    SelectItem<Journal> addJournal(Journal journal);

    SelectItem<Video> addVideo(Video video);
}
