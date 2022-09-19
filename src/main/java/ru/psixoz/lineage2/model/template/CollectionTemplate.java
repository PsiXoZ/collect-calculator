package ru.psixoz.lineage2.model.template;


import lombok.Getter;
import lombok.Setter;
import ru.psixoz.lineage2.model.BaseEntity;
import ru.psixoz.lineage2.model.ref.CollectionType;
import ru.psixoz.lineage2.model.ref.LineageServerType;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "COLLECTION_TEMPLATE")
public class CollectionTemplate extends BaseEntity {

    @Column(name = "COLLECTION_NAME")
    @Setter
    String name;

    @Column(name = "COLLECTION_TYPE")
    @Setter
    @Enumerated(EnumType.STRING)
    CollectionType collectionType;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "COLLECTION_BONUS_ID", referencedColumnName = "ID")
    @Setter
    CollectionBonus collectionBonus;

    @Column(name = "LINEAGE_TYPE")
    @Enumerated(EnumType.STRING)
    @Setter
    LineageServerType serverType;


    final CollectionItems itemsCollection = new CollectionItems(this);





}
