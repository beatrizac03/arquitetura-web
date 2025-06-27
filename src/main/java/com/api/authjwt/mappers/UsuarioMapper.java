package com.api.authjwt.mappers;

import org.mapstruct.Mapper;

import com.api.authjwt.DTOs.UsuarioRequestDto;
import com.api.authjwt.models.Usuario;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "id", ignore = true)
    Usuario toEntity(UsuarioRequestDto dto);

    UsuarioRequestDto toDto(Usuario produto);
}
