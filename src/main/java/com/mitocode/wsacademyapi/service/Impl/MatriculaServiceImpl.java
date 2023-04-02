package com.mitocode.wsacademyapi.service.Impl;

import com.mitocode.wsacademyapi.model.DetalleMatricula;
import com.mitocode.wsacademyapi.model.Matricula;
import com.mitocode.wsacademyapi.repo.IGenericRepo;
import com.mitocode.wsacademyapi.repo.IMatriculaRepo;
import com.mitocode.wsacademyapi.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<String>> getCursosxEstudiantesMatriculados() {
        Stream<List<DetalleMatricula>> stream = repo.findAll()
                                                    .stream().map(Matricula::getDetalleMatricula);
        Stream <DetalleMatricula> stream2 = stream.flatMap(Collection::stream);

        Map<String, List<String>> resultado = stream2
                .collect(groupingBy
                        (e-> e.getCurso().getNombreCurso(),
                                Collectors.mapping(e-> (e.getMatricula().getEstudiante().getNombresEstudiante() + " "+
                                        e.getMatricula().getEstudiante().getApellidosEstudiante()),
                                        Collectors.toList()))
                );
        return resultado;
    }
}
