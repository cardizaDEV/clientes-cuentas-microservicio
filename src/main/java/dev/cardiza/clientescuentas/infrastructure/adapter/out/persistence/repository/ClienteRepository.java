package dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.repository;

import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
}