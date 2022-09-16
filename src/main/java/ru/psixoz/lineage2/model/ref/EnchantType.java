package ru.psixoz.lineage2.model.ref;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "ENCHANT_TYPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EnchantType extends BaseReference {

    public EnchantType(String code, String name) {
        super(code, name);
    }
}
