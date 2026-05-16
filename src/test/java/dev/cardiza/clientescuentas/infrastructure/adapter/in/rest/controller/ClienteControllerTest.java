package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.controller;

import dev.cardiza.clientescuentas.domain.model.Cliente;
import dev.cardiza.clientescuentas.domain.port.in.ClienteUseCase;
import dev.cardiza.clientescuentas.domain.port.in.CuentaBancariaUseCase;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ApiRoutes;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ClienteController.class, GlobalExceptionHandler.class})
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClienteUseCase clienteUseCase;

    @MockitoBean
    private CuentaBancariaUseCase cuentaBancariaUseCase;

    @Test
    void findAll_200() throws Exception {
        when(clienteUseCase.findAll()).thenReturn(List.of());

        mockMvc.perform(get(ApiRoutes.CLIENTES))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void findByDni_200() throws Exception {
        Cliente cliente = new Cliente("11111111A", "Juan", "Pérez", "López",
                LocalDate.of(1959, 9, 12));
        when(clienteUseCase.findByDni("11111111A")).thenReturn(Optional.of(cliente));
        when(cuentaBancariaUseCase.findByDniCliente("11111111A")).thenReturn(List.of());

        mockMvc.perform(get(ApiRoutes.CLIENTES + "/11111111A"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dni").value("11111111A"));
    }

    @Test
    void findByDni_404() throws Exception {
        when(clienteUseCase.findByDni("1")).thenReturn(Optional.empty());

        mockMvc.perform(get(ApiRoutes.CLIENTES + "/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void findAdults_200() throws Exception {
        when(clienteUseCase.findAdults()).thenReturn(List.of());

        mockMvc.perform(get(ApiRoutes.CLIENTES + ApiRoutes.ADULTS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void findWithTotalGreaterThan_200() throws Exception {
        when(clienteUseCase.findWithTotalGreaterThan(anyDouble())).thenReturn(List.of());

        mockMvc.perform(get(ApiRoutes.CLIENTES + ApiRoutes.WITH_TOTAL_GREATER_THAN
                        .replace("{cantidad}", "1000.0")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}