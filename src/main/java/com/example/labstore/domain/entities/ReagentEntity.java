package com.example.labstore.domain.entities;

import com.example.labstore.domain.embedders.HazardClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reagents")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReagentEntity {

    @Id
    private UUID id;

    @Basic(optional = false)
    @Column(unique = true)
    private String casNumber;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String formula;

    @Basic(optional = false)
    private Double molecularWeight;

    @Basic(optional = false)
    private String reagentType;

    @Embedded
    private HazardClass hazardClass;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
