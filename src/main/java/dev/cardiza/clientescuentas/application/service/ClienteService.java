package dev.cardiza.clientescuentas.application.service;

import dev.cardiza.clientescuentas.domain.model.Cliente;
import dev.cardiza.clientescuentas.domain.port.in.ClienteUseCase;
import dev.cardiza.clientescuentas.domain.port.in.CuentaBancariaUseCase;
import dev.cardiza.clientescuentas.domain.port.out.ClienteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService implements ClienteUseCase {

    private final ClienteRepositoryPort clienteRepository;
    private final CuentaBancariaUseCase cuentaBancariaUseCase;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> findAdults() {
        return clienteRepository.findAll().stream()
                .filter(this::isAdult)
                .toList();
    }

    @Override
    public List<Cliente> findWithTotalGreaterThan(Double amount) {
        return clienteRepository.findAll().stream()
                .filter(cliente -> totalBalance(cliente.getDni()) > amount)
                .toList();
    }

    @Override
    public Optional<Cliente> findByDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    private boolean isAdult(Cliente cliente) {
        LocalDate fechaNacimiento = cliente.getFechaNacimiento();
        if (fechaNacimiento == null) {
            return false;
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    private double totalBalance(String dni) {
        return cuentaBancariaUseCase.findByDniCliente(dni).stream()
                .mapToDouble(cuenta -> cuenta.getTotal() == null ? 0.0 : cuenta.getTotal())
                .sum();
    }
}