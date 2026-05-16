package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OpenApiDescriptions {

    public static final String CLIENTE_RESPONSE = "Cliente con sus datos personales y cuentas asociadas";
    public static final String CUENTA_RESPONSE = "Cuenta bancaria asociada a un cliente";
    public static final String CREATE_CUENTA_REQUEST = "Datos para dar de alta una nueva cuenta bancaria";
    public static final String UPDATE_BALANCE_REQUEST = "Datos para actualizar el saldo de una cuenta";

    public static final String DNI = "DNI del cliente";
    public static final String CLIENTE_DNI = "DNI del cliente titular";
    public static final String NAME = "Nombre";
    public static final String FIRST_SURNAME = "Primer apellido";
    public static final String SECOND_SURNAME = "Segundo apellido";
    public static final String BIRTH_DATE = "Fecha de nacimiento";
    public static final String CUENTAS = "Cuentas bancarias asociadas al cliente";

    public static final String CUENTA_ID = "Identificador de la cuenta";
    public static final String CUENTA_TYPE = "Tipo de cuenta";
    public static final String TOTAL = "Saldo total de la cuenta";
    public static final String INITIAL_TOTAL = "Saldo inicial de la cuenta";
    public static final String NEW_TOTAL = "Nuevo saldo de la cuenta";

    public static final String PARAM_DNI = "DNI del cliente";
    public static final String PARAM_AMOUNT = "Monto mínimo de saldo total";
    public static final String PARAM_CUENTA_ID = "Identificador de la cuenta a actualizar";

    public static final String TAG_CLIENTES = "Clientes";
    public static final String TAG_CLIENTES_DESC = "Operaciones de consulta de clientes y sus cuentas";
    public static final String TAG_CUENTAS = "Cuentas";
    public static final String TAG_CUENTAS_DESC = "Operaciones de alta y actualización de cuentas bancarias";

    public static final String OP_FIND_ALL = "Obtener todos los clientes";
    public static final String OP_FIND_ADULTS = "Obtener clientes mayores de edad";
    public static final String OP_FIND_WITH_TOTAL_GREATER_THAN = "Obtener clientes con saldo total superior a una cantidad";
    public static final String OP_FIND_BY_DNI = "Obtener un cliente por su DNI";
    public static final String OP_CREATE_CUENTA = "Dar de alta una nueva cuenta bancaria";
    public static final String OP_UPDATE_BALANCE = "Actualizar el saldo de una cuenta";

    public static final String OP_FIND_ALL_DESC = "Devuelve la lista completa de clientes con sus datos personales y todas sus cuentas asociadas.";
    public static final String OP_FIND_ADULTS_DESC = "Devuelve la lista de clientes cuya edad sea mayor o igual a 18 años, junto con sus cuentas.";
    public static final String OP_FIND_WITH_TOTAL_GREATER_THAN_DESC = "Devuelve la lista de clientes cuya suma total de saldo entre todas sus cuentas supera la cantidad indicada.";
    public static final String OP_FIND_BY_DNI_DESC = "Devuelve el cliente identificado por su DNI junto con todas sus cuentas asociadas.";
    public static final String OP_CREATE_CUENTA_DESC = "Crea una nueva cuenta bancaria. Si el cliente indicado no existe, se crea automáticamente.";
    public static final String OP_UPDATE_BALANCE_DESC = "Actualiza el saldo total de una cuenta bancaria existente.";

    public static final String RESP_200_CLIENTE_LIST = "Lista de clientes obtenida correctamente";
    public static final String RESP_200_CLIENTE = "Cliente obtenido correctamente";
    public static final String RESP_200_CUENTA_UPDATED = "Cuenta actualizada correctamente";
    public static final String RESP_201_CUENTA_CREATED = "Cuenta creada correctamente";
    public static final String RESP_400_INVALID_DATA = "Los datos enviados no son válidos";
    public static final String RESP_404_CLIENTE_NOT_FOUND = "No existe ningún cliente con el DNI indicado";
    public static final String RESP_404_CUENTA_NOT_FOUND = "No existe ninguna cuenta con el identificador indicado";
}