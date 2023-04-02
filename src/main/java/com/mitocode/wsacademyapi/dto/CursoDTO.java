package com.mitocode.wsacademyapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDTO {

    private Integer idCurso;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    private String nombreCurso;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 3)
    private String siglaCurso;
    @NotNull
    private boolean estadoCurso;
}
