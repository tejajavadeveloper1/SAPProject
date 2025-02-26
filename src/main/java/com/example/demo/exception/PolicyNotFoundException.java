package com.example.demo.exception;

public class PolicyNotFoundException extends RuntimeException {
    public PolicyNotFoundException(Long id) {
        super("Policy with ID " + id + " not found.");
    }
}