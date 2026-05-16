package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiRoutes {

    public static final String CLIENTES = "/clientes";
    public static final String CUENTAS = "/cuentas";

    public static final String ADULTS = "/mayores-de-edad";
    public static final String WITH_TOTAL_GREATER_THAN = "/con-cuenta-superior-a/{cantidad}";
    public static final String BY_DNI = "/{dni}";
    public static final String BY_CUENTA_ID = "/{idCuenta}";

    public static final String PV_DNI = "dni";
    public static final String PV_AMOUNT = "cantidad";
    public static final String PV_CUENTA_ID = "idCuenta";
}