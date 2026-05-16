package dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.adapter;

import dev.cardiza.clientescuentas.domain.model.Cliente;
import dev.cardiza.clientescuentas.domain.port.out.ClienteRepositoryPort;
import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.mapper.ClienteMapper;
import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteRepository jpaRepository;

    @Override
    public List<Cliente> findAll() {
        return jpaRepository.findAll().stream()
                .map(ClienteMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Cliente> findByDni(String dni) {
        return jpaRepository.findById(dni)
                .map(ClienteMapper::toDomain);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return ClienteMapper.toDomain(
                jpaRepository.save(ClienteMapper.toEntity(cliente))
        );
    }
}