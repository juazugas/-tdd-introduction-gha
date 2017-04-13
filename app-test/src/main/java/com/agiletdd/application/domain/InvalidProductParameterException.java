package com.agiletdd.application.domain;

/**
 * Created by imasd on 13/4/17.
 */
public class InvalidProductParameterException extends RuntimeException {

    public InvalidProductParameterException(String message) {
        super(message);
    }
}
