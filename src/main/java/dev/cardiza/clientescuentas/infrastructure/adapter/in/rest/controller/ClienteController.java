package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.controller;

import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ApiRoutes;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.HttpStatusCodes;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiDescriptions;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.OpenApiExamples;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.dto.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ApiRoutes.PV_CANTIDAD;
import static dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ApiRoutes.PV_DNI;

@RestController
@RequestMapping(ApiRoutes.CLIENTES)
@Tag(name = OpenApiDescriptions.TAG_CLIENTES, description = OpenApiDescriptions.TAG_CLIENTES_DESC)
public class ClienteController {

    @GetMapping
    @Operation(
            summary = OpenApiDescriptions.OP_OBTENER_TODOS,
            description = OpenApiDescriptions.OP_OBTENER_TODOS_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_LISTA_CLIENTES)
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping(ApiRoutes.MAYORES_DE_EDAD)
    @Operation(
            summary = OpenApiDescriptions.OP_OBTENER_MAYORES_EDAD,
            description = OpenApiDescriptions.OP_OBTENER_MAYORES_EDAD_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_LISTA_CLIENTES)
    public ResponseEntity<List<ClienteResponse>> findAdults() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping(ApiRoutes.CON_CUENTA_SUPERIOR_A)
    @Operation(
            summary = OpenApiDescriptions.OP_OBTENER_CON_SALDO_SUPERIOR,
            description = OpenApiDescriptions.OP_OBTENER_CON_SALDO_SUPERIOR_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_LISTA_CLIENTES)
    public ResponseEntity<List<ClienteResponse>> findWithTotalGreaterThan(
            @Parameter(description = OpenApiDescriptions.PARAM_CANTIDAD, example = OpenApiExamples.CANTIDAD)
            @PathVariable(PV_CANTIDAD) Double amount
    ) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping(ApiRoutes.POR_DNI)
    @Operation(
            summary = OpenApiDescriptions.OP_OBTENER_POR_DNI,
            description = OpenApiDescriptions.OP_OBTENER_POR_DNI_DESC
    )
    @ApiResponse(responseCode = HttpStatusCodes.OK, description = OpenApiDescriptions.RESP_200_CLIENTE)
    @ApiResponse(responseCode = HttpStatusCodes.NOT_FOUND, description = OpenApiDescriptions.RESP_404_CLIENTE_NO_ENCONTRADO)
    public ResponseEntity<ClienteResponse> findByDni(
            @Parameter(description = OpenApiDescriptions.PARAM_DNI, example = OpenApiExamples.DNI)
            @PathVariable(PV_DNI) String dni
    ) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}