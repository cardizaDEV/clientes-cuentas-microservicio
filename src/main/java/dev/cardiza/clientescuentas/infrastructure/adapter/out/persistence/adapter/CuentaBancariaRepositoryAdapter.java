package dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.adapter;

import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;
import dev.cardiza.clientescuentas.domain.port.out.CuentaBancariaRepositoryPort;
import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.mapper.CuentaBancariaMapper;
import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.repository.CuentaBancariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CuentaBancariaRepositoryAdapter implements CuentaBancariaRepositoryPort {

    private final CuentaBancariaRepository jpaRepository;

    @Override
    public List<CuentaBancaria> findByDniCliente(String dniCliente) {
        return jpaRepository.findByDniCliente(dniCliente).stream()
                .map(CuentaBancariaMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<CuentaBancaria> findById(Long id) {
        return jpaRepository.findById(id)
                .map(CuentaBancariaMapper::toDomain);
    }

    @Override
    public CuentaBancaria save(CuentaBancaria cuenta) {
        return CuentaBancariaMapper.toDomain(
                jpaRepository.save(CuentaBancariaMapper.toEntity(cuenta))
        );
    }
}