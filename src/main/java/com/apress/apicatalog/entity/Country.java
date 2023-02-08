package com.apress.apicatalog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country extends Base implements Serializable {
    @Column(name = "code", nullable = false, length = 4)
    private String code;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "locale", nullable = false, length = 6)
    private String locale;
    @Column(name = "time_zone", nullable = false, length = 10)
    private String timezone;
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, updatable = false, insertable = false)
    @OrderBy(value = "name")
    private List<State> state;

    @Embedded
    private Audit audit;

//    @Enumerated(EnumType.STRING)
//    private Continent continent;

}
