package com.example.labstore.controllers;

import com.example.labstore.domain.dto.ReagentDto;
import com.example.labstore.services.ReagentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ReagentController {

    private final ReagentService reagentService;

    public ReagentController(ReagentService reagentService) {
        this.reagentService = reagentService;
    }

    @PostMapping(path = "/reagents")
    public ResponseEntity<ReagentDto> createNewReagent(@RequestBody ReagentDto reagentDto) {
        return new ResponseEntity<>(reagentService.createReagent(reagentDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/reagents")
    public List<ReagentDto> getAllReagents() {
        return reagentService.findAllReagents();
    }

    @GetMapping(path = "/reagents/{id}")
    public ResponseEntity<ReagentDto> getOneReagent(@PathVariable("id") UUID id) {
        Optional<ReagentDto> returnedReagentDto = reagentService.getOneReagent(id);
        return returnedReagentDto
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "reagents/{id}")
    public ResponseEntity<ReagentDto> updateOneReagent(@RequestBody ReagentDto reagentDto, @PathVariable("id") UUID id) {
        Optional<ReagentDto> updatedReagentDto = reagentService.updateOneReagentWith(reagentDto, id);
        return updatedReagentDto
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "reagents/{id}")
    public ResponseEntity<ReagentDto> deleteOneReagent(@PathVariable("id") UUID id) {
        Optional<ReagentDto> foundReagentDto = reagentService.getOneReagent(id);
        if (foundReagentDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            reagentService.deleteOneReagent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }
}
