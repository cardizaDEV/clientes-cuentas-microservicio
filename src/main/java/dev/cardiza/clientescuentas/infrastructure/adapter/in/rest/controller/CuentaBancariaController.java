package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.controller;

import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ApiRoutes;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.HttpStatusCodes;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto.ActualizarSaldoRequest;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto.CrearCuentaBancariaRequest;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto.CuentaBancariaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ApiRoutes.PV_ID_CUENTA;

@RestController
@RequestMapping(ApiRoutes.CUENTAS)
@Tag(name = OpenApiDescriptions.TAG_CUENTAS_BANCARIAS, description = OpenApiDescriptions.TAG_CUENTAS_BANCARIAS_DESC)
public class CuentaBancariaController {

    @PostMapping
    @Operation(
            summary = OpenApiDescriptions.OP_CREAR_CUENTA_BANCARIA,
            description = OpenApiDescriptions.OP_CREAR_CUENTA_BANCARIA_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.CREATED, description = OpenApiDescriptions.RESP_201_CUENTA_BANCARIA_CREADA)
    @ApiResponse(responseCode = HttpStatusCodes.BAD_REQUEST, description = OpenApiDescriptions.RESP_400_DATOS_INVALIDOS)
    public ResponseEntity<CuentaBancariaResponse> create(
            @Valid @RequestBody CrearCuentaBancariaRequest request
    ) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PutMapping(ApiRoutes.POR_ID_CUENTA)
    @Operation(
            summary = OpenApiDescriptions.OP_ACTUALIZAR_SALDO,
            description = OpenApiDescriptions.OP_ACTUALIZAR_SALDO_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_CUENTA_BANCARIA_ACTUALIZADA)
    @ApiResponse(responseCode = HttpStatusCodes.BAD_REQUEST, description = OpenApiDescriptions.RESP_400_DATOS_INVALIDOS)
    @ApiResponse(responseCode = HttpStatusCodes.NOT_FOUND, description = OpenApiDescriptions.RESP_404_CUENTA_BANCARIA_NO_ENCONTRADA)
    public ResponseEntity<CuentaBancariaResponse> updateTotal(
            @Parameter(description = OpenApiDescriptions.PARAM_ID_CUENTA, example = OpenApiExamples.ID_CUENTA)
            @PathVariable(PV_ID_CUENTA) Long accountId,
            @Valid @RequestBody ActualizarSaldoRequest request
    ) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}