package com.example.labstore.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReagentType {

    ACID("A"),
    CAUSTIC("C"),
    SOLVENT("S"),
    API("I"),
    EXCIPIENT("E");

    private final String abbreviation;
}
