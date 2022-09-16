package ru.psixoz.lineage2.model.ref;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class BaseReference {

    @Id
    @Column(name = "CODE", nullable = false, unique = true, updatable = false)
    protected String code;

    @Column(name = "DESCRIPTION")
    protected String description;
}
