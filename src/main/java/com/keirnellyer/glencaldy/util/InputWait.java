package com.keirnellyer.glencaldy.util;

import java.util.Optional;
import java.util.Scanner;

public interface InputWait<T> {
    Optional<T> getInput(Scanner scanner);
}
