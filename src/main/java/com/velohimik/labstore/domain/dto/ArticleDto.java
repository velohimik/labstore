package com.velohimik.labstore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private UUID id;
    private String code;
    private UUID reagentId;
    private Double pureness;
    private String manufacturer;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
