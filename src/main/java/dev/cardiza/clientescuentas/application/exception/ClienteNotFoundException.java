package dev.cardiza.clientescuentas.application.exception;

import dev.cardiza.clientescuentas.application.exception.constants.ExceptionMessages;

public class ClienteNotFoundException extends RuntimeException{

    public ClienteNotFoundException(String dni) {
        super(String.format(ExceptionMessages.CLIENTE_NOT_FOUND, dni));
    }
}
