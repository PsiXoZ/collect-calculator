package ru.psixoz.lineage2.model.ref;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "ITEM_TYPE_REFERENCE")
public class ItemType extends BaseReference {
}
