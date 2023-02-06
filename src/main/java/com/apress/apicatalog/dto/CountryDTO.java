package com.apress.apicatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO implements Serializable {

    private Long id;

    private String code;

    private String name;

    private String locale;

    private String timezone;

    private Boolean enabled;

    private CurrencyDTO currency;

    private List<StateDTO> state;

}
