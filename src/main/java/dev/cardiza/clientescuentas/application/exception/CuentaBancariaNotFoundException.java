package dev.cardiza.clientescuentas.application.exception;

import dev.cardiza.clientescuentas.application.exception.constants.ExceptionMessages;

public class CuentaBancariaNotFoundException extends RuntimeException {

    public CuentaBancariaNotFoundException(Long id) {
        super(String.format(ExceptionMessages.CUENTA_BANCARIA_NOT_FOUND, id));
    }
}