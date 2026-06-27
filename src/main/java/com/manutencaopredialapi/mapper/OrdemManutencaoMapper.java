package com.manutencaopredialapi.mapper;

import com.manutencaopredialapi.dto.OrdemManutencaoRequestDTO;
import com.manutencaopredialapi.dto.OrdemManutencaoResponseDTO;
import com.manutencaopredialapi.model.OrdemManutencao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrdemManutencaoMapper {

    @Mapping(target = "equipamento", ignore = true)
    @Mapping(target = "tecnico", ignore = true)
    OrdemManutencao toEntity(OrdemManutencaoRequestDTO dto);

    @Mapping(target = "equipamentoId", source = "equipamento.id")
    @Mapping(target = "tecnicoId", source = "tecnico.id")
    OrdemManutencaoResponseDTO toResponseDTO(OrdemManutencao entity);
}
