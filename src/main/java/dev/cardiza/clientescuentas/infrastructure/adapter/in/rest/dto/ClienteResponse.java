package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto;

import dev.cardiza.clientescuentas.domain.model.Cliente;
import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

@Schema(description = OpenApiDescriptions.CLIENTE_RESPONSE)
public record ClienteResponse(

        @Schema(description = OpenApiDescriptions.DNI, example = OpenApiExamples.DNI)
        String dni,

        @Schema(description = OpenApiDescriptions.NAME, example = OpenApiExamples.NAME)
        String nombre,

        @Schema(description = OpenApiDescriptions.FIRST_SURNAME, example = OpenApiExamples.FIRST_SURNAME)
        String apellido1,

        @Schema(description = OpenApiDescriptions.SECOND_SURNAME, example = OpenApiExamples.SECOND_SURNAME)
        String apellido2,

        @Schema(description = OpenApiDescriptions.BIRTH_DATE, example = OpenApiExamples.BIRTH_DATE)
        LocalDate fechaNacimiento,

        @Schema(description = OpenApiDescriptions.CUENTAS)
        List<CuentaBancariaResponse> cuentas
) {

        public static ClienteResponse from(Cliente cliente, List<CuentaBancaria> cuentas) {
                return new ClienteResponse(
                        cliente.getDni(),
                        cliente.getNombre(),
                        cliente.getApellido1(),
                        cliente.getApellido2(),
                        cliente.getFechaNacimiento(),
                        cuentas.stream()
                                .map(CuentaBancariaResponse::from)
                                .toList()
                );
        }
}