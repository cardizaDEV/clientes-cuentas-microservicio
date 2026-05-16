package dev.cardiza.clientescuentas.application.service;

import dev.cardiza.clientescuentas.application.exception.CuentaBancariaNotFoundException;
import dev.cardiza.clientescuentas.domain.model.Cliente;
import dev.cardiza.clientescuentas.domain.model.CuentaBancaria;
import dev.cardiza.clientescuentas.domain.port.in.CuentaBancariaUseCase;
import dev.cardiza.clientescuentas.domain.port.out.ClienteRepositoryPort;
import dev.cardiza.clientescuentas.domain.port.out.CuentaBancariaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuentaBancariaService implements CuentaBancariaUseCase {

    private final ClienteRepositoryPort clienteRepository;
    private final CuentaBancariaRepositoryPort cuentaRepository;

    @Override
    public CuentaBancaria create(String dniCliente, String tipoCuenta, Double total) {
        if (!clienteRepository.findByDni(dniCliente).isPresent()) {
            Cliente cliente = new Cliente();
            cliente.setDni(dniCliente);
            clienteRepository.save(cliente);
        }
        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.setDniCliente(dniCliente);
        cuenta.setTipoCuenta(tipoCuenta);
        cuenta.setTotal(total);
        return cuentaRepository.save(cuenta);
    }

    @Override
    public CuentaBancaria updateTotal(Long id, Double newTotal) {
        CuentaBancaria cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new CuentaBancariaNotFoundException(id));
        cuenta.setTotal(newTotal);
        return cuentaRepository.save(cuenta);
    }

    @Override
    public List<CuentaBancaria> findByDniCliente(String dniCliente) {
        return cuentaRepository.findByDniCliente(dniCliente);
    }
}