package com.mitocode.wsacademyapi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Estudiante {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;
    @Column(nullable = false)
    private String nombresEstudiante;
    @Column(nullable = false)
    private String apellidosEstudiante;
    @Column(nullable = false)
    private String dniEstudiante;
    @Column(nullable = false)
    private short edadEstudiante;
}
