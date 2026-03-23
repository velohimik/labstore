package com.velohimik.labstore.repositories;

import com.velohimik.labstore.domain.entities.ReagentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReagentRepository extends JpaRepository<ReagentEntity, UUID> {
}
