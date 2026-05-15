package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationMessages {

    public static final String DNI_CLIENTE_OBLIGATORIO = "El DNI del cliente es obligatorio";
    public static final String TIPO_CUENTA_OBLIGATORIO = "El tipo de cuenta es obligatorio";
    public static final String TOTAL_OBLIGATORIO = "El total es obligatorio";
    public static final String TOTAL_NO_NEGATIVO = "El total no puede ser negativo";
}