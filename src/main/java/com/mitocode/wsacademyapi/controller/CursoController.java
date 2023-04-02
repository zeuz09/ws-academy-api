package com.mitocode.wsacademyapi.controller;

import com.mitocode.wsacademyapi.dto.CursoDTO;
import com.mitocode.wsacademyapi.model.Curso;
import com.mitocode.wsacademyapi.service.ICursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService cursoService;

    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> readAll() throws Exception{
        List<CursoDTO> list = cursoService.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Curso obj = cursoService.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> create(@Valid @RequestBody CursoDTO dto) throws Exception {
        Curso obj = cursoService.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CursoDTO dto) throws Exception {
        dto.setIdCurso(id);
        Curso obj = cursoService.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    private CursoDTO convertToDto(Curso obj){
        return mapper.map(obj, CursoDTO.class);
    }

    private Curso convertToEntity(CursoDTO dto){
        return mapper.map(dto, Curso.class);
    }
}
