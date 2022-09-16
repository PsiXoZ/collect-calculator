package ru.psixoz.lineage2.model.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@RequiredArgsConstructor
@Table(name = "ITEM_STATUS")
public class ItemStatus {

    @Column(name = "COLLECTION_STATUS_ID")
    final Long collectionStatusId;

    @Column(name = "ITEM_TEMPLATE_ID")
    final Long itemTemplateId;

    @Setter
    boolean complete;
}
