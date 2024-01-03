package com.demater.core.domain.profession;

import com.demater.core.domain.CodeNameAbstract;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CatProfessionnelle extends CodeNameAbstract {
    private Long id;
}
