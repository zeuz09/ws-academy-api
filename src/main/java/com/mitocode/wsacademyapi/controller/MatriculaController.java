package com.mitocode.wsacademyapi.controller;

import com.mitocode.wsacademyapi.dto.MatriculaDTO;
import com.mitocode.wsacademyapi.model.Matricula;
import com.mitocode.wsacademyapi.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {
    private final IMatriculaService matriculaService;

    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> readAll() throws Exception{
        List<MatriculaDTO> list = matriculaService.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Matricula obj = matriculaService.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> create(@Valid @RequestBody MatriculaDTO dto) throws Exception {
        Matricula obj = matriculaService.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MatriculaDTO dto) throws Exception {
        dto.setIdMatricula(id);
        Matricula obj = matriculaService.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        matriculaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getCursosxEstudiantesMatriculados")
    public ResponseEntity<Map<String, List<String>>> getCursosxEstudiantesMatriculados(){
        Map<String, List<String>> map = matriculaService.getCursosxEstudiantesMatriculados();
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    private MatriculaDTO convertToDto(Matricula obj){
        return mapper.map(obj, MatriculaDTO.class);
    }

    private Matricula convertToEntity(MatriculaDTO dto){
        return mapper.map(dto, Matricula.class);
    }
}
