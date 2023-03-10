package com.apress.apicatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDTO {

    private Long id;

    private String code;

    private String symbol;

    private String description;

    private Boolean enabled;

    private Integer decimalPlaces;

    private AuditDTO audit;

    private Long version;

}
