package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.controller;

import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;
import dev.cardiza.clientescuentas.domain.port.in.CuentaBancariaUseCase;
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
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiRoutes.CUENTAS)
@RequiredArgsConstructor
@Tag(name = OpenApiDescriptions.TAG_CUENTAS, description = OpenApiDescriptions.TAG_CUENTAS_DESC)
public class CuentaBancariaController {

    private final CuentaBancariaUseCase cuentaBancariaUseCase;

    @PostMapping
    @Operation(
            summary = OpenApiDescriptions.OP_CREATE_CUENTA,
            description = OpenApiDescriptions.OP_CREATE_CUENTA_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.CREATED, description = OpenApiDescriptions.RESP_201_CUENTA_CREATED)
    @ApiResponse(responseCode = HttpStatusCodes.BAD_REQUEST, description = OpenApiDescriptions.RESP_400_INVALID_DATA)
    public ResponseEntity<CuentaBancariaResponse> create(
            @Valid @RequestBody CrearCuentaBancariaRequest request
    ) {
        CuentaBancaria cuenta = cuentaBancariaUseCase.create(
                request.dniCliente(),
                request.tipoCuenta(),
                request.total()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(CuentaBancariaResponse.from(cuenta));
    }

    @PutMapping(ApiRoutes.BY_CUENTA_ID)
    @Operation(
            summary = OpenApiDescriptions.OP_UPDATE_BALANCE,
            description = OpenApiDescriptions.OP_UPDATE_BALANCE_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_CUENTA_UPDATED)
    @ApiResponse(responseCode = HttpStatusCodes.BAD_REQUEST, description = OpenApiDescriptions.RESP_400_INVALID_DATA)
    @ApiResponse(responseCode = HttpStatusCodes.NOT_FOUND, description = OpenApiDescriptions.RESP_404_CUENTA_NOT_FOUND)
    public ResponseEntity<CuentaBancariaResponse> updateTotal(
            @Parameter(description = OpenApiDescriptions.PARAM_CUENTA_ID, example = OpenApiExamples.CUENTA_ID)
            @PathVariable(ApiRoutes.PV_CUENTA_ID) Long id,
            @Valid @RequestBody ActualizarSaldoRequest request
    ) {
        CuentaBancaria cuenta = cuentaBancariaUseCase.updateTotal(id, request.total());
        return ResponseEntity.ok(CuentaBancariaResponse.from(cuenta));
    }
}