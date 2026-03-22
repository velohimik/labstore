package com.example.labstore.repositories;

import com.example.labstore.domain.entities.ReagentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReagentRepository extends CrudRepository<ReagentEntity, UUID> {
}
