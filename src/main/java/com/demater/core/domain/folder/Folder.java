package com.demater.core.domain.folder;

import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Folder {
    private UUID id;
    private String businessKey;
    private String designation;
}
