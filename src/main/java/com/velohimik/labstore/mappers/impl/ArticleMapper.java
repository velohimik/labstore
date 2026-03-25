package com.velohimik.labstore.mappers.impl;

import com.velohimik.labstore.domain.dto.ArticleDto;
import com.velohimik.labstore.domain.entities.ArticleEntity;
import com.velohimik.labstore.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper implements Mapper<ArticleDto, ArticleEntity> {

    private final ModelMapper modelMapper;

    public ArticleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ArticleEntity mapToEntity(ArticleDto articleDto) {
        return modelMapper.map(articleDto, ArticleEntity.class);
    }

    @Override
    public ArticleDto mapToDto(ArticleEntity articleEntity) {
        return modelMapper.map(articleEntity, ArticleDto.class);
    }
}
