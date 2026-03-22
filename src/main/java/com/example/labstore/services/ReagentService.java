package com.example.labstore.services;

import com.example.labstore.domain.dto.ReagentDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReagentService {

    ReagentDto createReagent(ReagentDto reagentDto);

    List<ReagentDto> findAllReagents();

    Optional<ReagentDto> getOneReagent(UUID id);

    Optional<ReagentDto> updateOneReagentWith(ReagentDto reagentDto, UUID id);

    void deleteOneReagent(UUID id);
}
