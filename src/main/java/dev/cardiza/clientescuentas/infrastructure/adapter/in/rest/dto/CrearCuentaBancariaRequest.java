package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto;

import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ValidationMessages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ValidationValues.*;

@Schema(description = OpenApiDescriptions.CREATE_CUENTA_REQUEST)
public record CrearCuentaBancariaRequest(

        @Schema(description = OpenApiDescriptions.CLIENTE_DNI, example = OpenApiExamples.DNI)
        @NotBlank(message = ValidationMessages.CLIENTE_DNI_REQUIRED)
        @Pattern(regexp = DNI_PATTERN, message = ValidationMessages.CLIENTE_DNI_INVALID)
        String dniCliente,

        @Schema(description = OpenApiDescriptions.CUENTA_TYPE, example = OpenApiExamples.CUENTA_TYPE_NORMAL)
        @NotBlank(message = ValidationMessages.ACCOUNT_TYPE_REQUIRED)
        @Pattern(regexp = TIPO_PATTERN, message = ValidationMessages.ACCOUNT_TYPE_INVALID)
        String tipoCuenta,

        @Schema(description = OpenApiDescriptions.INITIAL_TOTAL, example = OpenApiExamples.TOTAL_NORMAL)
        @NotNull(message = ValidationMessages.TOTAL_REQUIRED)
        Double total
) {
}