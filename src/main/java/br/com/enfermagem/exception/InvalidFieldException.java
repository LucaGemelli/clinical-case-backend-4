package br.com.enfermagem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidFieldException extends RuntimeException {

    public InvalidFieldException(String message) {
        super(message);
    }
}
