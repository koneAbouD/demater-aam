package com.demater.core.domain.document;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Document {
    private Long id;
    private String businessKey;
    private String docCode;
    private String docPath;
    private String designation;
    private String name;
    private String description;
    private int numberOfCopies;
    private String metaData;
    private String type;
    private String status;
    private Boolean optional;
    private String contentType;
}
