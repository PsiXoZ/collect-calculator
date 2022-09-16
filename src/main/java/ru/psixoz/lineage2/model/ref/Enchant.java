package ru.psixoz.lineage2.model.ref;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "ENCHANT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Enchant extends BaseReference {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ENCHANT_TYPE_CODE", referencedColumnName = "CODE")
    EnchantType type;

    public Enchant(String code, String value, EnchantType type) {
        super(code, value);
        this.type = type;
    }

    public String getValue() {
        return description;
    }
}
