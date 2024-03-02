package com.dhinesh.ordermanagement.exceptions;

public class DuplicateValueException extends Exception {
    private String errorMessage;

    public DuplicateValueException(String productNameAlreadyExists) {
        super(productNameAlreadyExists);
        this.errorMessage=productNameAlreadyExists;


    }
}
