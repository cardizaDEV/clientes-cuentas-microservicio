package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto;

import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = OpenApiDescriptions.CUENTA_RESPONSE)
public record CuentaResponse(

        @Schema(description = OpenApiDescriptions.ID_CUENTA, example = OpenApiExamples.ID_CUENTA)
        Long id,

        @Schema(description = OpenApiDescriptions.DNI_CLIENTE, example = OpenApiExamples.DNI)
        String dniCliente,

        @Schema(description = OpenApiDescriptions.TIPO_CUENTA, example = OpenApiExamples.TIPO_CUENTA_PREMIUM)
        String tipoCuenta,

        @Schema(description = OpenApiDescriptions.TOTAL, example = OpenApiExamples.TOTAL_PREMIUM)
        Double total
) {
}