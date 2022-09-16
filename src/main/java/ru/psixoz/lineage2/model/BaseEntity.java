package ru.psixoz.lineage2.model;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreationTimestamp
    @Column(name = "CREATED_ON", nullable = false, updatable = false)
    Instant createdOn;

    @UpdateTimestamp
    @Column(name = "UPDATED_ON", nullable = false)
    Instant updateOn;

    @Version
    Long version;
}
