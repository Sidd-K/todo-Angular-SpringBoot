package com.fullstackpractice.fullstackpractice.jwt.resource;
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}

