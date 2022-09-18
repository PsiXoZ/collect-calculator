package ru.psixoz.lineage2.model.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.psixoz.lineage2.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ITEM_STATUS")
public class ItemStatus extends BaseEntity {

    @Column(name = "COLLECTION_STATUS_ID")
    Long collectionStatusId;

    @Column(name = "ITEM_TEMPLATE_ID")
    Long itemTemplateId;

    boolean complete;
}
