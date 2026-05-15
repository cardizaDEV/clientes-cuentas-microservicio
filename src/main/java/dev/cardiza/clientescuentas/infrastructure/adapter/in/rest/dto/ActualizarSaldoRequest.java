package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto;

import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ValidationMessages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = OpenApiDescriptions.ACTUALIZAR_SALDO_REQUEST)
public record ActualizarSaldoRequest(

        @Schema(description = OpenApiDescriptions.TOTAL_NUEVO, example = OpenApiExamples.TOTAL_ACTUALIZADO)
        @NotNull(message = ValidationMessages.TOTAL_OBLIGATORIO)
        @PositiveOrZero(message = ValidationMessages.TOTAL_NO_NEGATIVO)
        Double total
) {
}