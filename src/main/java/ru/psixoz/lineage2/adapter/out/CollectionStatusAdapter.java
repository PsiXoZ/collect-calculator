package ru.psixoz.lineage2.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.psixoz.lineage2.model.ref.LineageServerType;
import ru.psixoz.lineage2.model.user.CollectionStatus;
import ru.psixoz.lineage2.port.out.CollectionStatusRepository;

import java.util.Collection;

public interface CollectionStatusAdapter extends CollectionStatusRepository, JpaRepository<CollectionStatus, Long> {

    @Query(nativeQuery = true, value = "" +
            "SELECT cs.COLLECTION_TEMPLATE_ID AS \"COLLECTIONTEMPLATEID\",\n" +
            "       cs.COMPLETE AS \"COLLECTIONCOMPLETE\"," +
            "       its.ITEM_TEMPLATE_ID AS \"ITEMTEMPLATEID\"\n" +
            "FROM COLLECTION_STATUS cs\n" +
            "   JOIN COLLECTION_TEMPLATE ct ON cs.COLLECTION_TEMPLATE_ID = ct.ID\n" +
            "   JOIN ITEM_STATUS its ON its.COLLECTION_STATUS_ID = cs.ID\n" +
            "WHERE cs.CHARACTER_ID = :characterId\n " +
            "   AND ct.LINEAGE_TYPE = :serverType")
    Collection<CollectionStatusShortInfo> getCollectionsStatusByCharacterIdAndServerType(Long characterId, String serverType);

}
