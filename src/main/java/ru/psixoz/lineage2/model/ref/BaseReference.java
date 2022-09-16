package ru.psixoz.lineage2.model.ref;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseReference {

    @Id
    @Column(name = "CODE", nullable = false, unique = true, updatable = false)
    protected String code;

    @Column(name = "DESCRIPTION")
    protected String description;

    protected BaseReference(String code, String name) {
        this.code = code;
        this.description = name;
    }
}
