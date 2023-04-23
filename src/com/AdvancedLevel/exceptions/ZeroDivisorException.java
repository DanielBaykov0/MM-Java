package com.AdvancedLevel.exceptions;

public class ZeroDivisorException extends Exception {

    public ZeroDivisorException(Exception e) {
        super(e);
    }

    public ZeroDivisorException(String message) {
        super(message);
    }
}
