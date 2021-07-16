package ru.butakov.intechtelecomsub.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RequestException extends ResponseStatusException {
    public RequestException(HttpStatus status) {
        super(status);
    }

    public RequestException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public RequestException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

}
