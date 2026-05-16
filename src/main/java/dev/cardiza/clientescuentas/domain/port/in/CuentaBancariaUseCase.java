package dev.cardiza.clientescuentas.domain.port.in;

import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;

import java.util.List;

public interface CuentaBancariaUseCase {

    CuentaBancaria create(String dniCliente, String tipoCuenta, Double total);

    CuentaBancaria updateTotal(Long id, Double newTotal);

    List<CuentaBancaria> findByDniCliente(String dniCliente);
}