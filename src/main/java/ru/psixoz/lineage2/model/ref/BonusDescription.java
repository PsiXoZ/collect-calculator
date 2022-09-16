package ru.psixoz.lineage2.model.ref;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "BONUS_DESCRIPTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BonusDescription extends BaseReference {

    public BonusDescription(String code, String name) {
        super(code, name);
    }
}
