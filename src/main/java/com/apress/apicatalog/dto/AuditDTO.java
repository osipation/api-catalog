package com.apress.apicatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditDTO implements Serializable {

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

}
