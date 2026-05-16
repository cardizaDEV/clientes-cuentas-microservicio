package dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.entity;

import dev.cardiza.clientescuentas.infrastructure.adapter.out.persistence.constants.EntityConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = EntityConstants.TABLE_CLIENTES)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    @Id
    @Column(length = EntityConstants.DNI_LENGTH)
    private String dni;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
}