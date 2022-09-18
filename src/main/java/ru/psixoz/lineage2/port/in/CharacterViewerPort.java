package ru.psixoz.lineage2.port.in;

import lombok.Builder;
import lombok.Value;
import org.springframework.validation.annotation.Validated;
import ru.psixoz.lineage2.model.ref.CollectionType;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Validated
public interface CharacterViewerPort {

    GetCharacterCollectionStatusResponse getCharacterCollections(@NotNull Long characterId);

    @Value
    @Builder
    class GetCharacterCollectionStatusResponse {
        Long characterId;
        Collection<CollectionStatusProjection> collections;
    }

    @Value
    @Builder
    class CollectionStatusProjection {
        Long collectionId;
        String collectionName;
        String collectionBonus;
        CollectionType collectionType;
        Collection<ItemStatusProjection> items;
        boolean complete;
    }


    @Value
    @Builder
    class ItemStatusProjection {
        Long itemId;
        String itemName;
        boolean complete;
    }
}
