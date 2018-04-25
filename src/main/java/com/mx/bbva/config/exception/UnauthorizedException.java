package com.mx.bbva.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Guevara García Manuel on 28/06/2017.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    private static final long serialVersionUID = -3332292346834265371L;

    public UnauthorizedException(String msg) {
        super("Operacion no autorizada. " + msg);
    }
}
