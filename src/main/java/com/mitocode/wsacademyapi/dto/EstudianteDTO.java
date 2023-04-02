package com.mitocode.wsacademyapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {


    private Integer idEstudiante;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String nombresEstudiante;

    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String apellidosEstudiante;

    @NotNull
    @NotEmpty
    @Size(min=8, max = 8, message = "El número ingresado debe de ser de 8 dígitos")
    private String dniEstudiante;

    @NotNull
    @Digits(integer = 2, fraction = 0, message = "El valor debe ser númérico y tener exactamente 2 dígitos")
    @Min(value = 15, message = "El valor mínimo permitido es 15")
    @Max(value = 99, message = "El valor máximo permitido es 99")
    private short edadEstudiante;
}
