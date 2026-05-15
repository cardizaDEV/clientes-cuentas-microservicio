package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiRoutes {

    public static final String CLIENTES = "/clientes";
    public static final String CUENTAS = "/cuentas";

    public static final String MAYORES_DE_EDAD = "/mayores-de-edad";
    public static final String CON_CUENTA_SUPERIOR_A = "/con-cuenta-superior-a/{cantidad}";
    public static final String POR_DNI = "/{dni}";

    public static final String POR_ID_CUENTA = "/{idCuenta}";

    public static final String PV_DNI = "dni";
    public static final String PV_CANTIDAD = "cantidad";
    public static final String PV_ID_CUENTA = "idCuenta";
}