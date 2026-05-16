package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto;

import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = OpenApiDescriptions.CUENTA_RESPONSE)
public record CuentaBancariaResponse(

        @Schema(description = OpenApiDescriptions.CUENTA_ID, example = OpenApiExamples.CUENTA_ID)
        Long id,

        @Schema(description = OpenApiDescriptions.CLIENTE_DNI, example = OpenApiExamples.DNI)
        String dniCliente,

        @Schema(description = OpenApiDescriptions.CUENTA_TYPE, example = OpenApiExamples.CUENTA_TYPE_PREMIUM)
        String tipoCuenta,

        @Schema(description = OpenApiDescriptions.TOTAL, example = OpenApiExamples.TOTAL_PREMIUM)
        Double total
) {

        public static CuentaBancariaResponse from(CuentaBancaria cuenta) {
                return new CuentaBancariaResponse(
                        cuenta.getId(),
                        cuenta.getDniCliente(),
                        cuenta.getTipoCuenta(),
                        cuenta.getTotal()
                );
        }
}