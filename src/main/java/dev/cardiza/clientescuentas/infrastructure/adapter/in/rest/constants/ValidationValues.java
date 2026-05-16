package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationValues {

    public static final String DNI_PATTERN = "[0-9]{8}[A-Z]";
    public static final String TIPO_PATTERN = "JUNIOR|NORMAL|PREMIUM";
}