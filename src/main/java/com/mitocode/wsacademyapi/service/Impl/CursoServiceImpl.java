package com.mitocode.wsacademyapi.service.Impl;

import com.mitocode.wsacademyapi.model.Curso;
import com.mitocode.wsacademyapi.repo.ICursoRepo;
import com.mitocode.wsacademyapi.repo.IGenericRepo;
import com.mitocode.wsacademyapi.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso, Integer> implements ICursoService {

    private final ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }

}
