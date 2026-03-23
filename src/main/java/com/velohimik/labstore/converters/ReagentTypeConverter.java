package com.velohimik.labstore.converters;

import com.velohimik.labstore.domain.enums.ReagentType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.Objects;

@Converter(autoApply = true)
public class ReagentTypeConverter implements AttributeConverter<ReagentType, String> {

    @Override
    public String convertToDatabaseColumn(ReagentType reagentType) {
        if (Objects.isNull(reagentType)) {
            return null;
        }
        return reagentType.getAbbreviation();
    }

    @Override
    public ReagentType convertToEntityAttribute(String abbreviation) {
        if (Objects.isNull(abbreviation)) {
            return null;
        }
        return Arrays.stream(ReagentType.values())
                .filter(reagentType -> reagentType.getAbbreviation().equals(abbreviation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown Reagent type"));
    }
}
