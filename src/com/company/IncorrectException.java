package com.company;

public class IncorrectException extends RuntimeException {
    /**
     * @param message
     */
    public IncorrectException(String message) {
        super(message);
    }
}