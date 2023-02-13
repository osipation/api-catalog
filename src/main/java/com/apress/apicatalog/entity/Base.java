package com.apress.apicatalog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Audit audit;

    @Version
    private Long version;

    @PrePersist
    public void fillCreatedOn() {
        audit.setCreatedOn(LocalDateTime.now());
    }
    @PreUpdate
    public void fillUpdatedOn() {
        audit.setUpdatedOn(LocalDateTime.now());
    }
}
