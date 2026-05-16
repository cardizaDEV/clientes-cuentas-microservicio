package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto;

import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ValidationMessages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = OpenApiDescriptions.UPDATE_BALANCE_REQUEST)
public record ActualizarSaldoRequest(

        @Schema(description = OpenApiDescriptions.NEW_TOTAL, example = OpenApiExamples.UPDATED_TOTAL)
        @NotNull(message = ValidationMessages.TOTAL_REQUIRED)
        @PositiveOrZero(message = ValidationMessages.TOTAL_NOT_NEGATIVE)
        Double total
) {
}