package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OpenApiDescriptions {

    public static final String CLIENTE_RESPONSE = "Cliente con sus datos personales y cuentas asociadas";
    public static final String CUENTA_RESPONSE = "Cuenta bancaria asociada a un cliente";
    public static final String CREAR_CUENTA_REQUEST = "Datos para dar de alta una nueva cuenta bancaria";
    public static final String ACTUALIZAR_SALDO_REQUEST = "Datos para actualizar el saldo de una cuenta";

    public static final String DNI = "DNI del cliente";
    public static final String DNI_CLIENTE = "DNI del cliente titular";
    public static final String NOMBRE = "Nombre";
    public static final String APELLIDO_1 = "Primer apellido";
    public static final String APELLIDO_2 = "Segundo apellido";
    public static final String FECHA_NACIMIENTO = "Fecha de nacimiento";
    public static final String CUENTAS = "Cuentas bancarias asociadas al cliente";

    public static final String ID_CUENTA = "Identificador de la cuenta";
    public static final String TIPO_CUENTA = "Tipo de cuenta";
    public static final String TOTAL = "Saldo total de la cuenta";
    public static final String TOTAL_INICIAL = "Saldo inicial de la cuenta";
    public static final String TOTAL_NUEVO = "Nuevo saldo de la cuenta";
}