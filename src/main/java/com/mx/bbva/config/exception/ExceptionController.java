package com.mx.bbva.config.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Guevara García Manuel on 28/06/2017.
 */
@ControllerAdvice
public class ExceptionController {
    private static final Logger LOG = Logger.getLogger(ExceptionController.class.getName());

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    Map<String, String> unauthorizedAccess(Exception e) {
        Map<String, String> exception = new HashMap<>();
        exception.put("code", "401");
        exception.put("message", e.getMessage());

        return exception;
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    Map<String, String> forbiddenException(Exception e) {
        Map<String, String> exception = new HashMap<>();
        exception.put("code", "403");
        exception.put("message", e.getMessage());

        return exception;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CONFLICT)
    Map<String, String> notFoundException(Exception e) {
        Map<String, String> exception = new HashMap<>();
        exception.put("code", "409");
        exception.put("message", e.getMessage());

        return exception;
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CONFLICT)
    Map<String, String> conflictException(Exception e) {
        Map<String, String> exception = new HashMap<>();
        exception.put("code", "409");
        exception.put("message", e.getMessage());

        return exception;
    }

    @ExceptionHandler(ParamUnknownException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    Map<String, String> paramUnknownException(Exception e) {
        Map<String, String> exception = new HashMap<>();
        exception.put("code", "400");
        exception.put("message", e.getMessage());

        return exception;
    }

    @ExceptionHandler(SQLException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    Map<String, String> sqlException(Exception e) {
        Map<String, String> exception = new HashMap<>();
        LOG.warning("Exception occurred: " + e.getMessage());
        exception.put("code", "500");
        exception.put("message", "Error en base de datos, revisar log.");

        return exception;
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    Map<String, String> dataAccessException(Exception e) {
        Map<String, String> exception = new HashMap<>();
        LOG.warning("Exception occurred: " + e.getMessage());
        exception.put("code", "500");
        exception.put("message", "Error en base de datos, revisar log.");

        return exception;
    }

    @ExceptionHandler(DuplicateIdException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CONFLICT)
    Map<String, String> duplicateIdException(Exception e) {
        Map<String, String> exception = new HashMap<>();
        exception.put("code", "409");
        exception.put("message", e.getMessage());

        return exception;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    Map<String, String> throwable(Exception e) {
        Map<String, String> exception = new HashMap<>();
        LOG.warning("Exception occurred: " + e.getMessage());
        exception.put("code", "500");
        exception.put("message", "Error desconocido. revisar log.");

        return exception;
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    Map<String, String> internalServerException(Exception e) {
        Map<String, String> exception = new HashMap<>();
        LOG.warning("Exception occurred: " + e.getMessage());
        exception.put("code", "500");
        exception.put("message", e.getMessage());

        return exception;
    }

    @ExceptionHandler(UnavailableSystemException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    Map<String, String> unavailableSystemException(Exception e) {
        Map<String, String> exception = new HashMap<>();
        LOG.warning("Exception occurred: " + e.getMessage());
        exception.put("code", "503");
        exception.put("message", e.getMessage());

        return exception;
    }

}
