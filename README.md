## Ejecución del proyecto

Ejecutar desde la raíz del proyecto:

```bash
mvnw spring-boot:run
```

## Ejecución de los tests

Ejecutar desde la raíz del proyecto:

```bash
mvnw test
```

## Endpoints disponibles

| Método | Ruta                                        | Descripción                                              |
|--------|---------------------------------------------|----------------------------------------------------------|
| GET    | `/clientes`                                 | Obtener todos los clientes con sus cuentas               |
| GET    | `/clientes/mayores-de-edad`                 | Obtener clientes mayores de 18 años                      |
| GET    | `/clientes/con-cuenta-superior-a/{cantidad}`| Obtener clientes cuya suma de cuentas supera la cantidad |
| GET    | `/clientes/{dni}`                           | Obtener un cliente por DNI con sus cuentas               |
| POST   | `/cuentas`                                  | Crear una nueva cuenta bancaria                          |
| PUT    | `/cuentas/{idCuenta}`                       | Actualizar el saldo de una cuenta bancaria               |

La documentación completa con ejemplos está disponible en Swagger:
`http://localhost:8080/swagger-ui.html`

## Ejemplos de peticiones



**POST /cuentas** — Crear cuenta para cliente (nuevo/existente):
```json
{
  "dniCliente": "99999999Z",
  "tipoCuenta": "PREMIUM",
  "total": 10000
}
```

```json
{
  "dniCliente": "11111111A",
  "tipoCuenta": "PREMIUM",
  "total": 10000
}
```

**PUT /cuentas/1** — Actualizar saldo:
```json
{
  "total": 180000
}
```

## Decisiones técnicas

- **Java 17.** El enunciado permite 17 o superior. Opto por 17 porque las features añadidas en 21 no aportan valor
en esta prueba. 17 sigue siendo LTS y cubre todo lo necesario.


- **Sin dependencias de mapeo.** Descarto MapStruct porque para los mapeos de esta prueba los records son suficiente.
En un proyecto con más entidades y mapeos complejos sí compensaría.


- **Total negativo.** Permito que una cuenta tenga un saldo negativo por posibles descubiertos.


- **Validación con patrones.** El dni debe seguir el patron `[0-9]{8}[A-Z]` y las cuentas deben ser de tipo
  `JUNIOR`, `NORMAL` o `PREMIUM`.

## Consideraciones

El código se ciñe a lo solicitado. En un proyecto real plantearía las siguientes mejoras:

- **`tipoCuenta` como `enum`.** El enunciado lo define como `String` y actualmente se valida con `@Pattern` pero al ser 
  un conjunto cerrado sería mejor definirlo directamente como `enum`.


- **`total` como `BigDecimal`.** El enunciado especifica `Double`, pero no es lo más correcto al trabajar con dinero.


- **`Cliente` agrega sus cuentas.** Aunque el enunciado define las dos entidades por separado, todos los endpoints
  devuelven cliente con sus cuentas. Definir `Cliente` con `List<CuentaBancaria>` sería más sencillo.


- **Código en inglés con mensajes en español.** Por seguir lo solicitado, todo el código (nombres de: modelos, DTOs...) 
  está parcialmente en español. En un proyecto real mantendría el código en inglés y dejaría el español solo para los 
  mensajes que ve el usuario final.


- **`Cuenta bancaria` crea `Cliente`.** Al crear una cuenta, si el `Cliente` no existe se crea uno unicamente con el 
  dato de `dni`, creo que lo mas correcto sería devolver un mensaje de que no existe ese cliente, y tener un endpoint 
  para poder crearlo al completo, teniendo todos los datos y delegando la lógica de su creación al propio servicio 
  de `Cliente`.