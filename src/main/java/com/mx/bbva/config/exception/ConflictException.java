package com.mx.bbva.config.exception;

public class ConflictException extends RuntimeException {
    private static final long serialVersionUID = -3332292346834265371L;

    public ConflictException(String msg) {
        super("Error al realizar la operacion. " + msg);
    }
}
