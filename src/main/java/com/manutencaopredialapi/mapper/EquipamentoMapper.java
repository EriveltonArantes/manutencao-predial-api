package com.manutencaopredialapi.mapper;

import com.manutencaopredialapi.dto.EquipamentoRequestDTO;
import com.manutencaopredialapi.dto.EquipamentoResponseDTO;
import com.manutencaopredialapi.model.Equipamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EquipamentoMapper {

    @Mapping(target = "predio", ignore = true)
    Equipamento toEntity(EquipamentoRequestDTO dto);

    @Mapping(target = "predioId", source = "predio.id")
    EquipamentoResponseDTO toResponseDTO(Equipamento entity);
}
