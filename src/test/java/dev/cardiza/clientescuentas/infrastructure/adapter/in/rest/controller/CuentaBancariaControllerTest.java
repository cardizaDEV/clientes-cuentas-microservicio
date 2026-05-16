package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.controller;

import dev.cardiza.clientescuentas.application.exception.CuentaBancariaNotFoundException;
import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;
import dev.cardiza.clientescuentas.domain.port.in.CuentaBancariaUseCase;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants.ApiRoutes;
import dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({CuentaBancariaController.class, GlobalExceptionHandler.class})
class CuentaBancariaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CuentaBancariaUseCase cuentaBancariaUseCase;

    @Test
    void create_201_New() throws Exception {
        CuentaBancaria cuenta = new CuentaBancaria(1L, "11111222A", "NORMAL", 50000.0);
        when(cuentaBancariaUseCase.create("11111222A", "NORMAL", 50000.0)).thenReturn(cuenta);

        mockMvc.perform(post(ApiRoutes.CUENTAS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dniCliente\": \"11111222A\", \"tipoCuenta\": \"NORMAL\", \"total\": 50000.0}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.dniCliente").value("11111222A"))
                .andExpect(jsonPath("$.tipoCuenta").value("NORMAL"))
                .andExpect(jsonPath("$.total").value("50000.0"));
    }

    @Test
    void create_201_Existent() throws Exception {
        CuentaBancaria cuenta = new CuentaBancaria(1L, "11111111A", "NORMAL", 50000.0);
        when(cuentaBancariaUseCase.create("11111111A", "NORMAL", 50000.0)).thenReturn(cuenta);

        mockMvc.perform(post(ApiRoutes.CUENTAS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dniCliente\": \"11111111A\", \"tipoCuenta\": \"NORMAL\", \"total\": 50000.0}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.dniCliente").value("11111111A"))
                .andExpect(jsonPath("$.tipoCuenta").value("NORMAL"))
                .andExpect(jsonPath("$.total").value("50000.0"));
    }

    @Test
    void create_400_dniBlank() throws Exception {
        mockMvc.perform(post(ApiRoutes.CUENTAS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dniCliente\": \"\", \"tipoCuenta\": \"NORMAL\", \"total\": 50000.0}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void create_400_tipoCuentaBlank() throws Exception {
        mockMvc.perform(post(ApiRoutes.CUENTAS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dniCliente\": \"11111111A\", \"tipoCuenta\": \"\", \"total\": 50000.0}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void create_400_dniNull() throws Exception {
        mockMvc.perform(post(ApiRoutes.CUENTAS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dniCliente\": null, \"tipoCuenta\": \"NORMAL\", \"total\": 50000.0}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void create_400_tipoCuentaNull() throws Exception {
        mockMvc.perform(post(ApiRoutes.CUENTAS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dniCliente\": \"11111111A\", \"tipoCuenta\": null, \"total\": 50000.0}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void create_400_totalNull() throws Exception {
        mockMvc.perform(post(ApiRoutes.CUENTAS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dniCliente\": \"11111111A\", \"tipoCuenta\": \"NORMAL\", \"total\": null}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void create_400_dniInvalid() throws Exception {
        mockMvc.perform(post(ApiRoutes.CUENTAS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dniCliente\": \"INVALIDO\", \"tipoCuenta\": \"NORMAL\", \"total\": 50000.0}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void create_400_tipoCuentaInvalid() throws Exception {
        mockMvc.perform(post(ApiRoutes.CUENTAS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"dniCliente\": \"11111111A\", \"tipoCuenta\": \"INVALIDO\", \"total\": 50000.0}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateTotal_200() throws Exception {
        CuentaBancaria cuenta = new CuentaBancaria(1L, "11111111A", "NORMAL", 50000.0);
        when(cuentaBancariaUseCase.updateTotal(1L, 50000.0)).thenReturn(cuenta);

        mockMvc.perform(put(ApiRoutes.CUENTAS + ApiRoutes.BY_CUENTA_ID.replace("{idCuenta}", "1"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"total\": 50000.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.dniCliente").value("11111111A"))
                .andExpect(jsonPath("$.tipoCuenta").value("NORMAL"))
                .andExpect(jsonPath("$.total").value(50000.0));
    }

    @Test
    void updateTotal_404() throws Exception {
        when(cuentaBancariaUseCase.updateTotal(99L, 180000.0)).thenThrow(new CuentaBancariaNotFoundException(99L));

        mockMvc.perform(put(ApiRoutes.CUENTAS + ApiRoutes.BY_CUENTA_ID.replace("{idCuenta}", "99"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"total\": 180000.0}"))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateTotal_400_totalNull() throws Exception {
        mockMvc.perform(put(ApiRoutes.CUENTAS + ApiRoutes.BY_CUENTA_ID.replace("{idCuenta}", "1"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"total\": null}"))
                .andExpect(status().isBadRequest());
    }
}