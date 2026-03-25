package com.velohimik.labstore.utils;

import com.velohimik.labstore.domain.entities.ArticleEntity;
import com.velohimik.labstore.domain.entities.ReagentEntity;

import java.util.Comparator;
import java.util.List;

public class ArticleCodeGenerator {

    private static final String INITIAL_REAGENT_CODE = "001";
    private static final String INITIAL_ARTICLE_CODE = "01";

    public static String generateArticleCode(List<ArticleEntity> existingArticles, ReagentEntity referencedReagentEntity) {
        List<ArticleEntity> existingArticlesOfReagentType = existingArticles.stream()
                .filter(articleEntity -> articleEntity.getReagentEntity()
                        .getReagentType()
                        .equals(referencedReagentEntity.getReagentType()))
                .toList();

        if (existingArticlesOfReagentType.isEmpty()) {
            return String.format(
                    "%s%s%s",
                    referencedReagentEntity.getReagentType().getAbbreviation(),
                    INITIAL_REAGENT_CODE,
                    INITIAL_ARTICLE_CODE);
        }

        List<ArticleEntity> existingArticlesOfReagent = existingArticles.stream()
                .filter(articleEntity -> articleEntity.getReagentEntity().equals(referencedReagentEntity))
                .toList();

        if (existingArticlesOfReagent.isEmpty()) {
            String lastArticleCodeOfReagent = existingArticlesOfReagentType.stream().max(Comparator.comparing(ArticleEntity::getCode)).map(articleEntity -> articleEntity.getCode().substring(1, 4)).orElseThrow();
            String nextArticleCodeOfReagent = String.format("%03d", Integer.parseInt(lastArticleCodeOfReagent) + 1);
            return String.format(
                    "%s%s%s",
                    referencedReagentEntity.getReagentType().getAbbreviation(),
                    nextArticleCodeOfReagent,
                    INITIAL_ARTICLE_CODE);
        } else {
            String lastArticleCode = existingArticlesOfReagent.stream().max(Comparator.comparing(ArticleEntity::getCode)).map(ArticleEntity::getCode).orElseThrow();
            String startArticleCode = lastArticleCode.substring(0, 4);
            String endArticleCode = String.format("%02d", Integer.parseInt(lastArticleCode.substring(4)) + 1);
            return String.format("%s%s", startArticleCode, endArticleCode);
        }

    }
}
