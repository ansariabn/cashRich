package com.project.cashRich.exception;
/**
 * @author Nehal Ansari
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}