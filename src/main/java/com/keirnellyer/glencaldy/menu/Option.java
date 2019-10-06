package com.keirnellyer.glencaldy.menu;

import java.util.Scanner;

public abstract class Option {
    private final String name;

    protected Option(String name) {
        this.name = name;
    }

    String getDisplayName() {
        return name;
    }

    public abstract void start(Scanner scanner);

    @Override
    public String toString() {
        return "Option{" +
                "name='" + name + '\'' +
                '}';
    }
}
