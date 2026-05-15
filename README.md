## Ejecución del proyecto

Ejecutar desde la raiz del proyecto `mvnw spring-boot:run`

## Ejecución de los test

## Endpoints disponibles

## Ejemplos de peticiones

## Decisiones técnicas

- **Java 17.** El enunciado permite 17 o superior. Opto por 17 porque las features añadidas en 21 no aportan valor
en esta prueba. 17 sigue siendo LTS y cubre todo lo necesario.


- **Sin dependencias de mapeo.** Descarto MapStruct porque para los mapeos de esta prueba los records son suficiente.
En un proyecto con más entidades y mapeos complejos sí compensaría.

## Consideraciones

El código se ciñe a lo solicitado. En un proyecto real plantearía las siguientes mejoras:

- **`tipoCuenta` como enum.** El enunciado lo define como String, pero los valores son un conjunto cerrado
(PREMIUM, NORMAL, JUNIOR).


- **`total` como `BigDecimal`.** El enunciado especifica Double, pero no es lo más correcto al trabajar con dinero.


- **`Cliente` agrega sus cuentas.** Aunque el enunciado define las dos entidades por separado, todos los endpoints
  devuelven cliente con sus cuentas. Definir `Cliente` con `List<CuentaBancaria>` simplificaría mucho la lógica
  de negocio.


- **Código en inglés con mensajes en español.** Por seguir lo solicitado, todo el código (modelos, DTOs...) está 
  en español. En un proyecto real mantendría el código en inglés y dejaría el español solo para los mensajes que ve 
  el usuario final.