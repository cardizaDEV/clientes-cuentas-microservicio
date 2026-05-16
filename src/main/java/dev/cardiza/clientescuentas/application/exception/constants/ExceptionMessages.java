package dev.cardiza.clientescuentas.application.exception.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionMessages {

    public static final String CLIENTE_NOT_FOUND = "No existe ningún cliente con el DNI %s";
    public static final String CUENTA_BANCARIA_NOT_FOUND = "No existe ninguna cuenta bancaria con el identificador %d";
}