package com.manutencaopredialapi.service;

import com.manutencaopredialapi.dto.EquipamentoRequestDTO;
import com.manutencaopredialapi.dto.EquipamentoResponseDTO;
import com.manutencaopredialapi.exception.ResourceNotFoundException;
import com.manutencaopredialapi.mapper.EquipamentoMapper;
import com.manutencaopredialapi.model.Equipamento;
import com.manutencaopredialapi.repository.EquipamentoRepository;
import com.manutencaopredialapi.repository.PredioRepository;
import com.manutencaopredialapi.model.Predio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    @Autowired
    private EquipamentoMapper mapper;

    @Autowired
    private PredioRepository predioRepository;

    @Transactional(readOnly = true)
    public List<EquipamentoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EquipamentoResponseDTO buscar(Long id) {
        Equipamento entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EquipamentoResponseDTO criar(EquipamentoRequestDTO dto) {
        Equipamento entity = mapper.toEntity(dto);
        Predio predio = predioRepository.findById(dto.getPredioId())
            .orElseThrow(() -> new ResourceNotFoundException("Predio não encontrado com id: " + dto.getPredioId()));
        entity.setPredio(predio);
        Equipamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EquipamentoResponseDTO atualizar(Long id, EquipamentoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Equipamento não encontrado com id: " + id);
        }
        Equipamento entity = mapper.toEntity(dto);
        entity.setId(id);
        Predio predio = predioRepository.findById(dto.getPredioId())
            .orElseThrow(() -> new ResourceNotFoundException("Predio não encontrado com id: " + dto.getPredioId()));
        entity.setPredio(predio);
        Equipamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Equipamento não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
