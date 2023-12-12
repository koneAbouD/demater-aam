package com.demater.core.domain.document;

import lombok.*;

import java.util.UUID;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Document {
    private UUID id;
    private String businessKey;
    private String designation;
}
