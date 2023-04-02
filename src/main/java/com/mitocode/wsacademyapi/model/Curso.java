package com.mitocode.wsacademyapi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Curso {
   @EqualsAndHashCode.Include
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idCurso;
   @Column(nullable = false)
   private String nombreCurso;
   @Column(nullable = false)
   private String siglaCurso;
   @Column(nullable = false)
   private boolean estadoCurso;
}
