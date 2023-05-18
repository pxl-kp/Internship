package com.pxl.SpringBoot.exception;

public class ResourceNotFoundException extends RuntimeException {
    //throw an exception for Resource not found in Spring Boot controller.
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}