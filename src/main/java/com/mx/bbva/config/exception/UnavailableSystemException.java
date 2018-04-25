package com.mx.bbva.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Abel Rodriguez Moran on 04/01/2018.
 */
@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class UnavailableSystemException extends RuntimeException {
    public UnavailableSystemException(String msg) {
        super("Servicio no disponible: " + msg);
    }
}
