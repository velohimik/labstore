package com.velohimik.labstore.services.impl;

import com.velohimik.labstore.domain.dto.ArticleDto;
import com.velohimik.labstore.domain.entities.ArticleEntity;
import com.velohimik.labstore.domain.entities.ReagentEntity;
import com.velohimik.labstore.mappers.Mapper;
import com.velohimik.labstore.repositories.ArticleRepository;
import com.velohimik.labstore.repositories.ReagentRepository;
import com.velohimik.labstore.services.ArticleService;
import com.velohimik.labstore.utils.ArticleCodeGenerator;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ReagentRepository reagentRepository;
    private final Mapper<ArticleDto, ArticleEntity> mapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ReagentRepository reagentRepository, Mapper<ArticleDto, ArticleEntity> mapper) {
        this.articleRepository = articleRepository;
        this.reagentRepository = reagentRepository;
        this.mapper = mapper;
    }

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        ArticleEntity articleEntity = mapper.mapToEntity(articleDto);
        articleEntity.setId(UUID.randomUUID());
        ReagentEntity referenceReagentEntity = reagentRepository.findById(articleDto.getReagentId()).orElseThrow();
        articleEntity.setReagentEntity(referenceReagentEntity);
        articleEntity.setCode(ArticleCodeGenerator.generateArticleCode(articleRepository.findAll(), referenceReagentEntity));
        articleEntity.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        articleEntity.setUpdatedDate(articleEntity.getCreatedDate());
        ArticleEntity savedArticleEntity = articleRepository.save(articleEntity);
        return mapper.mapToDto(savedArticleEntity);
    }

    @Override
    public List<ArticleDto> findAllArticles() {
        return articleRepository.findAll().stream().map(mapper::mapToDto).toList();
    }

    @Override
    public List<ArticleDto> findAllArticlesByReagentId(UUID reagentId) {
        return articleRepository.findByReagentId(reagentId).stream().map(mapper::mapToDto).toList();
    }

    @Override
    public Optional<ArticleDto> getOneArticle(UUID id) {
        return articleRepository.findById(id).map(mapper::mapToDto);
    }

    @Override
    public Optional<ArticleDto> updateOneArticleWith(ArticleDto articleDto, UUID id) {
        Optional<ArticleEntity> foundArticleEntity = articleRepository.findById(id);
        if (foundArticleEntity.isPresent()) {
            ArticleEntity articleEntity = mapper.mapToEntity(articleDto);
            articleEntity.setId(id);
            articleEntity.setCreatedDate(foundArticleEntity.get().getCreatedDate());
            articleEntity.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
            ArticleEntity updatedArticleEntity = articleRepository.save(articleEntity);
            return Optional.of(mapper.mapToDto(updatedArticleEntity));
        }

        return Optional.empty();
    }

    @Override
    public void deleteOneArticle(UUID id) {
        articleRepository.deleteById(id);
    }
}
