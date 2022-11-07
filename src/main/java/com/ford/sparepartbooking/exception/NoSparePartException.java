package com.ford.sparepartbooking.exception;

public class NoSparePartException extends RuntimeException {
    public NoSparePartException(String message) {
        super(message);
    }
}
