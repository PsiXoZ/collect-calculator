package ru.psixoz.lineage2.port.out;

import ru.psixoz.lineage2.model.user.ItemStatus;

import java.util.Collection;
import java.util.Optional;

public interface ItemStatusRepository {

    ItemStatus save(ItemStatus itemStatus);

    Optional<ItemStatus> findByCollectionStatusIdAndItemTemplateId(Long collectionStatusId, Long itemStatusId);

    Collection<ItemStatus> findByCollectionStatusIdAndComplete(Long id, boolean complete);
}
