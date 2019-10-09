package com.keirnellyer.glencaldy.util;


import java.util.Optional;
import java.util.Scanner;

public class ConsoleInput<T> {
    private Scanner scanner;

    public Optional<T> waitForInput(InputWait<T> inputWait) {
        Optional<T> fetchedObj = Optional.empty();

        do {
            fetchedObj = inputWait.getInput(this.scanner);
        } while (!fetchedObj.isPresent() && scanner.hasNext());

        return fetchedObj;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
