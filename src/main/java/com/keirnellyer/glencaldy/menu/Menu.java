package com.keirnellyer.glencaldy.menu;

import com.keirnellyer.glencaldy.Session;
import com.keirnellyer.glencaldy.menu.option.ExitApplicationOption;
import com.keirnellyer.glencaldy.menu.option.LogoutOption;
import com.keirnellyer.glencaldy.menu.option.loan.CreateLoanOption;
import com.keirnellyer.glencaldy.menu.option.loan.LoanReturnOption;
import com.keirnellyer.glencaldy.menu.option.loan.ViewLoansOption;
import com.keirnellyer.glencaldy.menu.option.stock.CreateStockOption;
import com.keirnellyer.glencaldy.menu.option.stock.EditStockOption;
import com.keirnellyer.glencaldy.menu.option.stock.ListStockOption;
import com.keirnellyer.glencaldy.menu.option.stock.SearchStockOption;
import com.keirnellyer.glencaldy.menu.option.user.CreateUserOption;
import com.keirnellyer.glencaldy.menu.option.user.EditProfileOption;
import com.keirnellyer.glencaldy.menu.option.user.ListUsersOption;
import com.keirnellyer.glencaldy.repository.StockRepository;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.runtime.Application;
import com.keirnellyer.glencaldy.user.*;
import com.keirnellyer.glencaldy.util.ConsoleInput;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Menu extends ConsoleInput<Option> {
    private final String title;

    private char charIndex = 'a';
    private final Map<String, Option> items = new LinkedHashMap<>(); // linked hashmap preserves insertion order

    public Menu(String title) {
        super();
        this.title = title;
    }

    public void addItem(Option item) {
        addItem(String.valueOf(charIndex++), item);
    }

    public void addItem(String selector, Option item) {
        items.put(selector, item);
    }

    public void startMenu(Scanner scanner) {
        setScanner(scanner);
        displayMenu();

        Optional<Option> option = waitForInput(s -> {
            System.out.println("Please enter a menu option.");
            String userOption = s.next();
            Option o = items.get(userOption);

            if (o == null) {
                System.out.println("Invalid menu option, please try again.");
            }

            return Optional.of(o);
        });

        if (option.isPresent()) {
            System.out.println();
            option.get().start(scanner);
            System.out.println();
        }
    }

    private void displayMenu() {
        System.out.println(String.format("*** %s ***", title));

        for (Map.Entry<String, Option> entry : items.entrySet()) {
            System.out.println(String.format("%s) %s", entry.getKey(), entry.getValue().getDisplayName()));
        }

        System.out.println();
    }

    public Map<String, Option> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "title='" + title + '\'' +
                ", items=" + items +
                '}';
    }

    public void buildFor(Application app, Session session, User user, UserRepository userRepository, StockRepository stockRepository) {
        if (user instanceof Casual) {
            this.addItem(new SearchStockOption(stockRepository));
        }

        if (user instanceof Member) {
            this.addItem(new ViewLoansOption((Member) user));
        }

        if (user instanceof Administrative) {
            this.addItem(new CreateUserOption(userRepository));
            this.addItem(new ListUsersOption(userRepository));
            this.addItem(new CreateStockOption(stockRepository));
            this.addItem(new EditStockOption(stockRepository));
            this.addItem(new ListStockOption(stockRepository));
            this.addItem(new CreateLoanOption(userRepository, stockRepository));
            this.addItem(new LoanReturnOption(userRepository, stockRepository));
        }

        this.addItem(new EditProfileOption(user));
        this.addItem(new LogoutOption(session));
        this.addItem(new ExitApplicationOption(app));
    }
}
