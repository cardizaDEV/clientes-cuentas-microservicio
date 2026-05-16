package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationMessages {

    public static final String CLIENTE_DNI_REQUIRED = "El DNI del cliente es obligatorio";
    public static final String ACCOUNT_TYPE_REQUIRED = "El tipo de cuenta es obligatorio";
    public static final String TOTAL_REQUIRED = "El total es obligatorio";
    public static final String CLIENTE_DNI_SIZE = "El DNI debe tener exactamente 9 caracteres";
    public static final String ACCOUNT_TYPE_INVALID = "El tipo de cuenta debe ser JUNIOR, NORMAL o PREMIUM";
}