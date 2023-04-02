package com.mitocode.wsacademyapi.service.Impl;

import com.mitocode.wsacademyapi.model.Estudiante;
import com.mitocode.wsacademyapi.repo.IEstudianteRepo;
import com.mitocode.wsacademyapi.repo.IGenericRepo;
import com.mitocode.wsacademyapi.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;
    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Estudiante> getEstudianteEdadDesc() {
        return repo.findAll()
                .stream()
                .sorted(Comparator.comparing(Estudiante::getEdadEstudiante).reversed())
                .collect(Collectors.toList());
    }
}
