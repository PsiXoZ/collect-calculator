package ru.psixoz.lineage2.port.out;

import ru.psixoz.lineage2.model.ref.LineageServerType;
import ru.psixoz.lineage2.model.user.CollectionStatus;

import java.util.Collection;
import java.util.Optional;

public interface CollectionStatusRepository {

    CollectionStatus save(CollectionStatus collectionStatus);

    Optional<CollectionStatus> findByCharacterIdAndCollectionTemplateId(Long characterId, Long CollectionTemplateId);

    Collection<CollectionStatusShortInfo> getCollectionsStatusByCharacterIdAndServerType(Long characterId, String serverType);


    interface CollectionStatusShortInfo {
        Long getCharacterId();
        Long getCollectionTemplateId();
        boolean isCollectionComplete();
        Long getItemTemplateId();

    }
}
