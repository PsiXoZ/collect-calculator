package ru.psixoz.lineage2.model.template;

import lombok.Getter;
import lombok.Setter;
import ru.psixoz.lineage2.model.BaseEntity;
import ru.psixoz.lineage2.model.ref.ItemType;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "ITEM")
public class Item extends BaseEntity {

    @Column(name = "NAME")
    @Setter
    String name;

}
