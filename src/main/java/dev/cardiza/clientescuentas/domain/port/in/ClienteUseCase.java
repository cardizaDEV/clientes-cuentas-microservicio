package dev.cardiza.clientescuentas.domain.port.in;

import dev.cardiza.clientescuentas.domain.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteUseCase {

    List<Cliente> findAll();

    List<Cliente> findAdults();

    List<Cliente> findWithTotalGreaterThan(Double amount);

    Optional<Cliente> findByDni(String dni);
}