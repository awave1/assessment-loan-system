package com.keirnellyer.glencaldy.manipulation.property.type;

import com.keirnellyer.glencaldy.exception.InputException;
import com.keirnellyer.glencaldy.util.ConsoleInput;
import com.keirnellyer.glencaldy.util.InputUtil;

import java.util.Optional;
import java.util.Scanner;

public abstract class Property<T> extends ConsoleInput<T> {
    private boolean editable = true;

    Property() {}

    public boolean isEditable() {
        return editable;
    }

    void setEditable(boolean editable) {
        this.editable = editable;
    }

    public final T fetchValue(Scanner scanner, boolean allowSkip) {
        setScanner(scanner);

        Optional<T> value = waitForInput(s -> {
            T val = null;
            ask();

            String input = scanner.next();

            if (shouldEdit(allowSkip, input)) {
                try {
                    val = parse(input);

                    if (val == null) {
                        System.out.println("Something went wrong there, please try again.");
                    }
                } catch (InputException e) {
                    System.out.println("Input error occurred: " + e.getMessage());
                    System.out.println("Please try again.");
                }
            }

            return Optional.of(val);
        });

        return value.orElse(null);
    }

    private boolean shouldEdit(boolean allowSkip, String input) {
        return allowSkip ? !InputUtil.checkSkip(input) : InputUtil.checkAbort(input);
    }

    protected abstract void ask();
    protected abstract T parse(String input) throws InputException;
}
