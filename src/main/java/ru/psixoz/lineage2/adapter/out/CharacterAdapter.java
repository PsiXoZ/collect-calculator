package ru.psixoz.lineage2.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.psixoz.lineage2.model.ref.LineageServerType;
import ru.psixoz.lineage2.model.user.Character;
import ru.psixoz.lineage2.port.out.CharacterRepository;

import java.util.Collection;
import java.util.Optional;

public interface CharacterAdapter extends CharacterRepository, JpaRepository<Character, Long> {


    @Query(nativeQuery = true, value = "" +
            "SELECT ct.ID AS \"COLLECTIONID\",\n" +
            "       ct.COLLECTION_NAME AS \"COLLECTIONNAME\",\n" +
            "       ct.COLLECTION_TYPE AS \"COLLECTIONTYPE\",\n" +
            "       bd.DESCRIPTION || ':' || e.DESCRIPTION AS \"COLLECTIONBONUS\",\n" +
            "       it.ID AS \"ITEMID\",\n" +
            "       i.NAME || ' - ' || itp.DESCRIPTION AS \"ITEMNAME\",\n" +
            "       e1.DESCRIPTION AS \"ITEMENCHANT\",\n" +
            "       e1.ENCHANT_TYPE AS \"ITEMENCHANTTYPE\"\n" +
            "FROM COLLECTION_TEMPLATE ct\n" +
            "    JOIN COLLECTION_BONUS cb ON cb.ID = ct.COLLECTION_BONUS_ID\n" +
            "    JOIN ENCHANT e ON e.CODE = cb.ENCHANT_CODE\n" +
            "    JOIN BONUS_DESCRIPTION bd ON bd.CODE = cb.BONUS_DESCRIPTION_CODE\n" +
            "    JOIN COLLECTIONS_ITEMS ci ON ct.ID = ci.COLLECTION_TEMPLATE_ID\n" +
            "    JOIN ITEM_TEMPLATE it ON it.ID = ci.ITEM_TEMPLATE_ID\n" +
            "    JOIN ITEM i ON i.ID = it.ITEM_ID\n" +
            "    JOIN ENCHANT e1 ON e1.CODE = it.ENCHANT_CODE\n" +
            "    JOIN ITEM_TYPE itp ON itp.CODE = it.TYPE_CODE\n" +
            "WHERE ct.LINEAGE_TYPE = :serverType")
    Collection<GetCharacterCollectionDto> getCollectionsByServerType(String serverType);





}
