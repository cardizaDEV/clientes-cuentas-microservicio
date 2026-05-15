package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto;

import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ValidationMessages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = OpenApiDescriptions.CREAR_CUENTA_BANCARIA_REQUEST)
public record CrearCuentaBancariaRequest(

        @Schema(description = OpenApiDescriptions.DNI_CLIENTE, example = OpenApiExamples.DNI)
        @NotBlank(message = ValidationMessages.DNI_CLIENTE_OBLIGATORIO)
        String dniCliente,

        @Schema(description = OpenApiDescriptions.TIPO_CUENTA_BANCARIA, example = OpenApiExamples.TIPO_CUENTA_NORMAL)
        @NotBlank(message = ValidationMessages.TIPO_CUENTA_OBLIGATORIO)
        String tipoCuenta,

        @Schema(description = OpenApiDescriptions.TOTAL_INICIAL, example = OpenApiExamples.TOTAL_NORMAL)
        @NotNull(message = ValidationMessages.TOTAL_OBLIGATORIO)
        @PositiveOrZero(message = ValidationMessages.TOTAL_NO_NEGATIVO)
        Double total
) {
}