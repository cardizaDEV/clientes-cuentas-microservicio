package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto;

import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

@Schema(description = OpenApiDescriptions.CLIENTE_RESPONSE)
public record ClienteResponse(

        @Schema(description = OpenApiDescriptions.DNI, example = OpenApiExamples.DNI)
        String dni,

        @Schema(description = OpenApiDescriptions.NOMBRE, example = OpenApiExamples.NOMBRE)
        String nombre,

        @Schema(description = OpenApiDescriptions.APELLIDO_1, example = OpenApiExamples.APELLIDO_1)
        String apellido1,

        @Schema(description = OpenApiDescriptions.APELLIDO_2, example = OpenApiExamples.APELLIDO_2)
        String apellido2,

        @Schema(description = OpenApiDescriptions.FECHA_NACIMIENTO, example = OpenApiExamples.FECHA_NACIMIENTO)
        LocalDate fechaNacimiento,

        @Schema(description = OpenApiDescriptions.CUENTAS)
        List<CuentaResponse> cuentas
) {
}