package com.manutencaopredialapi.service;

import com.manutencaopredialapi.dto.TecnicoRequestDTO;
import com.manutencaopredialapi.dto.TecnicoResponseDTO;
import com.manutencaopredialapi.exception.ResourceNotFoundException;
import com.manutencaopredialapi.mapper.TecnicoMapper;
import com.manutencaopredialapi.model.Tecnico;
import com.manutencaopredialapi.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    @Autowired
    private TecnicoMapper mapper;

    @Transactional(readOnly = true)
    public List<TecnicoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TecnicoResponseDTO buscar(Long id) {
        Tecnico entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Tecnico não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public TecnicoResponseDTO criar(TecnicoRequestDTO dto) {
        Tecnico entity = mapper.toEntity(dto);
        Tecnico salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public TecnicoResponseDTO atualizar(Long id, TecnicoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Tecnico não encontrado com id: " + id);
        }
        Tecnico entity = mapper.toEntity(dto);
        entity.setId(id);
        Tecnico salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Tecnico não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
