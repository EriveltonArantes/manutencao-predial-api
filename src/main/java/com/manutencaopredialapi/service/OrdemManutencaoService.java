package com.manutencaopredialapi.service;

import com.manutencaopredialapi.dto.OrdemManutencaoRequestDTO;
import com.manutencaopredialapi.dto.OrdemManutencaoResponseDTO;
import com.manutencaopredialapi.exception.ResourceNotFoundException;
import com.manutencaopredialapi.mapper.OrdemManutencaoMapper;
import com.manutencaopredialapi.model.OrdemManutencao;
import com.manutencaopredialapi.repository.OrdemManutencaoRepository;
import com.manutencaopredialapi.repository.EquipamentoRepository;
import com.manutencaopredialapi.model.Equipamento;
import com.manutencaopredialapi.repository.TecnicoRepository;
import com.manutencaopredialapi.model.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrdemManutencaoService {

    @Autowired
    private OrdemManutencaoRepository repository;

    @Autowired
    private OrdemManutencaoMapper mapper;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Transactional(readOnly = true)
    public List<OrdemManutencaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrdemManutencaoResponseDTO buscar(Long id) {
        OrdemManutencao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("OrdemManutencao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public OrdemManutencaoResponseDTO criar(OrdemManutencaoRequestDTO dto) {
        OrdemManutencao entity = mapper.toEntity(dto);
        Equipamento equipamento = equipamentoRepository.findById(dto.getEquipamentoId())
            .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado com id: " + dto.getEquipamentoId()));
        entity.setEquipamento(equipamento);
        Tecnico tecnico = tecnicoRepository.findById(dto.getTecnicoId())
            .orElseThrow(() -> new ResourceNotFoundException("Tecnico não encontrado com id: " + dto.getTecnicoId()));
        entity.setTecnico(tecnico);
        OrdemManutencao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public OrdemManutencaoResponseDTO atualizar(Long id, OrdemManutencaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("OrdemManutencao não encontrado com id: " + id);
        }
        OrdemManutencao entity = mapper.toEntity(dto);
        entity.setId(id);
        Equipamento equipamento = equipamentoRepository.findById(dto.getEquipamentoId())
            .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado com id: " + dto.getEquipamentoId()));
        entity.setEquipamento(equipamento);
        Tecnico tecnico = tecnicoRepository.findById(dto.getTecnicoId())
            .orElseThrow(() -> new ResourceNotFoundException("Tecnico não encontrado com id: " + dto.getTecnicoId()));
        entity.setTecnico(tecnico);
        OrdemManutencao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("OrdemManutencao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
