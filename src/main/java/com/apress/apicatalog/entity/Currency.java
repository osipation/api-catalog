package com.apress.apicatalog.entity;

import jakarta.persistence.*;
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

    private String code;

    private String symbol;

    private String description;

    private Boolean enabled;

    @Column(name = "decimal_places")
    private int decimalPlaces;

    @Embedded
    private Audit audit;
}
