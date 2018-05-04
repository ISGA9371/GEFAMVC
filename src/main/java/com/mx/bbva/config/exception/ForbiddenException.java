package com.mx.bbva.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Guevara García Manuel on 10/07/2017.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = -3332292346834265371L;

    public ForbiddenException(String msg) {
        super("Operacion prohibida. " + msg);
    }
}
