package com.dhinesh.ordermanagement.exceptions;

public class InvalidProductException extends Exception {
    private String errorMessage;

    public InvalidProductException(String message) {
        super(message);
        this.errorMessage=message;

    }
}

