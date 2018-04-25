package com.mx.bbva.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Guevara García Manuel on 08/06/2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -3332292346834265371L;

    public NotFoundException(String msg) {
        super("Elemento no encontrado. " + msg);
    }
}
