package com.mx.bbva.config.exception;

/**
 * Created by Guevara García Manuel on 12/07/2017.
 */
public class ParamUnknownException extends RuntimeException {
    private static final long serialVersionUID = -3332292346834265371L;

    public ParamUnknownException(String msg) {
        super("Parametro desconocido. " + msg);
    }
}
