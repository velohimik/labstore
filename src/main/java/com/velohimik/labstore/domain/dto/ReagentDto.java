package com.velohimik.labstore.domain.dto;

import com.velohimik.labstore.domain.embedders.HazardClass;
import com.velohimik.labstore.domain.enums.ReagentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
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
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
