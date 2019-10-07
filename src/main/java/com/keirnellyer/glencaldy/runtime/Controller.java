package com.keirnellyer.glencaldy.runtime;

import com.keirnellyer.glencaldy.Session;
import com.keirnellyer.glencaldy.menu.Menu;
import com.keirnellyer.glencaldy.repository.StockRepository;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.*;
import com.keirnellyer.glencaldy.util.ConsoleInput;

import java.util.Optional;
import java.util.Scanner;

public class Controller extends ConsoleInput<User> implements Application {
    private static final Model model = new Model();

    // by default Scanner uses a space as a delimiter however we always want to
    // read the full line
    private Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    private Session currentSession;
    private boolean running;

    public static void main(String[] args) {
        model.populateItems();
        model.populateUsers();

        new Controller().start();
    }

    @Override
    public void start() {
        running = true;
        setScanner(scanner);

        try {
            // creates a new session when the current session is either non-existent or killed
            while (running) {
                Optional<User> user = waitForInput(s -> {
                    User usr;
                    System.out.println("Please enter your username.");
                    String username = scanner.next();

                    System.out.println("Please enter your password.");
                    String password = scanner.next();

                    usr = model.getUserRepository().getExact(username, password);

                    if (usr == null) { // invalid credentials
                        System.out.println("Invalid credentials, please try again.");
                    }

                    return Optional.of(usr);
                });

                if (user.isPresent()) {
                    User usr = user.get();
                    currentSession = new Session(-1);
                    usr.setSession(currentSession);

                    while (running && currentSession.isActive()) {
                        Menu menu = buildMenu(usr);
                        menu.startMenu(scanner);
                    }
                }
            }
        } finally {
            scanner.close();
            scanner = null;
        }

        System.exit(0);
    }

    @Override
    public void stop() {
        running = false;
    }

    private Menu buildMenu(User user) {
        UserRepository userRepository = model.getUserRepository();
        StockRepository stockRepository = model.getStockRepository();

        Menu menu = new Menu(String.format("%s Options", user.getTitle()));
        menu.buildFor(this, currentSession, user, userRepository, stockRepository);
        return menu;
    }
}
