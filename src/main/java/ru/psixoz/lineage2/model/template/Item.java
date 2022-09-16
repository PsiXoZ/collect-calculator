package ru.psixoz.lineage2.model.template;

import lombok.Getter;
import ru.psixoz.lineage2.model.BaseEntity;
import ru.psixoz.lineage2.model.ref.ItemType;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "ITEM")
public class Item extends BaseEntity {

    @Column(name = "ITEM_NAME")
    String name;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_TYPE_CODE", referencedColumnName = "CODE")
    ItemType itemType;


}
