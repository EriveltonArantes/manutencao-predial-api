package com.manutencaopredialapi.mapper;

import com.manutencaopredialapi.dto.TecnicoRequestDTO;
import com.manutencaopredialapi.dto.TecnicoResponseDTO;
import com.manutencaopredialapi.model.Tecnico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {

    Tecnico toEntity(TecnicoRequestDTO dto);

    TecnicoResponseDTO toResponseDTO(Tecnico entity);
}
