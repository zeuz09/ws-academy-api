package com.mitocode.wsacademyapi.service;


import com.mitocode.wsacademyapi.model.Estudiante;

import java.util.List;

public interface IEstudianteService extends ICRUD<Estudiante,Integer>{
    List<Estudiante> getEstudianteEdadDesc();// Obtener una lista de estudiantes ordenados por edad de forma descendente
}
