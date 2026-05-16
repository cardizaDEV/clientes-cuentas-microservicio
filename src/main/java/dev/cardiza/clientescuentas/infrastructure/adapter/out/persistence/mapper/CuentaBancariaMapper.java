package dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.mapper;

import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;
import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.entity.CuentaBancariaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CuentaBancariaMapper {

    public static CuentaBancaria toDomain(CuentaBancariaEntity entity) {
        return new CuentaBancaria(
                entity.getId(),
                entity.getDniCliente(),
                entity.getTipoCuenta(),
                entity.getTotal()
        );
    }

    public static CuentaBancariaEntity toEntity(CuentaBancaria cuenta) {
        return new CuentaBancariaEntity(
                cuenta.getId(),
                cuenta.getDniCliente(),
                cuenta.getTipoCuenta(),
                cuenta.getTotal()
        );
    }
}