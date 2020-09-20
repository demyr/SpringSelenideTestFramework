package com.pojos.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(exclude = {"createdAt", "updatedAt"})
public class AuditDTO {
    private String createdAt;
    private String updatedAt;
}
