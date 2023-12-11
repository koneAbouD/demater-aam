package com.demater.core.domain.gadget;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class GadgetType {
    private Long id;
    private String designation;

    public GadgetType(String designation) {
        this.designation = designation;
    }

    public void update(String designation) {
        this.designation = designation;
    }
}
