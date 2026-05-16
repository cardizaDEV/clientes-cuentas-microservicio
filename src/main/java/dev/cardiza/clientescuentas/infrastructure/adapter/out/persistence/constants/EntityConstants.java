package dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EntityConstants {

    public static final String TABLE_CLIENTES = "CLIENTES";
    public static final String TABLE_CUENTAS_BANCARIAS = "CUENTAS_BANCARIAS";

    public static final int DNI_LENGTH = 9;
}