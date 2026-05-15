package dev.cardiza.clientescuentas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuentaBancaria {

    private Long id;
    private String dniCliente;
    private String tipoCuenta;
    private Double total;
}