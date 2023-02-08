package com.apress.apicatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDTO implements Serializable {

    private Long id;

    private String code;

    private String name;

    private Boolean enabled;

    private CountryDTO country;

    private AuditDTO audit;

}
