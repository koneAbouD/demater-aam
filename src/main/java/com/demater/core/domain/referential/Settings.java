package com.demater.core.domain.referential;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Settings {
    private Long id;
    private ESetting name;
    private String value;
}
