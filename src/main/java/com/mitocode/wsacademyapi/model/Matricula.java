package com.mitocode.wsacademyapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Matricula {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;
    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name= "FK_Matricula_Estudiante"))
    private Estudiante estudiante;
    @Column(nullable = false)
    private LocalTime fechaMatricula;
    @Column(nullable = false)
    private boolean estadoMatricula;
    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetalleMatricula> detalleMatricula;
}
