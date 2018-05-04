package com.mx.bbva.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Guevara García Manuel on 01/08/2017.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {
    private static final long serialVersionUID = -3332292346834265371L;

    public InternalServerException(String msg) {
        super("Error en proceso del servidor. " + msg);
    }
}
