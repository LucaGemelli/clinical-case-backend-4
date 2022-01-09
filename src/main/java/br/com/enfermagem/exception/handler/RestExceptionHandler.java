package br.com.enfermagem.exception.handler;

import br.com.enfermagem.exception.ExceptionDetails;
import br.com.enfermagem.exception.MessageListException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MessageListException.class)
    public ResponseEntity<Object> handlerException(MessageListException messageListException) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .time(getTimeFormatted())
                .errors(messageListException.getMessages())
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    private String getTimeFormatted() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return LocalDateTime.now().format(dateTimeFormatter);
    }
}
