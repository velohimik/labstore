package com.velohimik.labstore.mappers.impl;

import com.velohimik.labstore.domain.dto.ReagentDto;
import com.velohimik.labstore.domain.entities.ReagentEntity;
import com.velohimik.labstore.mappers.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReagentMapper implements Mapper<ReagentDto, ReagentEntity> {

    private final ModelMapper modelMapper;

    public ReagentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ReagentEntity mapToEntity(ReagentDto reagentDto) {
        return modelMapper.map(reagentDto, ReagentEntity.class);
    }

    @Override
    public ReagentDto mapToDto(ReagentEntity reagentEntity) {
        return modelMapper.map(reagentEntity, ReagentDto.class);
    }
}
