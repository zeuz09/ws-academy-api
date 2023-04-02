package com.mitocode.wsacademyapi.service;

import com.mitocode.wsacademyapi.model.Matricula;

import java.util.List;
import java.util.Map;

public interface IMatriculaService extends ICRUD<Matricula,Integer>{

    Map<String, List<String>> getCursosxEstudiantesMatriculados();

}
