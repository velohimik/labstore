package com.example.labstore.services.impl;

import com.example.labstore.domain.dto.ReagentDto;
import com.example.labstore.domain.entities.ReagentEntity;
import com.example.labstore.mappers.Mapper;
import com.example.labstore.repositories.ReagentRepository;
import com.example.labstore.services.ReagentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class ReagentServiceImpl implements ReagentService {

    private final ReagentRepository reagentRepository;
    private final Mapper<ReagentDto, ReagentEntity> mapper;

    public ReagentServiceImpl(ReagentRepository reagentRepository, Mapper<ReagentDto, ReagentEntity> mapper) {
        this.reagentRepository = reagentRepository;
        this.mapper = mapper;
    }

    @Override
    public ReagentDto createReagent(ReagentDto reagentDto) {
        ReagentEntity reagentEntity = mapper.mapToEntity(reagentDto);
        reagentEntity.setId(UUID.randomUUID());
        reagentEntity.setCreatedDate(LocalDateTime.now());
        reagentEntity.setUpdatedDate(LocalDateTime.now());
        ReagentEntity savedReagentEntity = reagentRepository.save(reagentEntity);

        return mapper.mapToDto(savedReagentEntity);
    }

    @Override
    public List<ReagentDto> findAllReagents() {
        return StreamSupport
                .stream(reagentRepository.findAll().spliterator(), false)
                .map(mapper::mapToDto)
                .toList();
    }

    @Override
    public Optional<ReagentDto> getOneReagent(UUID id) {
        Optional<ReagentEntity> reagentById = reagentRepository.findById(id);

        return reagentById.map(mapper::mapToDto);
    }

    @Override
    public Optional<ReagentDto> updateOneReagentWith(ReagentDto reagentDto, UUID id) {
        Optional<ReagentEntity> foundReagentEntity = reagentRepository.findById(id);
        if (foundReagentEntity.isPresent()) {
            ReagentEntity reagentEntity = mapper.mapToEntity(reagentDto);
            reagentEntity.setId(id);
            reagentEntity.setCreatedDate(foundReagentEntity.get().getCreatedDate());
            reagentEntity.setUpdatedDate(LocalDateTime.now());
            ReagentEntity updatedReagentEntity = reagentRepository.save(reagentEntity);

            return Optional.of(mapper.mapToDto(updatedReagentEntity));
        }

        return Optional.empty();
    }

    @Override
    public void deleteOneReagent(UUID id) {
        reagentRepository.deleteById(id);
    }
}
