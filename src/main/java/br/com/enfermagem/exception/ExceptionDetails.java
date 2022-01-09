package br.com.enfermagem.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ExceptionDetails {

    private int status;
    private String time;
    private List<String> errors;
}
