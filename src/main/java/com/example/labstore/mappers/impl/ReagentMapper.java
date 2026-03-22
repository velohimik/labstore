package com.example.labstore.mappers.impl;

import com.example.labstore.domain.dto.ReagentDto;
import com.example.labstore.domain.entities.ReagentEntity;
import com.example.labstore.domain.enums.ReagentType;
import com.example.labstore.mappers.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class ReagentMapper implements Mapper<ReagentDto, ReagentEntity> {

    private final ModelMapper modelMapper;

    public ReagentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ReagentEntity mapToEntity(ReagentDto reagentDto) {
        Converter<ReagentType, String> typeToAbbreviation = mappingContext ->
                mappingContext.getSource() == null ? null : mappingContext.getSource().getAbbreviation();
        modelMapper.addConverter(typeToAbbreviation, ReagentType.class, String.class);
        return modelMapper.map(reagentDto, ReagentEntity.class);
    }

    @Override
    public ReagentDto mapToDto(ReagentEntity reagentEntity) {
        Converter<String, ReagentType> abbreviationToType = mappingContext ->
                mappingContext.getSource() == null ? null : Arrays
                        .stream(ReagentType.values())
                        .filter(reagentType -> reagentType.getAbbreviation().equals(mappingContext.getSource()))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Unknown Reagent Type value"));
        modelMapper.addConverter(abbreviationToType, String.class, ReagentType.class);
        return modelMapper.map(reagentEntity, ReagentDto.class);
    }
}
