package com.keirnellyer.glencaldy.exception;

public class InputException extends Exception {
    InputException() {
    }

    public InputException(String message) {
        super(message);
    }

    public InputException(String message, Throwable cause) {
        super(message, cause);
    }

    InputException(Throwable cause) {
        super(cause);
    }

    InputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
