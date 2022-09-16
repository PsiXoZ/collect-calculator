package ru.psixoz.lineage2.model.ref;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "ITEM_TYPE_REFERENCE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemType extends BaseReference {

    public ItemType(String code, String description) {
        super(code, description);
    }
}
