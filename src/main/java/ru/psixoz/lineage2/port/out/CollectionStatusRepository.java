package ru.psixoz.lineage2.port.out;

import ru.psixoz.lineage2.model.user.CollectionStatus;

import java.util.Optional;

public interface CollectionStatusRepository {

    CollectionStatus save(CollectionStatus collectionStatus);

    Optional<CollectionStatus> findByCharacterIdAndCollectionTemplateId(Long characterId, Long CollectionTemplateId);
}
