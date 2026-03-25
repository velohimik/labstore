package com.velohimik.labstore.controllers;

import com.velohimik.labstore.domain.dto.ArticleDto;
import com.velohimik.labstore.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping(path = "/articles")
    public ResponseEntity<ArticleDto> createNewArticle(@RequestBody ArticleDto articleDto) {
        return new ResponseEntity<>(articleService.createArticle(articleDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/articles")
    public List<ArticleDto> getAllArticles(@RequestParam(name = "reagentId", required = false) UUID reagentId) {
        if (Objects.isNull(reagentId)) {
            return articleService.findAllArticles();
        } else {
            return articleService.findAllArticlesByReagentId(reagentId);
        }
    }

    @GetMapping(path = "/articles/{id}")
    public ResponseEntity<ArticleDto> getOneArticle(@PathVariable("id") UUID id) {
        Optional<ArticleDto> returnedArticleDto = articleService.getOneArticle(id);
        return returnedArticleDto
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "articles/{id}")
    public ResponseEntity<ArticleDto> updateOneArticle(@RequestBody ArticleDto articleDto, @PathVariable("id") UUID id) {
        Optional<ArticleDto> updatedArticleDto = articleService.updateOneArticleWith(articleDto, id);
        return updatedArticleDto
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "articles/{id}")
    public ResponseEntity<ArticleDto> deleteOneArticle(@PathVariable("id") UUID id) {
        Optional<ArticleDto> foundArticleDto = articleService.getOneArticle(id);
        if (foundArticleDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            articleService.deleteOneArticle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
