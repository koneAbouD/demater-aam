package com.demater.core.domain.customer;

import com.demater.core.domain.CodeNameAbstract;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CustomerType extends CodeNameAbstract {
    private Long id;
}