package com.velohimik.labstore.domain.entities;

import com.velohimik.labstore.domain.embedders.HazardClass;
import com.velohimik.labstore.domain.enums.ReagentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
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
    private ReagentType reagentType;

    @Embedded
    private HazardClass hazardClass;

    @Column(name = "create_date")
    private Timestamp createdDate;

    @Column(name = "update_date")
    private Timestamp updatedDate;
}
