package com.mx.bbva.config.exception;

/**
 * Created by Guevara García Manuel on 19/07/2017.
 */
public class DuplicateIdException extends RuntimeException {
    private static final long serialVersionUID = -3332292346834265371L;

    public DuplicateIdException(String msg) {
        super("Id duplicada. " + msg);
    }
}