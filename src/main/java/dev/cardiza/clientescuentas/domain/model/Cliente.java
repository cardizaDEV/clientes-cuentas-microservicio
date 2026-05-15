package dev.cardiza.clientescuentas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
}