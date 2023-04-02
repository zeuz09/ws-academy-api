package com.mitocode.wsacademyapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {

    private Integer idMatricula;
    @NotNull
    private EstudianteDTO estudiante;
    @NotNull
    private LocalTime fechaMatricula;
    @NotNull
    private boolean estadoMatricula;

    @NotNull
    @JsonManagedReference
    private List<DetalleMatriculaDTO> detalleMatricula;
}
