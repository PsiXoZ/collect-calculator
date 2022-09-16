package ru.psixoz.lineage2.model.template;


import lombok.Getter;
import lombok.Setter;
import ru.psixoz.lineage2.model.BaseEntity;
import ru.psixoz.lineage2.model.ref.Enchant;
import ru.psixoz.lineage2.model.ref.ItemType;
import ru.psixoz.lineage2.model.template.Item;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ITEM_TEMPLATE")
public class ItemTemplate extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    Item item;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "ENCHANT_CODE", referencedColumnName = "CODE")
    Enchant enchant;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "TYPE_CODE", referencedColumnName = "CODE")
    ItemType type;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "COLLECTIONS_ITEMS",
            joinColumns = {@JoinColumn(name = "ITEM_TEMPLATE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COLLECTION_TEMPLATE_ID")}
    )
    Set<CollectionTemplate> collections = new HashSet<>();

}
