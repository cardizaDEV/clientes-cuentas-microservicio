package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.controller;

import dev.cardiza.clientescuentas.application.exception.ClienteNotFoundException;
import dev.cardiza.clientescuentas.domain.model.Cliente;
import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;
import dev.cardiza.clientescuentas.domain.port.in.ClienteUseCase;
import dev.cardiza.clientescuentas.domain.port.in.CuentaBancariaUseCase;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ApiRoutes;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.HttpStatusCodes;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiRoutes.CLIENTES)
@RequiredArgsConstructor
@Tag(name = OpenApiDescriptions.TAG_CLIENTES, description = OpenApiDescriptions.TAG_CLIENTES_DESC)
public class ClienteController {

    private final ClienteUseCase clienteUseCase;
    private final CuentaBancariaUseCase cuentaBancariaUseCase;

    @GetMapping
    @Operation(
            summary = OpenApiDescriptions.OP_FIND_ALL,
            description = OpenApiDescriptions.OP_FIND_ALL_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_CLIENTE_LIST)
    public ResponseEntity<List<ClienteResponse>> findAll() {
        List<ClienteResponse> response = clienteUseCase.findAll().stream()
                .map(this::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping(ApiRoutes.ADULTS)
    @Operation(
            summary = OpenApiDescriptions.OP_FIND_ADULTS,
            description = OpenApiDescriptions.OP_FIND_ADULTS_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_CLIENTE_LIST)
    public ResponseEntity<List<ClienteResponse>> findAdults() {
        List<ClienteResponse> response = clienteUseCase.findAdults().stream()
                .map(this::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping(ApiRoutes.WITH_TOTAL_GREATER_THAN)
    @Operation(
            summary = OpenApiDescriptions.OP_FIND_WITH_TOTAL_GREATER_THAN,
            description = OpenApiDescriptions.OP_FIND_WITH_TOTAL_GREATER_THAN_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_CLIENTE_LIST)
    public ResponseEntity<List<ClienteResponse>> findWithTotalGreaterThan(
            @Parameter(description = OpenApiDescriptions.PARAM_AMOUNT, example = OpenApiExamples.AMOUNT)
            @PathVariable(ApiRoutes.PV_AMOUNT) Double amount
    ) {
        List<ClienteResponse> response = clienteUseCase.findWithTotalGreaterThan(amount).stream()
                .map(this::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping(ApiRoutes.BY_DNI)
    @Operation(
            summary = OpenApiDescriptions.OP_FIND_BY_DNI,
            description = OpenApiDescriptions.OP_FIND_BY_DNI_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_CLIENTE)
    @ApiResponse(responseCode = HttpStatusCodes.NOT_FOUND, description = OpenApiDescriptions.RESP_404_CLIENTE_NOT_FOUND)
    public ResponseEntity<ClienteResponse> findByDni(
            @Parameter(description = OpenApiDescriptions.PARAM_DNI, example = OpenApiExamples.DNI)
            @PathVariable(ApiRoutes.PV_DNI) String dni
    ) {
        Cliente cliente = clienteUseCase.findByDni(dni)
                .orElseThrow(() -> new ClienteNotFoundException(dni));
        return ResponseEntity.ok(toResponse(cliente));
    }

    private ClienteResponse toResponse(Cliente cliente) {
        List<CuentaBancaria> cuentas = cuentaBancariaUseCase.findByDniCliente(cliente.getDni());
        return ClienteResponse.from(cliente, cuentas);
    }
}