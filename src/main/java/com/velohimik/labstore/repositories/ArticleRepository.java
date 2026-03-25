package com.velohimik.labstore.repositories;

import com.velohimik.labstore.domain.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID> {

    @Query("SELECT a FROM ArticleEntity a WHERE a.reagentEntity.id = ?1")
    List<ArticleEntity> findByReagentId(UUID reagentId);
}
