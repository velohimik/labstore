package com.velohimik.labstore.domain.embedders;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HazardClass {

    private Integer flammability;
    private Integer health;
    private Integer instability;
    private String specials;
}
