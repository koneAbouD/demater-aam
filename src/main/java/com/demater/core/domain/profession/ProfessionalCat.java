package com.demater.core.domain.profession;

import com.demater.core.domain.common.CodeNameAbstract;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProfessionalCat extends CodeNameAbstract {
    private Long id;
}