package ru.psixoz.lineage2.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.psixoz.lineage2.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "COLLECTION_STATUS")
@RequiredArgsConstructor
public class CollectionStatus extends BaseEntity {

    @Column(name = "CHARACTER_ID")
    final Long characterId;

    @Column(name = "COLLECTION_TEMPLATE_ID")
    final Long collectionTemplateId;

    @Setter
    boolean complete;
}
