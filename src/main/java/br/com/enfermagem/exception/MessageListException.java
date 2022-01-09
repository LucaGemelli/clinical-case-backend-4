package br.com.enfermagem.exception;

import lombok.Getter;

import java.util.List;

public class MessageListException extends RuntimeException {

    @Getter
    private final List<String> messages;

    public MessageListException(List<String> messages) {
        this.messages = messages;
    }
}
