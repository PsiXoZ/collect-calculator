package ru.psixoz.lineage2.model.ref;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "ENCHANT_REFERENCE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Enchant extends BaseReference {

    public Enchant(String code, String description) {
        super(code, description);
    }
}
