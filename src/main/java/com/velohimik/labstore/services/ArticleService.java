package com.velohimik.labstore.services;

import com.velohimik.labstore.domain.dto.ArticleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArticleService {

    ArticleDto createArticle(ArticleDto articleDto);

    List<ArticleDto> findAllArticles();

    List<ArticleDto> findAllArticlesByReagentId(UUID reagentId);

    Optional<ArticleDto> getOneArticle(UUID id);

    Optional<ArticleDto> updateOneArticleWith(ArticleDto articleDto, UUID id);

    void deleteOneArticle(UUID id);
}
