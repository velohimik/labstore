package com.velohimik.labstore.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "articles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleEntity {

    @Id
    private UUID id;

    @Basic(optional = false)
    @Column(unique = true)
    @Immutable
    private String code;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reagent_id")
    private ReagentEntity reagentEntity;

    @Basic(optional = false)
    private Double pureness;

    @Basic(optional = false)
    private String manufacturer;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;
}
