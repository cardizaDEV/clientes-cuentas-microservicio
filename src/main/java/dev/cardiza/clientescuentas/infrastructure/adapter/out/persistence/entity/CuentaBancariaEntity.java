package dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.entity;

import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.constants.EntityConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = EntityConstants.TABLE_CUENTAS_BANCARIAS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuentaBancariaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = EntityConstants.DNI_LENGTH)
    private String dniCliente;

    @Column(nullable = false)
    private String tipoCuenta;

    @Column(nullable = false)
    private Double total;
}