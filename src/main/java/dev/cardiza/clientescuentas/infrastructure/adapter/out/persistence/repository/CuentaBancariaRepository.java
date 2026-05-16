package dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.repository;

import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.entity.CuentaBancariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancariaEntity, Long> {

    List<CuentaBancariaEntity> findByDniCliente(String dniCliente);
}