package dev.cardiza.clientescuentas.domain.port.out;

import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;

import java.util.List;
import java.util.Optional;

public interface CuentaBancariaRepositoryPort {

    List<CuentaBancaria> findAll();

    List<CuentaBancaria> findByDniCliente(String dniCliente);

    Optional<CuentaBancaria> findById(Long id);

    CuentaBancaria save(CuentaBancaria cuenta);
}