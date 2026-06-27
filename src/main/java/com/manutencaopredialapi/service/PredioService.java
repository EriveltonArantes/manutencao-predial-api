package com.manutencaopredialapi.service;

import com.manutencaopredialapi.dto.PredioRequestDTO;
import com.manutencaopredialapi.dto.PredioResponseDTO;
import com.manutencaopredialapi.exception.ResourceNotFoundException;
import com.manutencaopredialapi.mapper.PredioMapper;
import com.manutencaopredialapi.model.Predio;
import com.manutencaopredialapi.repository.PredioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PredioService {

    @Autowired
    private PredioRepository repository;

    @Autowired
    private PredioMapper mapper;

    @Transactional(readOnly = true)
    public List<PredioResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PredioResponseDTO buscar(Long id) {
        Predio entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Predio não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public PredioResponseDTO criar(PredioRequestDTO dto) {
        Predio entity = mapper.toEntity(dto);
        Predio salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public PredioResponseDTO atualizar(Long id, PredioRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Predio não encontrado com id: " + id);
        }
        Predio entity = mapper.toEntity(dto);
        entity.setId(id);
        Predio salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Predio não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
