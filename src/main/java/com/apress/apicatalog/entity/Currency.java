package com.apress.apicatalog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "currency")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency extends Base implements Serializable {

    @NotBlank(message = "Code is mandatory")
    @Column(name = "code", nullable = false, length = 4)
    private String code;

    @NotBlank(message = "Symbol is mandatory")
    @Column(name = "symbol", nullable = false, length = 4)
    private String symbol;

    @NotBlank(message = "Description is mandatory")
    @Column(name = "description", nullable = false, length = 30)
    private String description;

    @NotNull(message = "The state of the currency is mandatory")
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = Boolean.TRUE;

    @Min(value = 1, message = "The minimum value is 1")
    @Max(value = 5, message = "The maximum value is 5")
    @Column(name = "decimal_places")
    private int decimalPlaces;

}
