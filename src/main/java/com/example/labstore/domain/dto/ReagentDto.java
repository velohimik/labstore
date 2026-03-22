package com.example.labstore.domain.dto;

import com.example.labstore.domain.embedders.HazardClass;
import com.example.labstore.domain.enums.ReagentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReagentDto {

    private UUID id;
    private String casNumber;
    private String name;
    private String formula;
    private Double molecularWeight;
    private ReagentType reagentType;
    private HazardClass hazardClass;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
