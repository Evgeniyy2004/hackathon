package com.example.demo.exceptions;

public class ConflictDataException extends RuntimeException {

    public ConflictDataException(final String message) {
        super(message);
    }
}
