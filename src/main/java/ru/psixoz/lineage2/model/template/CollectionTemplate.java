package ru.psixoz.lineage2.model.template;


import lombok.Getter;
import ru.psixoz.lineage2.model.BaseEntity;
import ru.psixoz.lineage2.model.ref.CollectionType;
import ru.psixoz.lineage2.model.template.CollectionItems;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "COLLECTION_TEMPLATE")
public class CollectionTemplate extends BaseEntity {

    @Column(name = "COLLECTION_NAME")
    String name;

    @Column(name = "COLLECTION_DESCRIPTION")
    String description;

    @Column(name = "COLLECTION_TYPE")
    @Enumerated(EnumType.STRING)
    CollectionType collectionType;


    final CollectionItems items = new CollectionItems(this);

}
