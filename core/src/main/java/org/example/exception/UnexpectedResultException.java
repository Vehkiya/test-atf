package org.example.exception;

public class UnexpectedResultException extends Exception {

    public UnexpectedResultException(String message) {
        super(message);
    }

    public UnexpectedResultException(String message, Throwable cause) {
        super(message, cause);
    }
}
