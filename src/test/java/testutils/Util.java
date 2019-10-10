package testutils;

import com.keirnellyer.glencaldy.item.Book;
import com.keirnellyer.glencaldy.item.Disc;
import com.keirnellyer.glencaldy.item.Journal;
import com.keirnellyer.glencaldy.item.Video;
import com.keirnellyer.glencaldy.repository.StockRepository;

import java.time.LocalDate;

public class Util {
    public static Book book = new Book(0, "book1", "McPublishers", 20, "Fantasy", 750,
        "2360-8005", "Richard Donaldson");

    public static Disc disc = new Disc(1, "disc1", "SomePub", 5, 60, "Plastic",
        "Album", 20, "The 1975");

    public static Journal journal = new Journal(2, "journal1", "NatPub", 15, "Geography", 70,
        "2360-7947", 1, LocalDate.of(1977, 8, 3));

    public static Video video = new Video(3, "video1", "Bond Productions", 30, 180, "Plastic", "DVD",
        "Action");

    public static StockRepository getTestStock() {
        StockRepository stockRepository = new StockRepository();

        stockRepository.add(
            book,
            disc,
            journal,
            video
        );

        return stockRepository;
    }
}
