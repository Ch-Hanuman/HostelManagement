package com.hostel.management_prototype.exceptionhandling;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message) {
        super(message);
    }
}
