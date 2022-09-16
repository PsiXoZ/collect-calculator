package ru.psixoz.lineage2.model.template;


import lombok.Getter;
import ru.psixoz.lineage2.model.BaseEntity;
import ru.psixoz.lineage2.model.ref.Enchant;
import ru.psixoz.lineage2.model.template.Item;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "ITEM_TEMPLATE")
public class ItemTemplate extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COLLECTION_TEMPLATE_ID")
    CollectionTemplate collectionTemplate;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
            @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    Item item;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
            @JoinColumn(name = "ENCHANT_CODE", referencedColumnName = "CODE")
    Enchant enchant;

}
