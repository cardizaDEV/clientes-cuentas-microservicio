package dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.mapper;

import dev.cardiza.clientescuentas.domain.model.Cliente;
import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.entity.ClienteEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClienteMapper {

    public static Cliente toDomain(ClienteEntity entity) {
        return new Cliente(
                entity.getDni(),
                entity.getNombre(),
                entity.getApellido1(),
                entity.getApellido2(),
                entity.getFechaNacimiento()
        );
    }

    public static ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(
                cliente.getDni(),
                cliente.getNombre(),
                cliente.getApellido1(),
                cliente.getApellido2(),
                cliente.getFechaNacimiento()
        );
    }
}