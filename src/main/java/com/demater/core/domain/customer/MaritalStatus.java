package com.demater.core.domain.customer;

import com.demater.core.domain.common.CodeNameAbstract;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MaritalStatus extends CodeNameAbstract {
    private Long id;
}