package ru.psixoz.lineage2.model.ref;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "ENCHANT_REFERENCE")
public class Enchant extends BaseReference {
}
