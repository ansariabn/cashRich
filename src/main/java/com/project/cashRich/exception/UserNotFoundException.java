package com.project.cashRich.exception;
/**
 * @author Nehal Ansari
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
