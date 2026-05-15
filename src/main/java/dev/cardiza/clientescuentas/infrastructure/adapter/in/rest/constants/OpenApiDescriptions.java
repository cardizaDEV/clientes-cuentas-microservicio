package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OpenApiDescriptions {

    public static final String CLIENTE_RESPONSE = "Cliente con sus datos personales y cuentas asociadas";
    public static final String CUENTA_BANCARIA_RESPONSE = "Cuenta bancaria asociada a un cliente";
    public static final String CREAR_CUENTA_BANCARIA_REQUEST = "Datos para dar de alta una nueva cuenta bancaria";
    public static final String ACTUALIZAR_SALDO_REQUEST = "Datos para actualizar el saldo de una cuenta";

    public static final String DNI = "DNI del cliente";
    public static final String DNI_CLIENTE = "DNI del cliente titular";
    public static final String NOMBRE = "Nombre";
    public static final String APELLIDO_1 = "Primer apellido";
    public static final String APELLIDO_2 = "Segundo apellido";
    public static final String FECHA_NACIMIENTO = "Fecha de nacimiento";
    public static final String CUENTAS_BANCARIAS = "Cuentas bancarias asociadas al cliente";

    public static final String ID_CUENTA_BANCARIA = "Identificador de la cuenta";
    public static final String TIPO_CUENTA_BANCARIA = "Tipo de cuenta";
    public static final String TOTAL = "Saldo total de la cuenta";
    public static final String TOTAL_INICIAL = "Saldo inicial de la cuenta";
    public static final String TOTAL_NUEVO = "Nuevo saldo de la cuenta";

    public static final String PARAM_DNI = "DNI del cliente";
    public static final String PARAM_CANTIDAD = "Monto mínimo de saldo total";
    public static final String PARAM_ID_CUENTA = "Identificador de la cuenta a actualizar";

    public static final String TAG_CLIENTES = "Clientes";
    public static final String TAG_CLIENTES_DESC = "Operaciones de consulta de clientes y sus cuentas";
    public static final String TAG_CUENTAS_BANCARIAS = "Cuentas";
    public static final String TAG_CUENTAS_BANCARIAS_DESC = "Operaciones de alta y actualización de cuentas bancarias";

    public static final String OP_OBTENER_TODOS = "Obtener todos los clientes";
    public static final String OP_OBTENER_MAYORES_EDAD = "Obtener clientes mayores de edad";
    public static final String OP_OBTENER_CON_SALDO_SUPERIOR = "Obtener clientes con saldo total superior a una cantidad";
    public static final String OP_OBTENER_POR_DNI = "Obtener un cliente por su DNI";
    public static final String OP_CREAR_CUENTA_BANCARIA = "Dar de alta una nueva cuenta bancaria";
    public static final String OP_ACTUALIZAR_SALDO = "Actualizar el saldo de una cuenta";

    public static final String OP_OBTENER_TODOS_DESC = "Devuelve la lista completa de clientes con sus datos personales y todas sus cuentas asociadas.";
    public static final String OP_OBTENER_MAYORES_EDAD_DESC = "Devuelve la lista de clientes cuya edad sea mayor o igual a 18 años, junto con sus cuentas.";
    public static final String OP_OBTENER_CON_SALDO_SUPERIOR_DESC = "Devuelve la lista de clientes cuya suma total de saldo entre todas sus cuentas supera la cantidad indicada.";
    public static final String OP_OBTENER_POR_DNI_DESC = "Devuelve el cliente identificado por su DNI junto con todas sus cuentas asociadas.";
    public static final String OP_CREAR_CUENTA_BANCARIA_DESC = "Crea una nueva cuenta bancaria. Si el cliente indicado no existe, se crea automáticamente.";
    public static final String OP_ACTUALIZAR_SALDO_DESC = "Actualiza el saldo total de una cuenta bancaria existente.";

    public static final String RESP_200_LISTA_CLIENTES = "Lista de clientes obtenida correctamente";
    public static final String RESP_200_CLIENTE = "Cliente obtenido correctamente";
    public static final String RESP_200_CUENTA_BANCARIA_ACTUALIZADA = "Cuenta actualizada correctamente";
    public static final String RESP_201_CUENTA_BANCARIA_CREADA = "Cuenta creada correctamente";
    public static final String RESP_400_DATOS_INVALIDOS = "Los datos enviados no son válidos";
    public static final String RESP_404_CLIENTE_NO_ENCONTRADO = "No existe ningún cliente con el DNI indicado";
    public static final String RESP_404_CUENTA_BANCARIA_NO_ENCONTRADA = "No existe ninguna cuenta con el identificador indicado";
}