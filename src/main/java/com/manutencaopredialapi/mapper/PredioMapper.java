package com.manutencaopredialapi.mapper;

import com.manutencaopredialapi.dto.PredioRequestDTO;
import com.manutencaopredialapi.dto.PredioResponseDTO;
import com.manutencaopredialapi.model.Predio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PredioMapper {

    Predio toEntity(PredioRequestDTO dto);

    PredioResponseDTO toResponseDTO(Predio entity);
}
